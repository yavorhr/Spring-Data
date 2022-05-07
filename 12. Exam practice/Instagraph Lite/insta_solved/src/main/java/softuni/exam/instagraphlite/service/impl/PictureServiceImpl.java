package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Dto.PicturesSeedDto;
import softuni.exam.instagraphlite.models.Entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    private static final String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";

    public PictureServiceImpl(PictureRepository pictureRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.pictureRepository = pictureRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();
        List<String> paths = new ArrayList<>();
        System.out.println(paths);

        PicturesSeedDto[] picturesSeedDtos = gson.fromJson(readFromFileContent(), PicturesSeedDto[].class);
        List<Picture> collect = Arrays.stream(picturesSeedDtos)
                .filter(picturesSeedDto -> {
                    boolean isValid = validationUtil.isValid(picturesSeedDto);

                    if (paths.contains(picturesSeedDto.getPath())) {
                        isValid = false;
                    } else {
                        paths.add(picturesSeedDto.getPath());
                    }

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Picture, with size %.2f", picturesSeedDto.getSize())
                                    : "Invalid Picture")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(picturesSeedDto -> modelMapper.map(picturesSeedDto, Picture.class))
                .collect(Collectors.toList());
//                .forEach(pictureRepository::save);

        pictureRepository.saveAll(collect);
        return sb.toString();
    }

    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();
        List<Picture> pictures = pictureRepository.findAllBySizeGreaterThanOrderBySizeAsc(30000);
        pictures.forEach(p ->
                sb.
                        append(String.format("%.2f - %s",
                                p.getSize(),
                                p.getPath()))
                        .append(System.lineSeparator()));

        return sb.toString();
    }

    @Override
    public Picture findByPath(String path) {
        return pictureRepository.findPictureByPath(path);
    }
}
