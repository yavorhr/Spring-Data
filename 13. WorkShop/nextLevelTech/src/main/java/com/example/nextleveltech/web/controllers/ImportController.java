package com.example.nextleveltech.web.controllers;

import com.example.nextleveltech.model.dto.ImportCompaniesDto;
import com.example.nextleveltech.model.dto.ImportProjectsDto;
import com.example.nextleveltech.model.dto.xml.CompaniesRootDto;
import com.example.nextleveltech.model.dto.xml.CompanyDto;
import com.example.nextleveltech.model.dto.xml.ProjectsRootDto;
import com.example.nextleveltech.service.CompanyService;
import com.example.nextleveltech.service.EmployeeService;
import com.example.nextleveltech.service.ProjectService;
import com.example.nextleveltech.util.DataConverter;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Controller
public class ImportController extends BaseController {
  private final CompanyService companyService;
  private final EmployeeService employeeService;
  private final ProjectService projectService;
  private final DataConverter converter;

  public ImportController(CompanyService companyService, EmployeeService employeeService, ProjectService projectService, DataConverter converter) {
    this.companyService = companyService;
    this.employeeService = employeeService;
    this.projectService = projectService;
    this.converter = converter;
  }

  @GetMapping("import/xml")
  public String importXml(HttpServletRequest request, Model model) {
    if (!this.isLogged(request)) {
      return "redirect:/users/login";
    }

    model.addAttribute("areImported", new boolean[]{
            companyService.areFilesImported(),
            employeeService.areFilesImported(),
            projectService.areFilesImported()}
    );

    return "xml/import-xml";
  }

  @GetMapping("/import/companies")
  public String importCompaniesXml(HttpServletRequest request, Model model) throws IOException {
    if (!this.isLogged(request)) {
      return "redirect:/users/login";
    }

    model.addAttribute("companies", this.companyService.getXmlDataForImport());

    return "xml/import-companies";
  }

  @PostMapping("/import/companies")
  public String importCompanies(ImportCompaniesDto dto, HttpServletRequest req) {
    if (!this.isLogged(req)) {
      return "redirect:/";
    }

    var companyRoot = this.converter.deserialize(
            dto.getCompanies(),
            CompaniesRootDto.class
    );

    System.out.println();

//    companyRoot.getCompanies().forEach(this.companyService::create);

    return "redirect:/import/xml";
  }

  @GetMapping("/import/employees")
  public String importEmployeesXml(Model model, HttpServletRequest request) throws IOException {
    if (!this.isLogged(request)) {
      return "redirect:/users/login";
    }

    model.addAttribute("employees", this.employeeService.getXmlDataForImport());

    return "xml/import-employees";
  }

  @GetMapping("/import/projects")
  public String importProjectsXml(Model model, HttpServletRequest request) throws IOException {
    if (!this.isLogged(request)) {
      return "redirect:/users/login";
    }
    model.addAttribute("projects", this.projectService.getXmlDataForImport());

    return "xml/import-projects";
  }

  @PostMapping("/import/projects")
  public String importProjects(ImportProjectsDto dto, HttpServletRequest req) {
    if (!this.isLogged(req)) {
      return "redirect:/";
    }

    var projectsRootDto = this.converter.deserialize(
            dto.getProjects(),
            ProjectsRootDto.class
    );

    System.out.println();


    return "redirect:/import/xml";
  }
}
