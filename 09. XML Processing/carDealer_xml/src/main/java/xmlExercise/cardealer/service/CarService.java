package xmlExercise.cardealer.service;

import xmlExercise.cardealer.model.Dto.queryFour.CarsDetailsViewDtoQ4;
import xmlExercise.cardealer.model.Dto.queryTwoDto.CarsDetailsViewDto;
import xmlExercise.cardealer.model.Dto.seedDto.CarDetailsDto;
import xmlExercise.cardealer.model.entity.Car;

import java.util.List;

public interface CarService {

    long getCarsCount();

    void seedCars(List<CarDetailsDto> cars);

    Car getRandomCar();

    List<CarsDetailsViewDto> findAllToyotaCarsOrderedByModelAndDistance(String toyota);

    List<CarsDetailsViewDtoQ4> getAllCarsWithTheirParts();
}
