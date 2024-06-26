
import entity.City;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("softuni");
    EntityManager entityManager = emf.createEntityManager();

    entityManager.getTransaction().begin();

    var sofia = new City();
    sofia.setName("Sofia");

    var pesho = new User();
    pesho.setUsername("Pesho");
    pesho.setPassword("123");
    pesho.setCity(sofia);

    entityManager.persist(pesho);

    entityManager.getTransaction().commit();
  }
}



