package com.example.mappingobjectslab.configuration;

import com.example.objectmapping.models.dto.EmployeeDto;
import com.example.objectmapping.models.dto.firstlastnametest.FirstLastNameSource;
import com.example.objectmapping.models.dto.firstlastnametest.FullNameTarget;
import com.example.objectmapping.models.entities.Employee;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapperBasicEmployee() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<Employee, EmployeeDto> typeMap = mapper.createTypeMap(Employee.class, EmployeeDto.class);
        typeMap.addMappings(mapping -> mapping.map(Employee::getSalary, EmployeeDto::setIncome));


        mapper.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(MappingContext<String, LocalDateTime> context) {
                return LocalDateTime.parse(
                        context.getSource(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                );
            }
        });

//        mapper.createTypeMap(FirstLastNameSource.class, FullNameTarget.class)
//                .addMappings(mapping -> mapping.map(
//                        source -> source.getFirstName() + " " + source.getLastName(),
//                        FullNameTarget::setFullName
//                ));

        mapper.addMappings(new PropertyMap<FirstLastNameSource, FullNameTarget>() {
            @Override
            protected void configure() {
                using(
                        new Converter<FirstLastNameSource, String>() {
                            @Override
                            public String convert(MappingContext<FirstLastNameSource, String> context) {
                                return context.getSource().getFirstName() + " " + context.getSource().getLastName();
                            }
                        }
                ).map(source, destination.getFullName());
            }
        });

//        TypeMap<Employee, EmployeeAverageSalaryDto> avgSalaryMap = mapper.createTypeMap(Employee.class, EmployeeAverageSalaryDto.class);
//
//        avgSalaryMap.addMappings(mapping -> mapping.map(source -> {
//            var sum = source.getSubordinates().stream().map(Employee::getSalary)
//                    .reduce(BigDecimal::add)
//                    .orElseThrow();
//
//            var avg = sum.divide(BigDecimal.valueOf(source.getSubordinates().size()), RoundingMode.CEILING);
//
//            return avg.doubleValue();
//        }, (destination, value) -> {
//            destination.setAvgSalary((double) value);
//        }));


        return mapper;
    }

    @Bean
    public Date nowDate() {
        return new Date();
    }


}
