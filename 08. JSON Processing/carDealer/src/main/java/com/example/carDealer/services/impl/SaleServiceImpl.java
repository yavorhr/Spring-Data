package com.example.carDealer.services.impl;


import com.example.carDealer.domain.dtos.views.SaleDto;
import com.example.carDealer.domain.dtos.views.SaleRootDto;
import com.example.carDealer.domain.dtos.views.SalesCarsDro;
import com.example.carDealer.domain.entities.Car;
import com.example.carDealer.domain.entities.Customer;
import com.example.carDealer.domain.entities.Sale;
import com.example.carDealer.domain.repositories.CarRepository;
import com.example.carDealer.domain.repositories.CustomerRepository;
import com.example.carDealer.domain.repositories.SaleRepository;
import com.example.carDealer.services.SaleService;
import com.example.carDealer.utils.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private final static String SALES_EXPORT_PATH = "src/main/resources/xmls/exported/sales.xml";
    private final SaleRepository saleRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final XmlParser xmlParser;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository,
                           CustomerRepository customerRepository, ModelMapper modelMapper, Gson gson, XmlParser xmlParser) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;

        this.gson = gson;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSale() {
        for (int i = 0; i < 5; i++) {
            Sale sale = new Sale();
            sale.setCar(getRandomCar());
            sale.setCustomer(getRandomCustomer());
            sale.setDiscount(getRandomDiscount());
            this.saleRepository.saveAndFlush(sale);
        }
    }

    @Override
    public void getSalesWithAndWithoutDiscount() throws JAXBException {
        List<SaleDto> dto = new ArrayList<>();

        this.saleRepository.findAll().forEach(s -> {
            SalesCarsDro carsDro = this.modelMapper.map(s.getCar(),SalesCarsDro.class);
            SaleDto saleDto = this.modelMapper.map(s,SaleDto.class);
            saleDto.setSalesCarsDro(carsDro);
            double price = s.getCar().getParts()
                    .stream()
                    .mapToDouble(p -> Double.parseDouble(String.valueOf(p.getPrice()))).sum();

            saleDto.setPrice(BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP));

            if (s.getDiscount() > 0){
                saleDto.setPriceWithDiscount(BigDecimal.valueOf(price/s.getCar().getParts().size())
                        .setScale(2, RoundingMode.HALF_UP));
            }else {
                saleDto.setPriceWithDiscount(BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP));
            }
            dto.add(saleDto);
        });

        SaleRootDto root = new SaleRootDto();
        root.setSales(dto);

        this.xmlParser.exportXml(root, SaleRootDto.class, SALES_EXPORT_PATH);
    }

    private int getRandomDiscount() {
        Random random = new Random();
        return 10 * random.nextInt(6);
    }

    private Customer getRandomCustomer() {
        Random random = new Random();
        long index = (long) random.nextInt((int) this.customerRepository.count()) + 1;
        return this.customerRepository.findById(index).get();
    }

    private Car getRandomCar() {
        Random random = new Random();
        long index = (long) random.nextInt((int) this.carRepository.count()) + 1;
        return this.carRepository.findById(index).get();
    }


}
