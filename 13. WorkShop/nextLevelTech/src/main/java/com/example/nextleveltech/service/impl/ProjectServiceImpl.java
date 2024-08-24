package com.example.nextleveltech.service.impl;

import com.example.nextleveltech.repositoriy.ProjectRepository;
import com.example.nextleveltech.service.ProjectService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class ProjectServiceImpl implements ProjectService {
  private static final String PROJECTS_FILE_PATH = "files/xmls/projects.xml";

  private final ProjectRepository projectRepository;

  public ProjectServiceImpl(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @Override
  public boolean areFilesImported() {
    return this.projectRepository.existsAllBy() ;
  }

  @Override
  public String getXmlDataForImport() throws IOException {
    return new String(this.getClass().getClassLoader().getResourceAsStream(PROJECTS_FILE_PATH).readAllBytes(), StandardCharsets.UTF_8);
  }
}
