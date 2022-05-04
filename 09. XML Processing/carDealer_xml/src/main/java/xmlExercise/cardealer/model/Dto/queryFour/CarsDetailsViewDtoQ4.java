package xmlExercise.cardealer.model.Dto.queryFour;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsDetailsViewDtoQ4 {

    @XmlAttribute(name = "make")
    private String make;
    @XmlAttribute(name = "model")
    private String model;
    @XmlAttribute(name = "travelledDistance")
    private long travelledDistance;

    @XmlElement(name = "parts")
    private PartRootViewDto rootPartDto;


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public PartRootViewDto getRootPartDto() {
        return rootPartDto;
    }

    public void setRootPartDto(PartRootViewDto rootPartDto) {
        this.rootPartDto = rootPartDto;
    }


}
