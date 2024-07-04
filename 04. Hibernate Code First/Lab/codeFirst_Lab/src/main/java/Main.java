import entities.Car;
import entities.Truck;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Engine engineTruck = new Engine("truck_engine");
    Engine engineCar = new Engine("car_engine");

    Vehicle car = new Car("Mercedes", "AMG", 300, engineCar);
    Vehicle truck = new Truck("Volvo", "322S", 500, engineTruck);

    List<Vehicle> vehicleList = new ArrayList<>();
    vehicleList.add(car);
    vehicleList.add(truck);

    vehicleList.forEach(v -> {
      System.out.printf("Vehicle is from type %s. Vehicle is starting the engine...",
              v.getClass().getSimpleName());
      v.ignite();
    });

  }
}
