package com.example.nextleveltech.web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController {

  @GetMapping("/")
  public String index(HttpServletRequest request){
    if (this.isLogged(request)) {
      return "redirect:/home";
    }
    return "index";
  }

  @GetMapping("/home")
  public String home(HttpServletRequest request){
    if (!this.isLogged(request)) {
      return "redirect:/";
    }
    return "home";
  }

}
