package TABLE_PER_CLASS;


import JOIN_TABLE.entities.Car;
import JOIN_TABLE.entities.Truck;
import JOIN_TABLE.entities.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("soft_uni");
    EntityManager em = emf.createEntityManager();

    // TABLE PER CLASS STRATEGY

//    Vehicle bike = new Bike();
//    Vehicle car = new Car();
//
//    em.getTransaction().begin();
//
//    em.persist(bike);
//    em.persist(car);
//
//    em.getTransaction().commit();

    // JOIN TABLE STRATEGY

    em.getTransaction().begin();

    Vehicle car = new Car("Car", 4);
    Vehicle truck = new Truck("Truck", 30,50);
    em.persist(car);
    em.persist(truck);

    em.getTransaction().commit();
  }
}
