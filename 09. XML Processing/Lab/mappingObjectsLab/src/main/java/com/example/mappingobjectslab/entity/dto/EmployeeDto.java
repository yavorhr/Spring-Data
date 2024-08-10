package com.example.mappingobjectslab.entity.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"firstName", "lastName", "income"})
public class EmployeeDto extends BasicEmployeeDto{

    @Expose
    @SerializedName("salary")
    @XmlAttribute
    private BigDecimal income;

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal salary) {
        this.income = salary;
    }
}
