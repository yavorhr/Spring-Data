package xmlExercise.cardealer.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import xmlExercise.cardealer.model.Dto.queryOneDto.CustomerViewDetailsDto;
import xmlExercise.cardealer.model.Dto.seedDto.CustomerDetailsDto;
import xmlExercise.cardealer.model.entity.Customer;
import xmlExercise.cardealer.repository.CustomerRepository;
import xmlExercise.cardealer.service.CustomerService;
import xmlExercise.cardealer.util.ValidationUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public long getCustomersCount() {
        return customerRepository.count();
    }

    @Override
    public void seedCustomers(List<CustomerDetailsDto> customers) {
        customers
                .stream()
                .filter(validationUtil::isValid)
                .map(customerDetailsDto -> {
                    Customer customer = modelMapper.map(customerDetailsDto, Customer.class);
                    LocalDateTime parse = LocalDateTime.parse(customerDetailsDto.getBirthDate());
                    customer.setBirthDate(parse);
                    return customer;
                })
                .forEach(customerRepository::save);
    }

    @Override
    public Customer getRandomCustomer() {
        long customerRepoSize = customerRepository.count();
        long randomId = ThreadLocalRandom.current().nextLong(1 + customerRepoSize + 1);
        return customerRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<CustomerViewDetailsDto>  findAllCustomersOrderedByBirthdayAndExperience() {
        return customerRepository.findAllCustomersOrderedByBirthdayAndExperience()
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerViewDetailsDto.class))
                .collect(Collectors.toList());
    }

}
