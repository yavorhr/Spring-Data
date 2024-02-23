package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Dto.PlanesRootDto;
import softuni.exam.models.Entity.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParse;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {

    private final PlaneRepository planeRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParse xmlParse;

    private static final String PLANES_FILE_PATH = "src/main/resources/files/xml/planes.xml";

    public PlaneServiceImpl(PlaneRepository planeRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParse xmlParse) {
        this.planeRepository = planeRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParse = xmlParse;
    }

    @Override
    public boolean areImported() {
        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANES_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        PlanesRootDto planesRootDto = xmlParse.fromFile(PLANES_FILE_PATH, PlanesRootDto.class);

        List<String> registerNumbers = new ArrayList<>();

        planesRootDto.getPlanes()
                .stream()
                .filter(planesDetailsDto -> {
                    boolean isValid = validationUtil.isValid(planesDetailsDto);

                    if (registerNumbers.contains(planesDetailsDto.getRegisterNumber())) {
                        isValid = false;
                    } else {
                        registerNumbers.add(planesDetailsDto.getRegisterNumber());
                    }

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Plane %s", planesDetailsDto.getRegisterNumber())
                                    : "Invalid Plane")
                            .append(System.lineSeparator());
                    return isValid;
                }).map(planesDetailsDto -> modelMapper.map(planesDetailsDto, Plane.class))
                .forEach(planeRepository::save);


        return sb.toString();
    }

    @Override
    public Plane findPlaneByRegNumber(String registerNumber) {
        return planeRepository.findByRegisterNumber(registerNumber);
    }
}
