package com.example.nextleveltech.web.controllers;

import com.example.nextleveltech.model.dto.UserRegisterDto;
import com.example.nextleveltech.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("users/register")
  public String register() {
    return "user/register";
  }

  @PostMapping("users/register")
  public String register(UserRegisterDto userRegisterDto, Model model) {
    if (this.userService.registerUser(userRegisterDto)) {
      model.addAttribute("error", "There is an error");
      return "redirect:login";
    }

    return "user/register";
  }

  @GetMapping("users/login")
  public String login() {
    return "user/login";
  }
}
