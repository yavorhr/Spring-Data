package com.example.nextleveltech.web.controllers;

import com.example.nextleveltech.service.CompanyService;
import com.example.nextleveltech.service.EmployeeService;
import com.example.nextleveltech.service.ProjectService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class ImportController extends BaseController {
  private final CompanyService companyService;
  private final EmployeeService employeeService;
  private final ProjectService projectService;

  public ImportController(CompanyService companyService, EmployeeService employeeService, ProjectService projectService) {
    this.companyService = companyService;
    this.employeeService = employeeService;
    this.projectService = projectService;
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
}
