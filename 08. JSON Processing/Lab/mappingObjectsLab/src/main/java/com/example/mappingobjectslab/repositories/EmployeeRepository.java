package com.example.mappingobjectslab.repositories;

import com.example.mappingobjectslab.entity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  List<Employee>findAllByManagerIsNull();

}
