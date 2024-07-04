import entities.Bike;
import entities.Car;
import entities.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
    EntityManager em = emf.createEntityManager();

    Vehicle bike = new Bike();
    Vehicle car = new Car();

    em.getTransaction().begin();
    em.persist(bike);
    em.persist(car);
    em.getTransaction().commit();
  }
}
