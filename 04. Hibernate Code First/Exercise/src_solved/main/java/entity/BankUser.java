package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "bank_users")
public class BankUser extends BaseEntity {

    @Column(nullable = false,name="first_name")
    private String firstName;

    @Column(nullable = false,name="last_name")
    private String lastName;

    @Column(nullable = false,name="email")
    private String email;

    @Column(nullable = false,name="password")
    private String password;


    public BankUser() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
