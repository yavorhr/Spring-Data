package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agents")
public class Agent extends BaseEntity {
  private String email;
  private String firstName;
  private String latName;
  private Town town;

  public Agent() {
  }

  @Column(nullable = false,unique = true)
  public String getEmail() {
    return email;
  }

  @Column(nullable = false,unique = true)
  public String getFirstName() {
    return firstName;
  }

  @Column(nullable = false)
  public String getLatName() {
    return latName;
  }

  @ManyToOne
  public Town getTown() {
    return town;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLatName(String latName) {
    this.latName = latName;
  }

  public void setTown(Town town) {
    this.town = town;
  }
}
