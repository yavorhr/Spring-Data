package com.example.nextleveltech.web.controllers;

import com.example.nextleveltech.model.dto.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  @GetMapping("users/register")
  public String register(){
    return "user/register";
  }

  @PostMapping("users/register")
  public String register(UserRegisterDto userRegisterDto){
    return "user/register";
  }

  @GetMapping("users/login")
  public String login(){
    return "user/login";
  }
}
