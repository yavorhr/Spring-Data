package softuni.exam.models.Dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferDetailsSeedDto {

    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "added-on")
    private String addedOn;
    @XmlElement(name = "has-gold-status")
    private boolean hasGoldStatus;
    @XmlElement(name = "car")
    private CarSeedDto car;
    @XmlElement(name = "seller")
    private SellerIdDto seller;


    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public CarSeedDto getCar() {
        return car;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public SellerIdDto getSeller() {
        return seller;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public void setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCar(CarSeedDto car) {
        this.car = car;
    }

    public void setSeller(SellerIdDto seller) {
        this.seller = seller;
    }
}
