package softuni.exam.models.dto.xml;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferDto {

  @XmlElement
  private Double price;
  @XmlElement
  private OfferAgentDto agent;
  @XmlElement
  private OfferApartmentDto apartment;
  @XmlElement(name = "publishedOn")
  private String publishedOn;

  @Positive
  @NotNull
  public Double getPrice() {
    return price;
  }

  @NotNull
  public OfferAgentDto getAgent() {
    return agent;
  }

  @NotNull
  public OfferApartmentDto getApartment() {
    return apartment;
  }

  @NotNull
  public String getPublishedOn() {
    return publishedOn;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setAgent(OfferAgentDto agent) {
    this.agent = agent;
  }

  public void setApartment(OfferApartmentDto apartment) {
    this.apartment = apartment;
  }

  public void setPublishedOn(String publishedOn) {
    this.publishedOn = publishedOn;
  }
}
