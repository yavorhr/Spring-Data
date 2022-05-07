package softuni.exam.models.Dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerSeedRootDto {

    @XmlElement(name = "seller")
    private List<SellerDetailsDto> sellersList;


    public List<SellerDetailsDto> getSellersList() {
        return sellersList;
    }

    public void setSellersList(List<SellerDetailsDto> sellersList) {
        this.sellersList = sellersList;
    }
}
