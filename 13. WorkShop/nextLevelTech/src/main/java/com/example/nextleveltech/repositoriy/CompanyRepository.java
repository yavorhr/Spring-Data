package com.example.nextleveltech.repositoriy;

import com.example.nextleveltech.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

  boolean existsAllBy();
}
