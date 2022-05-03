package com.example.carDealer.domain.dtos.views;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierNotImportDto {

    @XmlAttribute
    private long id;
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "parts-count")
    private int partsSize;

    public SupplierNotImportDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartsSize() {
        return partsSize;
    }

    public void setPartsSize(int partsSize) {
        this.partsSize = partsSize;
    }
}
