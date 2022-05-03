package com.example.carDealer.domain.dtos.views;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierNotImportRootDto {

    @XmlElement(name = "supplier")
    private List<SupplierNotImportDto>suppliers;

    public SupplierNotImportRootDto() {
    }

    public List<SupplierNotImportDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierNotImportDto> suppliers) {
        this.suppliers = suppliers;
    }
}
