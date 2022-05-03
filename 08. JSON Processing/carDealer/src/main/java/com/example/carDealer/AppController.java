package com.example.carDealer;

import com.example.carDealer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AppController implements CommandLineRunner {
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public AppController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.supplierService.seedSupplier();
        this.partService.seedPart();
        this.carService.seedCar();
        this.customerService.seedCustomers();
        this.saleService.seedSale();

        // Query1
        this.customerService.orderedCustomers();
        //Query2
        this.carService.getCarByMake();
        //Query3
        this.supplierService.getAllSuppliers();
        //Query4
        this.carService.getCarsWithParts();
        //Query5
        this.customerService.getAllWithBoughtCars();
        //Query6
        this.saleService.getSalesWithAndWithoutDiscount();

    }
}
