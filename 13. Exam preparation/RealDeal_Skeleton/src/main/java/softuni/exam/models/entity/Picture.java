package softuni.exam.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {
  private String name;
  private LocalDateTime dateAndTime;

  public Picture() {
  }

  @Column(length = 19, unique = true)
  public String getName() {
    return name;
  }

  @Column
  public LocalDateTime getDateAndTime() {
    return dateAndTime;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDateAndTime(LocalDateTime dateAndTime) {
    this.dateAndTime = dateAndTime;
  }
}
