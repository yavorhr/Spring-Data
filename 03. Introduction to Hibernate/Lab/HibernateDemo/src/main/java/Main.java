import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
  public static void main(String[] args) {

    Session session = new Configuration()
            .configure()
            .buildSessionFactory()
            .openSession();

    Transaction transaction = session.beginTransaction();

    //create user
    var user = new User();
    user.setUsername("Pesho");
    user.setPassword("Password");
    session.save(user);

    // getById
    var userPesho = session.get(User.class, 1);
    System.out.println(user1.getId());

    //delete user
    session.delete(userPesho);

    //getById and rename user
    var peshoUser = session.get(User.class,1);
    session.update(peshoUser);

    transaction.commit();

  }
}



