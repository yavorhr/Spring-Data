package xmlExercise.cardealer.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import xmlExercise.cardealer.model.Dto.seedDto.PartsWithNamePriceAndQuantityDto;
import xmlExercise.cardealer.model.entity.Part;
import xmlExercise.cardealer.repository.PartRepository;
import xmlExercise.cardealer.service.PartService;
import xmlExercise.cardealer.service.SupplierService;
import xmlExercise.cardealer.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final SupplierService supplierService;

    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, ValidationUtil validationUtil, SupplierService supplierService) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.supplierService = supplierService;
    }

    @Override
    public long getCount() {
        return this.partRepository.count();
    }

    @Override
    public void seedParts(List<PartsWithNamePriceAndQuantityDto> parts) {
        parts
                .stream()
                .filter(validationUtil::isValid)
                .map(partsDto -> {
                    Part part = modelMapper.map(partsDto, Part.class);
                    part.setSupplier(supplierService.getRandomSupplier());
                    return part;
                })
                .forEach(partRepository::save);
    }

    @Override
    public List<Part> getRandomParts() {
        int randomCount = ThreadLocalRandom.current().nextInt(3, 5 + 1);
        long partsRepoCount = partRepository.count();
        List<Part> randomPartsList = new ArrayList<>();

        for (int i = 0; i < randomCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, partsRepoCount + 1);
            Part randomPart = partRepository.findById(randomId).orElse(null);
            randomPartsList.add(randomPart);
        }
        return randomPartsList;
    }
}
