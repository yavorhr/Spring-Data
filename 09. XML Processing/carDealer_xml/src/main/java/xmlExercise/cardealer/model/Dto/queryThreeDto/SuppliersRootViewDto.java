package xmlExercise.cardealer.model.Dto.queryThreeDto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersRootViewDto {

    @XmlElement(name = "supplier")
    List<SuppliersDetailsViewDto> suppliers;

    public List<SuppliersDetailsViewDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SuppliersDetailsViewDto> suppliers) {
        this.suppliers = suppliers;
    }
}
