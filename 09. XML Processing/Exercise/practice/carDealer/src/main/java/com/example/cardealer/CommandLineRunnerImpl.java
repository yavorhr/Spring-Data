package com.example.cardealer;

import com.example.cardealer.constant.ProjectConstants;
import com.example.cardealer.model.dto.view.FifthQuery.CustomersWithTotalSalesRootViewDto;
import com.example.cardealer.model.dto.view.FirstQuery.CustomersRootViewDto;
import com.example.cardealer.model.dto.view.FourthQuery.CarsWithPartsRootViewDto;
import com.example.cardealer.model.dto.view.SecondQuery.CarsRootViewDto;
import com.example.cardealer.model.dto.view.SixthQuery.SalesAppDiscRootViewDto;
import com.example.cardealer.model.dto.view.ThirdQuery.SuppliersViewRootDto;
import com.example.cardealer.service.*;
import com.example.cardealer.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;
  private final CarService carService;
  private final CustomerService customerService;
  private final PartService partService;
  private final SaleService saleService;
  private final SupplierService supplierService;
  private final XmlParser xmlParser;

  public CommandLineRunnerImpl(BufferedReader bufferedReader, CarService carService, CustomerService customerService, PartService partService, SaleService saleService, SupplierService supplierService, XmlParser xmlParser) {
    this.bufferedReader = bufferedReader;
    this.carService = carService;
    this.customerService = customerService;
    this.partService = partService;
    this.saleService = saleService;
    this.supplierService = supplierService;
    this.xmlParser = xmlParser;
  }

  @Override
  public void run(String... args) throws Exception {
    seedData();

    System.out.println("Please select task number");
    int taskNumber = Integer.parseInt(this.bufferedReader.readLine());

    switch (taskNumber) {
      case 1 -> orderedCustomers();
      case 2 -> carsFromMakeToyota();
      case 3 -> localSuppliers();
      case 4 -> carsWithTheirParts();
      case 5 -> totalSalesByCustomer();
      case 6 -> salesWithAppliedDiscount();
    }
  }

  private void salesWithAppliedDiscount() throws JAXBException {
    var rootViewDto = this.saleService.findAllSales();
    writeDtoToFile(ProjectConstants.SIXTH_QUERY, rootViewDto);
  }

  private void totalSalesByCustomer() throws JAXBException {
    var rootViewDto =
            this.customerService.findAllCustomersWithAtLeastOneBoughtCar();

    writeDtoToFile(ProjectConstants.FIFTH_QUERY, rootViewDto);
  }

  private void carsWithTheirParts() throws JAXBException {
    var rootViewDto = this.carService.findAllCarsWithTheirParts();
    writeDtoToFile(ProjectConstants.FOURTH_QUERY, rootViewDto);
  }

  private void localSuppliers() throws JAXBException {
    var rootViewDto =
            this.supplierService.findAllLocalSuppliers();

    writeDtoToFile(ProjectConstants.THIRD_QUERY, rootViewDto);
  }

  private void carsFromMakeToyota() throws JAXBException {
    var rootViewDto =
            this.carService.findAllToyotaCarsOrderedByModelAscAndDistanceDesc("Toyota");

    writeDtoToFile(ProjectConstants.SECOND_QUERY, rootViewDto);
  }

  private void orderedCustomers() throws JAXBException {
    CustomersRootViewDto rootViewDto =
            this.customerService.findAllCustomersOrderedByBdayAscAndYoungDrivers();

    writeDtoToFile(ProjectConstants.FIRST_QUERY, rootViewDto);
  }

  // Helpers
  private void seedData() throws JAXBException, FileNotFoundException {
    this.supplierService.seedSuppliers();
    this.partService.seedParts();
    this.carService.seedCars();
    this.customerService.seedCustomers();
    this.saleService.seedSales();
  }

  public <T> void writeDtoToFile(String fileName, T rootDto) throws JAXBException {
    this.xmlParser.writeToFile(fileName, rootDto);
  }
}
