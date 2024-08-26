package com.example.nextleveltech.model.dto.xml;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectDto {

  @XmlElement
  private String name;
  @XmlElement
  private String description;
  @XmlElement(name = "is-finished")
  private boolean isFinished;
  @XmlElement(name = "start-date")
  private String startDate;
  @XmlElement
  private BigDecimal payment;
  @XmlElement(name = "company name")
  private String companyName;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isFinished() {
    return isFinished;
  }

  public void setFinished(boolean finished) {
    isFinished = finished;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public BigDecimal getPayment() {
    return payment;
  }

  public void setPayment(BigDecimal payment) {
    this.payment = payment;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }
}
