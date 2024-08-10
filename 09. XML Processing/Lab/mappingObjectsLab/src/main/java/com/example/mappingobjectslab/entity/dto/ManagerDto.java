package com.example.mappingobjectslab.entity.dto;

import com.google.gson.annotations.Expose;
import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "manager")
@XmlAccessorType(XmlAccessType.FIELD)
public class ManagerDto extends BasicEmployeeDto{

    @Expose
    @XmlElementWrapper(name = "subordinates")
    @XmlElement(name = "employee")
    private List<EmployeeDto> subordinates;

    public List<EmployeeDto> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<EmployeeDto> subordinates) {
        this.subordinates = subordinates;
    }
}
