package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.MechanicService;

import java.io.IOException;

@Service
public class MechanicServiceImpl implements MechanicService {
    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return null;
    }

    @Override
    public String importMechanics() throws IOException {
        return null;
    }
}
