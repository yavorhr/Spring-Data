package com.example.carDealer.domain.dtos.seedDataDtos;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImportDto {

    @XmlAttribute
    private String name;
    @XmlAttribute(name = "is-importer")
    private boolean isImporter;

    public SupplierImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
