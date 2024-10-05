package exam.service.impl;

import com.google.gson.Gson;
import exam.model.entity.Customer;
import exam.model.entity.Laptop;
import exam.model.service.json.CustomerDetailsModel;
import exam.model.service.json.LaptopDetailsModel;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {
  private static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";
  private final LaptopRepository laptopRepository;
  private final ModelMapper modelMapper;
  private final Gson gson;
  private final ValidationUtil validationUtil;
  private final ShopService shopService;

  public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, ShopService shopService) {
    this.laptopRepository = laptopRepository;
    this.modelMapper = modelMapper;
    this.gson = gson;
    this.validationUtil = validationUtil;
    this.shopService = shopService;
  }

  @Override
  public boolean areImported() {
    return this.laptopRepository.count() > 0;
  }

  @Override
  public String readLaptopsFileContent() throws IOException {
    return Files.readString(Path.of(LAPTOPS_FILE_PATH));
  }

  @Override
  public String importLaptops() throws IOException {
    StringBuilder sb = new StringBuilder();

    Arrays.stream(this.gson.fromJson(readLaptopsFileContent(), LaptopDetailsModel[].class))
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              if (macAddressAlreadyExists(dto)) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                      dto.getMacAddress(),
                      dto.getCpuSpeed(),
                      dto.getRam(),
                      dto.getStorage())
                      : "Invalid Laptop")
                      .append(System.lineSeparator());

              return isValid;
            }).map(dto -> {
      Laptop entity = this.modelMapper.map(dto, Laptop.class);

      entity.setShop(this.shopService.findShopByName(dto.getShop().getName()));

      return entity;
    })
            .forEach(this.laptopRepository::save);

    return sb.toString().trim();
  }

  @Override
  public String exportBestLaptops() throws IOException {
    StringBuilder sb = new StringBuilder();

    this.laptopRepository.findAllLaptopsOrderedCustom()
            .forEach(l -> sb.append(String.format("Laptop - %s\n" +
                    "*Cpu speed - %.2f\n" +
                    "**Ram - %d\n" +
                    "***Storage - %d\n" +
                    "****Price - %.2f\n" +
                    "#Shop name - %s\n" +
                    "##Town - %s\n",
                    l.getMacAddress(),
                    l.getCpuSpeed(),
                    l.getRam(),
                    l.getStorage(),
                    l.getPrice(),
                    l.getShop().getName(),
                    l.getShop().getTown().getName())));

    return sb.toString().trim();
  }

  private boolean macAddressAlreadyExists(LaptopDetailsModel dto) {
    return this.laptopRepository.findByMacAddress(dto.getMacAddress()).isPresent();
  }
}
