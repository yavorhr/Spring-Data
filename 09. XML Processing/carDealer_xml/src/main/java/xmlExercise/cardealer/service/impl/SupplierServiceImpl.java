package xmlExercise.cardealer.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import xmlExercise.cardealer.model.Dto.queryThreeDto.SuppliersDetailsViewDto;
import xmlExercise.cardealer.model.Dto.seedDto.SuppliersWithNameAndImporterDto;
import xmlExercise.cardealer.model.entity.Supplier;
import xmlExercise.cardealer.repository.SupplierRepository;
import xmlExercise.cardealer.service.SupplierService;
import xmlExercise.cardealer.util.ValidationUtil;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getCount() {
        return this.supplierRepository.count();
    }

    @Override
    public void seedSuppliers(List<SuppliersWithNameAndImporterDto> suppliers) {
        suppliers
                .stream()
                .filter(validationUtil::isValid)
                .map(supplierDto -> modelMapper.map(supplierDto, Supplier.class))
                .forEach(supplierRepository::save);
    }

    @Override
    public Supplier getRandomSupplier() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, supplierRepository.count() + 1);
        return supplierRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<SuppliersDetailsViewDto> findAllSuppliersWithoutImportedParts() {
        return supplierRepository
                .getAllByImporterIsFalse()
                .stream()
                .map(supplier -> {

                    String size = String.valueOf(supplier.getParts().size());

                    SuppliersDetailsViewDto suppliersDetailsViewDto = new SuppliersDetailsViewDto();
                    suppliersDetailsViewDto.setPartsCount(size);

                    modelMapper.map(supplier,suppliersDetailsViewDto);

                    return suppliersDetailsViewDto;
                })
                .collect(Collectors.toList());
    }
}
