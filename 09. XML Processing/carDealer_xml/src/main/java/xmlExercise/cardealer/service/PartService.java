package xmlExercise.cardealer.service;

import xmlExercise.cardealer.model.Dto.seedDto.PartsWithNamePriceAndQuantityDto;
import xmlExercise.cardealer.model.entity.Part;

import java.util.List;

public interface PartService {

    long getCount();

    void seedParts(List<PartsWithNamePriceAndQuantityDto> parts);


    List<Part> getRandomParts();
}
