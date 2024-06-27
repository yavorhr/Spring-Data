package Core;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {
  private final EntityManager entityManager;
  private BufferedReader bufferedReader;

  public Engine(EntityManager entityManager) {
    this.entityManager = entityManager;
    this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  }

  public void run() {
    System.out.println("Please enter exercise number: ");

    try {
      int exNumber = Integer.parseInt(this.bufferedReader.readLine());

      if (exNumber == 2) {
        ex2changeCasing();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void ex2changeCasing() {
    Query query = this.entityManager.createQuery("UPDATE Town AS t " +
            "SET t.name = UPPER(t.name)" +
            "WHERE LENGTH(t.name) > 5 ");

    this.entityManager.getTransaction().begin();
    query.executeUpdate();

    System.out.println(query.executeUpdate());

    this.entityManager.getTransaction().commit();
  }
}
