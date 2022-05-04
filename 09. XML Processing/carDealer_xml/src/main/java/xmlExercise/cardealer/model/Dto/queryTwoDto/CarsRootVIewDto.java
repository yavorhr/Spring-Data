package xmlExercise.cardealer.model.Dto.queryTwoDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsRootVIewDto {

    @XmlElement(name = "car")
    private List<CarsDetailsViewDto> cars;

    public List<CarsDetailsViewDto> getCars() {
        return cars;
    }

    public void setCars(List<CarsDetailsViewDto> cars) {
        this.cars = cars;
    }
}
