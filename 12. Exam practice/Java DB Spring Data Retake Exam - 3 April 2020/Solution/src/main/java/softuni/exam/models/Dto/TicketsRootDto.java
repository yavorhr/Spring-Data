package softuni.exam.models.Dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketsRootDto {

    @XmlElement(name = "ticket")
    private List<TicketDetailsDto> tickets;

    public List<TicketDetailsDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDetailsDto> tickets) {
        this.tickets = tickets;
    }
}
