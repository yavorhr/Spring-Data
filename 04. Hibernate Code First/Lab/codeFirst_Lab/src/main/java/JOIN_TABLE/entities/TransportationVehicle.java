package JOIN_TABLE.entities;

import SINGLE_TABLE.Vehicle;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TransportationVehicle extends Vehicle {
  private int loadCapacity;

  public TransportationVehicle(){
  }

  protected TransportationVehicle(String type,int loadCapacity) {
    super(type);
    this.loadCapacity = loadCapacity;
  }

  public int getLoadCapacity() {
    return this.loadCapacity;
  }

  public void setLoadCapacity(int loadCapacity) {
    this.loadCapacity = loadCapacity;
  }


}
