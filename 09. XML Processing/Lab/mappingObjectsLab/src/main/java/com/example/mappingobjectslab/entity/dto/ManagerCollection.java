package com.example.mappingobjectslab.entity.dto;

import com.google.gson.annotations.Expose;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "managers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ManagerCollection {

    @XmlElement(name = "manager")
    @Expose
    private List<ManagerDto> managers;

    public ManagerCollection(List<ManagerDto> managers) {
        this.managers = managers;
    }

    public ManagerCollection() {
    }

    public List<ManagerDto> getManagers() {
        return managers;
    }

    public void setManagers(List<ManagerDto> managers) {
        this.managers = managers;
    }
}
