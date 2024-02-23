package softuni.exam.models.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "passengers")
public class Passenger extends BaseEntity {

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String email;
    private Town town;
    private Set<Ticket> tickets;

    public Passenger() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }
    @Column(name = "age")
    public int getAge() {
        return age;
    }
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }
    @Column(name = "email",unique = true)
    public String getEmail() {
        return email;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    @OneToMany(mappedBy = "passenger",fetch = FetchType.EAGER)
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
