package xmlExercise.cardealer.service;

import xmlExercise.cardealer.model.Dto.queryThreeDto.SuppliersDetailsViewDto;
import xmlExercise.cardealer.model.Dto.seedDto.SuppliersWithNameAndImporterDto;
import xmlExercise.cardealer.model.entity.Supplier;

import java.util.List;

public interface SupplierService {

    long getCount();

    void seedSuppliers(List<SuppliersWithNameAndImporterDto> suppliers);

    Supplier getRandomSupplier();

    List<SuppliersDetailsViewDto> findAllSuppliersWithoutImportedParts();
}
