package com.example.mappingobjectslab.entity.dto;

public class EmployeeAverageSalaryDto {

    private double avgSalary;

    private Long sumSize;

    public EmployeeAverageSalaryDto(double avgSalary, Long sumSize) {
        this.avgSalary = avgSalary;
        this.sumSize = sumSize;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    public Long getSumSize() {
        return sumSize;
    }

    public void setSumSize(Long sumSize) {
        this.sumSize = sumSize;
    }
}
