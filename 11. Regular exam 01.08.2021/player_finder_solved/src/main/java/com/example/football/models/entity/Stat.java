package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity{

    private double shooting;
    private double passing;
    private double endurance;

    public Stat() {
    }

    @Column(name = "shooting",nullable = false)
    public double getShooting() {
        return shooting;
    }
    @Column(name = "passing",nullable = false)
    public double getPassing() {
        return passing;
    }
    @Column(name = "endurance",nullable = false)
    public double getEndurance() {
        return endurance;
    }

    public void setShooting(double shooting) {
        this.shooting = shooting;
    }

    public void setPassing(double passing) {
        this.passing = passing;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }
}
