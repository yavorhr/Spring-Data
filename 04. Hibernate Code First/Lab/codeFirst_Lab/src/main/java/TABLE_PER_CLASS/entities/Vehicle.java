package TABLE_PER_CLASS.entities;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {

  private long id;
  private String type;

  protected Vehicle() {
  }

  protected Vehicle(String type) {
    this.type = type;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Basic
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}