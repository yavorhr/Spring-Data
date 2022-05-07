package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Dto.TownsInputDto;
import softuni.exam.models.Entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    private static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";


    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        List<String> townNames = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        TownsInputDto[] townsInputDtos = gson.fromJson(readTownsFileContent(), TownsInputDto[].class);
        Arrays.stream(townsInputDtos)
                .filter(townsInputDto -> {
                    boolean isValid = validationUtil.isValid(townsInputDto);

                    if (townNames.contains(townsInputDto.getName())) {
                        isValid = false;
                    } else {
                        townNames.add(townsInputDto.getName());
                    }


                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Town %s - %d", townsInputDto.getName(), townsInputDto.getPopulation())
                                    : "Invalid Town")
                    .append(System.lineSeparator());

                    return isValid;
                })
                .map(townsInputDto -> modelMapper.map(townsInputDto, Town.class))
                .forEach(townRepository::save);

        return sb.toString();
    }

    @Override
    public Town findTownByName(String name) {
        return townRepository.findByName(name);
    }

    @Override
    public Town findToTownByName(String name) {
        return townRepository.findByName(name);
    }
}
