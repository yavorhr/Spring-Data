package com.example.mappingobjectslab.configuration;

import com.example.objectmapping.models.dto.EmployeeDto;
import com.example.objectmapping.models.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class ModelMapperSingleton {

    private static ModelMapper mapper = null;

    private static int inicializacii = 0;

    public static ModelMapper getInstance() {
        if (mapper == null) {
            System.out.println("INITICIALIZIRAME MAPPERA " + inicializacii++);
            mapper = new ModelMapper();
            mapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {
                @Override
                protected void configure() {
                    map().setIncome(source.getSalary());
                }
            });
        }

        System.out.println("WRYSHTAME INICIALIZIRAN MAPPER " + inicializacii++);
        return mapper;
    }

}
