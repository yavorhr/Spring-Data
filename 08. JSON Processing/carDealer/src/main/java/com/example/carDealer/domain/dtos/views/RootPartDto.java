package com.example.carDealer.domain.dtos.views;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "pars")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootPartDto {
    @XmlElement(name = "part")
    private List<PartDto> parts;

    public RootPartDto() {
    }

    public List<PartDto> getParts() {
        return parts;
    }

    public void setParts(List<PartDto> parts) {
        this.parts = parts;
    }
}
