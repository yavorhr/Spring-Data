package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.CarService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class CarServiceImpl implements CarService {
    private static String CARS_FILE_PATH = "";

    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return null;
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        return null;
    }
}
