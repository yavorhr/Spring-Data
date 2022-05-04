package xmlExercise.cardealer.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import xmlExercise.cardealer.model.entity.Car;
import xmlExercise.cardealer.model.entity.Customer;
import xmlExercise.cardealer.model.entity.Sale;
import xmlExercise.cardealer.repository.CarRepository;
import xmlExercise.cardealer.repository.SaleRepository;
import xmlExercise.cardealer.service.CarService;
import xmlExercise.cardealer.service.CustomerService;
import xmlExercise.cardealer.service.SaleService;
import xmlExercise.cardealer.util.ValidationUtil;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CarService carService;
    private final CustomerService customerService;

    public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper, ValidationUtil validationUtil, CarRepository carRepository, CarService carService, CustomerService customerService) {
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.carService = carService;
        this.customerService = customerService;
    }

    @Override
    public long getSalesCount() {
        return this.saleRepository.count();
    }

    @Override
    public void seedData() {

        List<Integer> discounts = List.of(0, 5, 10, 15, 20, 30, 40, 50);

        for (int i = 0; i < 50; i++) {
            Car car = carService.getRandomCar();
            Integer discount = discounts.get(ThreadLocalRandom.current().nextInt(0, discounts.size()));
            Customer customer = customerService.getRandomCustomer();
            Sale sale = new Sale();
            sale.setCar(car);
            sale.setDiscount(discount);
            sale.setCustomer(customer);
            saleRepository.save(sale);
        }
    }
}
