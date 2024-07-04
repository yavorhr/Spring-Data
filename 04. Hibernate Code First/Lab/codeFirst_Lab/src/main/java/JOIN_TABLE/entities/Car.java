package JOIN_TABLE.entities;

import SINGLE_TABLE.PassengerVehicle;

import javax.persistence.Entity;

@Entity
public class Car extends PassengerVehicle {
  private final static String type = "CAR";

  public Car(){
  }

  public Car(String type,int numOfPassengers){
    super(type, numOfPassengers);
  }

}
