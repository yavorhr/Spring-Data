package xmlExercise.cardealer.model.Dto.queryOneDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersRootViewDto {

    @XmlElement(name = "customer")
    List<CustomerViewDetailsDto> customerDetails;

    public List<CustomerViewDetailsDto> getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(List<CustomerViewDetailsDto> customerDetails) {
        this.customerDetails = customerDetails;
    }
}
