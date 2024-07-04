package JOIN_TABLE.entities;
import javax.persistence.*;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {

  private int id;
  private String type;

  protected Vehicle() {
  }

  protected Vehicle(String type) {
    this.type = type;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }
}


