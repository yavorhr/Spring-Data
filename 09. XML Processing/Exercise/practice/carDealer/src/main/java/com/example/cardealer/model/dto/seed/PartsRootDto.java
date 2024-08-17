package com.example.cardealer.model.dto.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsRootDto {

  @XmlElement(name = "part")
  private List<PartNamePriceQuantityDto> parts;

  public List<PartNamePriceQuantityDto> getParts() {
    return parts;
  }
}
