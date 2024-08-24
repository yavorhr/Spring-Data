package com.example.nextleveltech.repositoriy;

import com.example.nextleveltech.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

  boolean existsAllBy();
}
