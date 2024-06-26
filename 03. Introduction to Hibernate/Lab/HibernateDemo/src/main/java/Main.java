
import entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    SessionFactory sessionFactory = new Configuration()
            .configure()
            .buildSessionFactory();

    EntityManager session = sessionFactory.openSession();

    TypedQuery<User> query = session.createQuery("SELECT u FROM User u where u.username = :un", User.class);
    query.setParameter("un", "pesho");
    List<User> resultList = query.getResultList();

    resultList.forEach(u -> System.out.println(u.getUsername()));


//    //create user
//    var user = new User();
//    user.setUsername("Pesho");
//    user.setPassword("Password");
//    session.save(user);
//
//    // getById
//    var userPesho = session.get(User.class, 1);
//    System.out.println(userPesho.getId());
//
//    //delete user
//    session.delete(userPesho);
//
//    //getById and rename user
//    var peshoUser = session.get(User.class,1);
//    session.update(peshoUser);
//
    transaction.commit();
  }
}



