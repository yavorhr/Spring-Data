package com.example.carDealer.domain.dtos.views;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesCustomerRootDto {

    @XmlElement(name = "customer")
    private List<SalesCustomerDto> customers;

    public SalesCustomerRootDto() {
    }

    public List<SalesCustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<SalesCustomerDto> customers) {
        this.customers = customers;
    }
}
