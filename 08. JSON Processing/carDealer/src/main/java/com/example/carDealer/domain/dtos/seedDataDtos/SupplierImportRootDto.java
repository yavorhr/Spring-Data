package com.example.carDealer.domain.dtos.seedDataDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name  = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImportRootDto {

    @XmlElement(name = "supplier")
    private List<SupplierImportDto> supplierImportDtos;

    public SupplierImportRootDto() {
    }

    public List<SupplierImportDto> getSuppliers() {
        return supplierImportDtos;
    }

    public void setSupplierDtos(List<SupplierImportDto> supplierImportDtos) {
        this.supplierImportDtos = supplierImportDtos;
    }
}
