package softuni.exam.models.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "sellers")
public class Seller extends BaseEntity {
  private String firstName;
  private String lastName;
  private String email;
  private RatingEnum rating;
  private String town;

  public Seller() {
  }

  @Column(length = 19)
  public String getFirstName() {
    return firstName;
  }

  @Column(length = 19)
  public String getLastName() {
    return lastName;
  }

  @Column(unique = true)
  public String getEmail() {
    return email;
  }

  @Enumerated(EnumType.STRING)
  public RatingEnum getRating() {
    return rating;
  }

  @NotBlank
  public String getTown() {
    return town;
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

  public void setRating(RatingEnum rating) {
    this.rating = rating;
  }

  public void setTown(String town) {
    this.town = town;
  }
}
