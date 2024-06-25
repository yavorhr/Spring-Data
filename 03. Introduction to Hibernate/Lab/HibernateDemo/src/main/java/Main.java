import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
  public static void main(String[] args) {

    Session session = new Configuration().configure().buildSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();

    transaction.commit();
  }
}



