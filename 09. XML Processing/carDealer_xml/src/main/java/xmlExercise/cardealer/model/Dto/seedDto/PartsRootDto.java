package xmlExercise.cardealer.model.Dto.seedDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsRootDto {

    @XmlElement(name = "part")
    List<PartsWithNamePriceAndQuantityDto> partsWithNamePriceAndQuantityDtoList;

    public List<PartsWithNamePriceAndQuantityDto> getPartsWithNamePriceAndQuantityDtoList() {
        return partsWithNamePriceAndQuantityDtoList;
    }

    public void setPartsWithNamePriceAndQuantityDtoList(List<PartsWithNamePriceAndQuantityDto> partsWithNamePriceAndQuantityDtoList) {
        this.partsWithNamePriceAndQuantityDtoList = partsWithNamePriceAndQuantityDtoList;
    }
}
