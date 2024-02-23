package softuni.exam.models.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity{

    private String serialNumber;
    private BigDecimal price;
    private LocalDateTime takeoff;
    private Plane plane;
    private Passenger passenger;
    private Town fromTown;
    private Town toTown;

    public Ticket() {
    }

    @ManyToOne()
    public Town getFromTown() {
        return fromTown;
    }

    @ManyToOne ()
    public Town getToTown() {
        return toTown;
    }

    @ManyToOne
    public Plane getPlane() {
        return plane;
    }

    @ManyToOne
    public Passenger getPassenger() {
        return passenger;
    }

    @Column(name = "serial_number",unique = true)
    public String getSerialNumber() {
        return serialNumber;
    }
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }
    @Column(name = "takeoff")
    public LocalDateTime getTakeoff() {
        return takeoff;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTakeoff(LocalDateTime takeoff) {
        this.takeoff = takeoff;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setFromTown(Town fromTown) {
        this.fromTown = fromTown;
    }

    public void setToTown(Town toTown) {
        this.toTown = toTown;
    }
}
