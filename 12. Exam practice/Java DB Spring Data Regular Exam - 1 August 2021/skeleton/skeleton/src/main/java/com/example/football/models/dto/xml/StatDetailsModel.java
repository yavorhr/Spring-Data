package com.example.football.models.dto.xml;


import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatDetailsModel {

    @XmlElement(name = "passing")
    private double passing;
    @XmlElement(name = "shooting")
    private double shooting;
    @XmlElement(name = "endurance")
    private double endurance;

    @Positive
    public double getPassing() {
        return passing;
    }

    @Positive
    public double getEndurance() {
        return endurance;
    }

    @Positive
    public double getShooting() {
        return shooting;
    }

    public void setShooting(double shooting) {
        this.shooting = shooting;
    }



    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    public void setPassing(double passing) {
        this.passing = passing;
    }
}
