package bg.codexio.customOrmDemo;


import bg.codexio.customOrmDemo.entity.Address;
import bg.codexio.customOrmDemo.entity.Department;
import bg.codexio.customOrmDemo.entity.Employee;
import ormFramework.core.EntityManager;
import ormFramework.core.EntityManagerFactory;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1) Създаваме Factory клас ( EntityManagerFactory ), който ще върне инстанция от класа EntityManagerImpl.
 * EntityManagerImpl е класът, който ще управлява на абстрактно ниво базата данни с Java методи.
 * 1.1)  EntityManagerImpl ще се нуждае от Connection (връзка) с базата данни. Затова конструкторът му приема Connection dependency.
 * В create() методът във Factory класа ще подадем като параметри :
 * dbType, host, port, user, pass, dbName,
 * които ще са нужни на DriverManager класа (createConnection() използва JDBC API и DriverManager).
 * 1.2) Създаваме си наши анотации, които ще използваме при създаването на таблици в базата данни.
 * Анотациите са вид интерфейс, които приемат :
 *
 * @Retention - кога да се използват. Избираме Runtime.
 * @Target - върху какво парче код можем да ги използваме - методи, класове и т.н. Избираме Type за клас, и .Field за полетата.
 * 2) Преди да върнем EntityManagerImpl и създадената Connection като инстанция от Factory класа,
 * искаме да обиколим всички класове в проекта и да намерим тези, които са анотирани с анотацията @Entity.
 * Това се случва в getEntities(mainClass) и scanEntities() във Factory класа.
 * 2.1 ) getEntities() приема като стартова точка ApplicationStarter класа, т.е. Main, от който се стартира програмата.
 * С reflection взимаме името на директорията, в което се намира ApplicationStarter, и от която директория ще започнем
 * да търсим със scanEntities() класове, анотирани с @entity.
 * 2.2) scanEntities() използва отново reflection за да сканира всички класове в проекта с анотаиця @entity.
 * По-конкретно в scanEntities() се проверява всеки File в package name-a, който зададохме от getEntities() метода.
 * Тъй като файл може да е и директория и файл, първо проверяваме дали първо е директория.
 * Ако е директория, с рекурсия отново се извиква същия метод, за да се проверят и файловете в нея.
 * Ако не е директория, значи е файл, затова проверяваме дали е .class file.
 * Ако е .class file, проверяваме дали има анотация isAnnotationPresent(Entity.class),
 * Ако има такава, добавяме класа при всички класове, които ще запишем в базата данни.
 * <p>
 * 3) След като сме сканирали всички класове в проекта и сме ги запазили, е време да си създадем таблиците в базата данни.
 * В createTables() във Factory класа приемаме Connection и анотираните класове.
 * Обхождаме всеки един клас и създаваме String query statement, като взимаме :
 * - името на таблицата - entityInfo.tableName();
 * - @id Primary Key -   if (field.isAnnotationPresent(Id.class)){...}
 * - fields, или колоните в базата данни - else if (field.isAnnotationPresent(Column.class)){...}
 * Накрая execute-ваме statement-a, което ще създаде таблиците в базата данни : connection.createStatement().execute(sql);
 * N.B. Няма проверка за това дали вече има такива създадени таблици!
 * <p>
 * 4) EntityManagerImpl / EntityManager e класът, който ще държи логиакта за създаване на query-та към базата данни.
 * Както видяхме от т.1, Factory функцията връща инстанция от него, като му подава и Connection параметър, който
 * ще е нужен за statement()-ите, които ще правим към базата данни.
 * <p>
 * EntityManagerImpl може да извършва следните query-та към базата :
 * - за извличане на обект по ИД findById(id, Class<T> type);
 * - записване на нов или редакция на съществуващ обект persist(Object)
 * - изтриване на обект по ИД delete(id, Class)
 * <p>
 * 4.1) findById(id, Class)
 * Методът приема id, по което ще търсим, и Class<T> type или в коя таблица ще търсим - Employee, Department или Address.
 * 4.2) boolean persist(T entity)
 * В ApplicationStarter (Main) създаваме User обекти, които искаме да запаметим в базата данни.
 * В зависимост от това дали User-ът със сътветното Id вече съществува в базата данни, или не, в persist(T entity) методът имаме два основни метода :
 * - doInsert(entity) : ако User е с id 0, т.е. не сме му задали id, ще създадем нов user в базата данни.
 * - doUpdate(id, entity) : ако все пак вече имаме User с такова id в базата данни, то няма да запаметяваме наново данните, а просто ще го update-нем.
 * 4.3)
 */
public class ApplicationStarter {
  public static void main(String[] args) throws SQLException, URISyntaxException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    EntityManager entityManager = EntityManagerFactory.create(
            "mysql",
            "localhost",
            3306,
            "root",
            "",
            "test_orm",
            ApplicationStarter.class
    );

    //User user = new User("Pesho1", 17);
//        User maria = new User("Maria", 25);

//        entityManager.persist(maria);

    //User pesho = entityManager.findById(1, User.class);
    // User maria = entityManager.findById(3, User.class);
//        pesho.setAge(30);
//        entityManager.persist(user);

    //entityManager.delete(maria);
//        User user = new User();


//
//        Address softUniAddress = entityManager.findById(1, Address.class);
//        Address codexioAddress = entityManager.findById(2, Address.class);
//        Department byId1 = entityManager.findById(30, Department.class);


    //    entityManager.alterTable(User.class);

  }
}

