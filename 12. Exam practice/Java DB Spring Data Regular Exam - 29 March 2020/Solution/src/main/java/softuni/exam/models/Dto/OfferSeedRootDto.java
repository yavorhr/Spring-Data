package softuni.exam.models.Dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferSeedRootDto {

    @XmlElement(name = "offer")
    private List<OfferDetailsSeedDto> offers;

    public List<OfferDetailsSeedDto> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferDetailsSeedDto> offers) {
        this.offers = offers;
    }
}
