package com.example.carDealer.domain.dtos.views;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerExportRootDto {
    @XmlElement(name = "customer")
    private List<CustomerExportDto> customers;

    public CustomerExportRootDto() {
    }

    public List<CustomerExportDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerExportDto> customers) {
        this.customers = customers;
    }
}
