package xmlExercise.cardealer.model.Dto.seedDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerRootDto {

    @XmlElement(name = "customer")
    List<CustomerDetailsDto> customers;

    public List<CustomerDetailsDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDetailsDto> customers) {
        this.customers = customers;
    }
}
