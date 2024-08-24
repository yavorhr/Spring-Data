package com.example.nextleveltech.repositoriy;

import com.example.nextleveltech.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

  boolean existsAllBy();
}
