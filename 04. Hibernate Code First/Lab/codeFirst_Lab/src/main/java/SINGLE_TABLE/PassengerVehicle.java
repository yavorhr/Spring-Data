package SINGLE_TABLE;
import JOIN_TABLE.entities.Vehicle;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PassengerVehicle extends Vehicle {
  private int numOfPassengers;

  public PassengerVehicle() {
  }

  protected PassengerVehicle(String type, int numOfPassengers) {
    super(type);
    this.numOfPassengers = numOfPassengers;
  }

  public int getNumOfPassengers() {
    return this.numOfPassengers;
  }

  public void setNumOfPassengers(int numOfPassengers) {
    this.numOfPassengers = numOfPassengers;
  }


}
