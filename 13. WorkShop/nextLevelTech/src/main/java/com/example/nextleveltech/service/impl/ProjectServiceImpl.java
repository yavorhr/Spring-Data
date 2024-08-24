package com.example.nextleveltech.service.impl;

import com.example.nextleveltech.repositoriy.ProjectRepository;
import com.example.nextleveltech.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
  private final ProjectRepository projectRepository;

  public ProjectServiceImpl(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @Override
  public boolean areFilesImported() {
    return this.projectRepository.existsAllBy() ;
  }
}
