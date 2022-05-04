package xmlExercise.cardealer.model.Dto.queryFour;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartRootViewDto {

    @XmlElement(name = "part")
    List<PartsDetailsVIewDto> parts;


    public List<PartsDetailsVIewDto> getParts() {
        return parts;
    }

    public void setParts(List<PartsDetailsVIewDto> parts) {
        this.parts = parts;
    }
}
