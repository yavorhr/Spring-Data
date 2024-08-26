package com.example.nextleveltech.model.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "projects")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectsRootDto {

  @XmlElement(name = "project")
  List<ProjectDto> projects;

  public List<ProjectDto> getProjects() {
    return projects;
  }

  public void setProjects(List<ProjectDto> projects) {
    this.projects = projects;
  }
}
