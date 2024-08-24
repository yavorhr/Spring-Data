package com.example.nextleveltech.web.controllers;

import com.example.nextleveltech.service.CompanyService;
import com.example.nextleveltech.service.EmployeeService;
import com.example.nextleveltech.service.ProjectService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController {
  private final CompanyService companyService;
  private final EmployeeService employeeService;
  private final ProjectService projectService;

  public HomeController(CompanyService companyService, EmployeeService employeeService, ProjectService projectService) {
    this.companyService = companyService;
    this.employeeService = employeeService;
    this.projectService = projectService;
  }

  @GetMapping("/")
  public String index(HttpServletRequest request){
    if (this.isLogged(request)) {
      return "redirect:/home";
    }
    return "index";
  }

  @GetMapping("/home")
  public String home(HttpServletRequest request, Model model){
    if (!this.isLogged(request)) {
      return "redirect:/";
    }

    model.addAttribute("areImported", areImported());
    return "home";
  }

  private boolean areImported() {
    return this.companyService.areFilesImported()
            && this.employeeService.areFilesImported()
            && this.projectService.areFilesImported();
  }
}
