package xmlExercise.cardealer.service;

import xmlExercise.cardealer.model.Dto.queryOneDto.CustomerViewDetailsDto;
import xmlExercise.cardealer.model.Dto.seedDto.CustomerDetailsDto;
import xmlExercise.cardealer.model.entity.Customer;

import java.util.List;

public interface CustomerService {

    long getCustomersCount();

    void seedCustomers(List<CustomerDetailsDto> customers);

    Customer getRandomCustomer();

    List<CustomerViewDetailsDto> findAllCustomersOrderedByBirthdayAndExperience();


}
