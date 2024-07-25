package com.example.dto_exercise.userContext;

import org.springframework.stereotype.Component;

@Component
public class UserContext {
  private Long id;
  private String email;
  private String fullName;
  private String password;
  private boolean isAdmin;

  public Long getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void saveSession(Long id, String email, String fullName, String password, boolean isAdmin) {
    this.id = id;
    this.email = email;
    this.fullName = fullName;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  public void removeSession() {
    this.id = 0L;
    this.email = "";
    this.fullName = "";
    this.password = "";
  }

}
