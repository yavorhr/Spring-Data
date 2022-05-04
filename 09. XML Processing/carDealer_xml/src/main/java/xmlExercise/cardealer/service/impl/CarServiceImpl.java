package xmlExercise.cardealer.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import xmlExercise.cardealer.model.Dto.queryFour.CarsDetailsViewDtoQ4;
import xmlExercise.cardealer.model.Dto.queryFour.PartRootViewDto;
import xmlExercise.cardealer.model.Dto.queryFour.PartsDetailsVIewDto;
import xmlExercise.cardealer.model.Dto.queryTwoDto.CarsDetailsViewDto;
import xmlExercise.cardealer.model.Dto.seedDto.CarDetailsDto;
import xmlExercise.cardealer.model.entity.Car;
import xmlExercise.cardealer.repository.CarRepository;
import xmlExercise.cardealer.service.CarService;
import xmlExercise.cardealer.service.PartService;
import xmlExercise.cardealer.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PartService partService;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, ValidationUtil validationUtil, PartService partService) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.partService = partService;
    }

    @Override
    public long getCarsCount() {
        return this.carRepository.count();
    }

    @Override
    public void seedCars(List<CarDetailsDto> cars) {
        cars
                .stream()
                .filter(validationUtil::isValid)
                .map(carDetailsDto -> {
                    Car car = modelMapper.map(carDetailsDto, Car.class);
                    car.setParts(partService.getRandomParts());
                    return car;
                })
                .forEach(carRepository::save);
    }

    @Override
    public Car getRandomCar() {
        long carsCountRepository = carRepository.count();
        long randomId = ThreadLocalRandom.current().nextLong(1, carsCountRepository + 1);
        return carRepository.findById(randomId).orElse(null);

    }

    @Override
    public List<CarsDetailsViewDto> findAllToyotaCarsOrderedByModelAndDistance(String make) {
        return this.carRepository
                .findCarsByMakeEqualsOrderByModelAscTravelledDistanceDesc(make)
                .stream()
                .map(car -> modelMapper.map(car, CarsDetailsViewDto.class))
                .collect(Collectors.toList());
    }

    /*

    @Override
    public void getCarsWithParts() throws JAXBException {
        List<CarsDto> carsDtos = new ArrayList<>();
        this.carRepository.findAll().forEach(c -> {
            List<PartDto> partDtos = new ArrayList<>();
            CarsDto car = this.modelMapper.map(c, CarsDto.class);
            c.getParts().forEach(p -> {
                partDtos.add(this.modelMapper.map(p, PartDto.class));
            });
            RootPartDto rootPartDto = new RootPartDto();
            rootPartDto.setParts(partDtos);

            car.setPartDto(rootPartDto);
            carsDtos.add(car);
        });

        CarsPartsDto carsPartsDto = new CarsPartsDto();
        carsPartsDto.setCars(carsDtos);

        this.xmlParser.exportXml(carsPartsDto,CarsPartsDto.class,EXPORT_CAR_PARTS_PATH);
    }
     */

    @Override
    public List<CarsDetailsViewDtoQ4> getAllCarsWithTheirParts() {

        List<CarsDetailsViewDtoQ4> carsList = new ArrayList<>();

        this.carRepository.findAll()
                .forEach(car -> {
                    CarsDetailsViewDtoQ4 carDetails = new CarsDetailsViewDtoQ4();

                    modelMapper.map(car, carDetails);
                    carsList.add(carDetails);

                    PartRootViewDto partRootViewDto = new PartRootViewDto();
                    car.getParts().forEach(p -> {
                        PartsDetailsVIewDto partsDetailsVIewDto = new PartsDetailsVIewDto();
                        modelMapper.map(p, partsDetailsVIewDto);
                        partRootViewDto.setParts(partsDetailsVIewDto);
                    });

                });
    }
}
