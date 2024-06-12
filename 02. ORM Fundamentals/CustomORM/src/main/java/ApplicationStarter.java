import ormFramework.core.EntityManager;
import ormFramework.core.EntityManagerFactory;

import java.net.URISyntaxException;
import java.sql.SQLException;

/**

  1) Създаваме Factory клас ( EntityManagerFactory ), който ще върне инстанция от класа EntityManagerImpl.
    EntityManagerImpl е класът, който ще може да управлява на абстрактно ниво базата данни с Java
 методи.
  - EntityManagerImpl ще се нуждае от Connection (връзка) с базата данни. Затова конструкторът му приема Connection dependency.
    В create() методът в EntityManagerFactory ще подадем като параметри :
    dbType, host, port, user, pass, dbName, които ще са нужни на DriverManager класа (createConnection() използва JDBC API и DriverManager).

  2) Преди да се върне такъв обект, искаме да обиколим всички класове в проекта и да намерим тези, които са
 анотирани с анотацията @Entity (това ще е наша анотация, която ще създадем)

 3) Ще гледаме дали такава таблица има в базата, ако няма - ще я създадем по предварително описани @Id
 и @Column(име, тип)

 4) Класчето, което ще се върне от т.1. (EntityManagerFactory) ще има операции :
 - за извличане на обект по ИД find(id, Class);
 - записване на нов или редакция на съществуващ обект persist(Object)
 - изтриване на обект по ИД delete(id, Class)

 */

public class ApplicationStarter {
  public static void main(String[] args) throws SQLException, URISyntaxException, ClassNotFoundException {
    EntityManager entityManager = EntityManagerFactory.create(
            "mysql",
            "localhost",
            3306,
            "root",
            "",
            "orm_test",
            ApplicationStarter.class
    );
  }
}
