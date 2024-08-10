package com.example.mappingobjectslab.repositories;

import com.example.mappingobjectslab.entity.dto.EmployeeAverageSalaryDto;
import com.example.mappingobjectslab.entity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  @Query("SELECT new com.example.objectmapping.models.dto.EmployeeAverageSalaryDto(AVG(e.salary), SUM(e.subordinates.size)) FROM Employee e GROUP BY e.id")
  List<EmployeeAverageSalaryDto> findAllWithAvgSalary();

}
