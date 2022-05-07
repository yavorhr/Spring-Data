package softuni.exam.models.Dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanesRootDto {

    @XmlElement(name = "plane")
    private List<PlanesDetailsDto> planes;

    public List<PlanesDetailsDto> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlanesDetailsDto> planes) {
        this.planes = planes;
    }
}
