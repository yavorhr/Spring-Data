package xmlExercise.cardealer.model.Dto.queryFour;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsRootViewDtoQuery4 {

    @XmlElement(name = "car")
    List<CarsDetailsViewDtoQ4> cars;

    public List<CarsDetailsViewDtoQ4> getCars() {
        return cars;
    }

    public void setCars(List<CarsDetailsViewDtoQ4> cars) {
        this.cars = cars;
    }
}
