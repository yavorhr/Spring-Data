package xmlExercise.cardealer.model.Dto.seedDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name ="suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersRootSeedDto {


    @XmlElement(name ="supplier")
    List<SuppliersWithNameAndImporterDto> suppliers;

    public List<SuppliersWithNameAndImporterDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SuppliersWithNameAndImporterDto> suppliers) {
        this.suppliers = suppliers;
    }
}
