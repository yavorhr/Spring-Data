package xmlExercise.cardealer;

import org.springframework.stereotype.Component;
import xmlExercise.cardealer.model.Dto.queryFour.CarsDetailsViewDtoQ4;
import xmlExercise.cardealer.model.Dto.queryFour.CarsRootViewDtoQuery4;
import xmlExercise.cardealer.model.Dto.queryOneDto.CustomerViewDetailsDto;
import xmlExercise.cardealer.model.Dto.queryOneDto.CustomersRootViewDto;
import xmlExercise.cardealer.model.Dto.queryThreeDto.SuppliersDetailsViewDto;
import xmlExercise.cardealer.model.Dto.queryThreeDto.SuppliersRootViewDto;
import xmlExercise.cardealer.model.Dto.queryTwoDto.CarsDetailsViewDto;
import xmlExercise.cardealer.model.Dto.queryTwoDto.CarsRootVIewDto;
import xmlExercise.cardealer.model.Dto.seedDto.CarsRootDto;
import xmlExercise.cardealer.model.Dto.seedDto.CustomerRootDto;
import xmlExercise.cardealer.model.Dto.seedDto.PartsRootDto;
import xmlExercise.cardealer.model.Dto.seedDto.SuppliersRootSeedDto;
import xmlExercise.cardealer.service.*;
import xmlExercise.cardealer.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private static final String RESOURCES_FOLDER = "src/main/resources/Files/";
    private static final String OUTPUT_FOLDER = "Output/";
    private static final String SUPPLIERS_FILE = "suppliers.xml";
    private static final String PARTS_FILE_PATH = "parts.xml";
    private static final String CARS_FILE_PATH = "cars.xml";
    private static final String CUSTOMERS_FILE_PATH = "customers.xml";

    private static final String CUSTOMERS_OUTPUT_FILE = "customers-ordered-by-birthday-and-exp.xml";
    private static final String CARS_OUTPUT_FILE = "cars-toyota-ordered.xml";
    private static final String SUPPLIERS_OUTPUT_FILE = "suppliers-without-imported-parts.xml";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final XmlParser xmlParser;
    private final BufferedReader bufferedReader;

    public CommandLineRunner(SupplierService supplierService, PartService partService, CarService carService, XmlParser xmlParser, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.xmlParser = xmlParser;
        this.customerService = customerService;
        this.saleService = saleService;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Please enter query number: ");
        int queryNum = Integer.parseInt(bufferedReader.readLine());
        switch (queryNum) {
            case 1:
                queryOne();
            case 2:
                queryTwo();
            case 3:
                queryThree();
            case 4:
                queryFour();
            case 5:
                queryFive();
            case 6:
                querySix();


        }
    }

    private void querySix() {
        //only query in Repo is implemented
    }

    private void queryFive() {
        //only query in Repo is implemented
    }

    private void queryFour() {
        CarsRootViewDtoQuery4 carsRootViewDtoQuery4 = new CarsRootViewDtoQuery4();

     List   <CarsDetailsViewDtoQ4> carsDetailsViewDto = carService.getAllCarsWithTheirParts();

    }

    private void queryThree() throws JAXBException {
        SuppliersRootViewDto suppliersRootViewDto = new SuppliersRootViewDto();
        List<SuppliersDetailsViewDto> suppliersDetails = supplierService.findAllSuppliersWithoutImportedParts();
        suppliersRootViewDto.setSuppliers(suppliersDetails);
        xmlParser.writeToFile(RESOURCES_FOLDER + OUTPUT_FOLDER + SUPPLIERS_OUTPUT_FILE, suppliersRootViewDto);
    }

    private void queryTwo() throws JAXBException {
        CarsRootVIewDto carsRootVIewDto = new CarsRootVIewDto();

        List<CarsDetailsViewDto> carsDetailsViewDto =
                carService.findAllToyotaCarsOrderedByModelAndDistance("Toyota");
        carsRootVIewDto.setCars(carsDetailsViewDto);
        xmlParser.writeToFile(RESOURCES_FOLDER + OUTPUT_FOLDER + CARS_OUTPUT_FILE, carsRootVIewDto);
    }

    private void queryOne() throws JAXBException {
        //only query in Repo is implemented
        CustomersRootViewDto customersRootViewDto = new CustomersRootViewDto();

        List<CustomerViewDetailsDto> customersWithDetails = customerService.findAllCustomersOrderedByBirthdayAndExperience();
        customersRootViewDto.setCustomerDetails(customersWithDetails);
        xmlParser.writeToFile(RESOURCES_FOLDER + OUTPUT_FOLDER + CUSTOMERS_OUTPUT_FILE, customersRootViewDto);
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if (supplierService.getCount() == 0) {
            SuppliersRootSeedDto suppliersRootSeedDto = xmlParser.fromFile(RESOURCES_FOLDER + SUPPLIERS_FILE, SuppliersRootSeedDto.class);
            supplierService.seedSuppliers(suppliersRootSeedDto.getSuppliers());
        }

        if (partService.getCount() == 0) {
            PartsRootDto partsRootDto = xmlParser.fromFile(RESOURCES_FOLDER + PARTS_FILE_PATH, PartsRootDto.class);
            partService.seedParts(partsRootDto.getPartsWithNamePriceAndQuantityDtoList());
        }

        if (carService.getCarsCount() == 0) {
            CarsRootDto carsRootDto = xmlParser.fromFile(RESOURCES_FOLDER + CARS_FILE_PATH, CarsRootDto.class);
            carService.seedCars(carsRootDto.getCars());
        }

        if (customerService.getCustomersCount() == 0) {
            CustomerRootDto customerRootDto = xmlParser.fromFile(RESOURCES_FOLDER + CUSTOMERS_FILE_PATH, CustomerRootDto.class);
            customerService.seedCustomers(customerRootDto.getCustomers());
        }

        if (saleService.getSalesCount() == 0) {
            saleService.seedData();
        }

    }
}
