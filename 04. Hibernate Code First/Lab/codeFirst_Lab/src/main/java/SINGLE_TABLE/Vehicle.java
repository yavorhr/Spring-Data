package SINGLE_TABLE;
import javax.persistence.*;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
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
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(insertable = false,updatable = false)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
