package exam.service.impl;

import exam.model.entity.Shop;
import exam.model.service.xml.ShopsRootModel;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ShopServiceImpl implements ShopService {
  private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";
  private final ShopRepository shopRepository;
  private final ModelMapper modelMapper;
  private final XmlParser xmlParser;
  private final ValidationUtil validationUtil;
  private final TownService townService;

  public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, TownService townService) {
    this.shopRepository = shopRepository;
    this.modelMapper = modelMapper;
    this.xmlParser = xmlParser;
    this.validationUtil = validationUtil;
    this.townService = townService;
  }

  @Override
  public boolean areImported() {
    return this.shopRepository.count() > 0;
  }

  @Override
  public String readShopsFileContent() throws IOException {
    return Files.readString(Path.of(SHOPS_FILE_PATH));
  }

  @Override
  public String importShops() throws JAXBException, FileNotFoundException {
    StringBuilder sb = new StringBuilder();

    this.xmlParser.fromFile(SHOPS_FILE_PATH, ShopsRootModel.class).getShops()
            .stream()
            .filter(s -> {

              boolean isValid = this.validationUtil.isValid(s);

              if (shopExist(s.getName())) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported Shop %s - %.2f ", s.getName(), s.getIncome())
                      : "Invalid shop")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              Shop shopEntity = this.modelMapper.map(dto, Shop.class);

              shopEntity.setTown(this.townService.findTownByName(dto.getTown().getName()));

              return shopEntity;
            })
            .forEach(this.shopRepository::save);

    return sb.toString().trim();
  }

  @Override
  public Shop findShopByName(String name) {
    return this.shopRepository.findByName(name).get();
  }

  // Helpers
  private boolean shopExist(String name) {
    return this.shopRepository.findByName(name).isPresent();
  }
}
