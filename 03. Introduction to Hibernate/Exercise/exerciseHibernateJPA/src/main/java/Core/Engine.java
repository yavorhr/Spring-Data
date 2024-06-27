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

      switch (exNumber) {
        case 2 -> ex2changeCasing();
        case 3 -> ex3containsEmployee();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void ex3containsEmployee() throws IOException {
    String[] fullName = bufferedReader.readLine().split("\\s+");
    String firstName = fullName[0];
    String lastName = fullName[1];

    Long singleResult = this.entityManager.createQuery(
            "SELECT count(e) FROM Employee e " +
                    "WHERE e.firstName=:fn AND e.lastName=:ln", Long.class)
            .setParameter("fn", firstName)
            .setParameter("ln", lastName)
            .getSingleResult();

    System.out.println(singleResult == 0 ? "No" : "Yes");
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
