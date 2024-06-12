import ormFramework.core.EntityManager;
import ormFramework.core.EntityManagerFactory;

import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * 1) Създаваме Factory клас ( EntityManagerFactory ), който ще върне инстанция от класа EntityManagerImpl.
  EntityManagerImpl е класът, който ще управлява на абстрактно ниво базата данни с Java методи.
  1.1)  EntityManagerImpl ще се нуждае от Connection (връзка) с базата данни. Затова конструкторът му приема Connection dependency.
  В create() методът във Factory класа ще подадем като параметри :
  dbType, host, port, user, pass, dbName,
  които ще са нужни на DriverManager класа (createConnection() използва JDBC API и DriverManager).
  1.2) Създаваме си наши анотации, които ще използваме при създаването на таблици в базата данни.
  Анотациите са вид интерфейс, които приемат :
  @Retention - кога да се използват. Избираме Runtime.

  @Target - върху какво парче код можем да ги използваме - методи, класове и т.н. Избираме Type за клас, и .Field за полетата.
  2) Преди да върнем EntityManagerImpl и създадената Connection като инстанция от Factory класа,
  искаме да обиколим всички класове в проекта и да намерим тези, които са анотирани с анотацията @Entity.
  Това се случва в getEntities(mainClass) и scanEntities() във Factory класа.
  2.1 ) getEntities() приема като стартова точка ApplicationStarter класа, т.е. Main, от който се стартира програмата.
  С reflection взимаме името на директорията, в което се намира ApplicationStarter, и от която директория ще започнем
  да търсим със scanEntities() класове, анотирани с @entity.
  2.2) scanEntities() използва отново reflection за да сканира всички класове в проекта с анотаиця @entity.
  По-конкретно в scanEntities() се проверява всеки File в package name-a, който зададохме от getEntities() метода.
  Тъй като файл може да е и директория и файл, първо проверяваме дали първо е директория.
  Ако е директория, с рекурсия отново се извиква същия метод, за да се проверят и файловете в нея.
  Ако не е директория, значи е файл, затова проверяваме дали е .class file.
  Ако е .class file, проверяваме дали има анотация isAnnotationPresent(Entity.class),
  Ако има такава, добавяме класа при всички класове, които ще запишем в базата данни.
  <p>
  3) Ще гледаме дали такава таблица има в базата, ако няма - ще я създадем по предварително описани @Id
  и @Column(име, тип)
  <p>
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
