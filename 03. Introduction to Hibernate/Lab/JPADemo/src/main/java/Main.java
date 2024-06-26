
import entity.User;
import javax.persistence.TypedQuery;

public class Main {
  public static void main(String[] args) {

    String SessionFactory sessionFactory = new Configuration()
            .configure()
            .buildSessionFactory();

    Session session = sessionFactory.openSession();

    Transaction transaction = session.beginTransaction();

    TypedQuery<User> query = session.createQuery("SELECT u FROM User u JOIN FETCH u.city c WHERE c.name =:city_name", User.class);
    query.setParameter("city_name", "Sofia");
    query.getResultList().forEach(u -> System.out.println(u));

//    TypedQuery<User> query = session.createQuery("SELECT u FROM User u where u.username = :un", User.class);
//    query.setParameter("un", "pesho");
//    List<User> resultList = query.getResultList();
//
//    resultList.forEach(u -> System.out.println(u.getUsername()));


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
    ;

  }
}



