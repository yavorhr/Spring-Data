package JOIN_TABLE.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PassengerVehicle extends Vehicle {
  private int numOfPassengers;

  public PassengerVehicle() {
  }

  public PassengerVehicle(String type, int numOfPassengers) {
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
