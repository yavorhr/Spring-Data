import ormFramework.core.EntityManager;
import ormFramework.core.EntityManagerFactory;

import java.net.URISyntaxException;
import java.sql.SQLException;

/**

  1) Създаваме клас (EntityManagerFactory), в който да регистрираме настройките за връзка с базата данни
  - вид база, потребителско име и парола, както и името на базата данни.
   Този клас в ответ ще върне обект, който ще може да управлява на абстрактно ниво базата данни, а именно EntityManagerImpl.

  2) Преди да се върне такъв обект, искаме да обиколим всички класове в проекта и да намерим тези, които са
 анотирани с анотацията @Entity (това ще е наша анотация, която ще създадем)

 3) Ще гледаме дали такава таблица има в базата, ако няма - ще я създадем по предварително описани @Id
 и @Column(име, тип)

 4) Класчето, което ще се върне от т.1. (EntityManagerFactory) ще има операции :
 - за извличане на обект по ИД find(id, Class);
 - записване на нов или редакция на съществуващ обект persist(Object)
 - изтриване на обект по ИД delete(id, Class)

 */

public class Main {
  public static void main(String[] args) throws SQLException, URISyntaxException, ClassNotFoundException {
    EntityManager entityManager = EntityManagerFactory.create(
            "mysql",
            "localhost",
            3306,
            "root",
            "",
            "test_orm",
            Main.class
    );
  }
}
