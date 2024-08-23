package com.example.nextleveltech.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "projects")
public class Project extends BaseEntity {
  private String name;
  private String description;
  private boolean isFinished;
  private BigDecimal payment;
  private Date startDate;
  private Company company;

  public Project() {
  }

  @Column(nullable = false)
  public String getName() {
    return name;
  }

  @Column(nullable = false)
  public String getDescription() {
    return description;
  }

  @Column(name = "is_finished", nullable = false)
  public boolean isFinished() {
    return isFinished;
  }

  @Column(nullable = false)
  public BigDecimal getPayment() {
    return payment;
  }

  @Column(columnDefinition = "DATE")
  public Date getStartDate() {
    return startDate;
  }

  @ManyToOne
  public Company getCompany() {
    return company;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setFinished(boolean finished) {
    isFinished = finished;
  }

  public void setPayment(BigDecimal payment) {
    this.payment = payment;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public void setCompany(Company company) {
    this.company = company;
  }
}
