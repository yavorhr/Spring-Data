package com.example.nextleveltech.web.controllers;

import jakarta.servlet.http.HttpServletRequest;

public class BaseController {

  private boolean isLogged(HttpServletRequest request){
    var userId = request.getSession().getAttribute("userId");

    return userId != null;
  }
}
