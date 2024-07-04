package JOIN_TABLE.entities;

import javax.persistence.Entity;

@Entity
public class Car extends PassengerVehicle {
  private final static String type = "CAR";

  public Car(){
  }

  public Car(String type,int numOfPassengers){
    super(type, numOfPassengers);
  }

  @Override
  public static String getType() {
    return type;
  }
}
