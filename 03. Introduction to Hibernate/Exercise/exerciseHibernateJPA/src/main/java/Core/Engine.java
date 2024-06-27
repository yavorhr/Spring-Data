package Core;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Engine implements Runnable {
  private final EntityManager entityManager;
  private BufferedReader bufferedReader;

  public Engine(EntityManager entityManager) {
    this.entityManager = entityManager;
    this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  }

  public void run() {

  }
}
