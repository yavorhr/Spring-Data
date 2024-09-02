package softuni.exam.models.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)

public class OffersRootDto {
  @XmlElement(name = "offer")
  private List<OfferDto> offers;

  public List<OfferDto> getOffers() {
    return offers;
  }
}
