package xmlExercise.cardealer.model.Dto.seedDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsRootDto {

    @XmlElement(name = "car")
    List<CarDetailsDto> cars;

    public List<CarDetailsDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDetailsDto> cars) {
        this.cars = cars;
    }
}
