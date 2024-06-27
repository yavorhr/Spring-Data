package Core;

import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

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
        case 4 -> ex4salaryOver50000();
        case 5 -> ex5getEmployeesFromDepartment();
        case 6 -> ex6addNewAddressAndUpdateEmployee();
        case 7 -> ex7addressesEmployeeCount();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void ex7addressesEmployeeCount() {
    List<Address> addresses = this.entityManager.createQuery(
            "SELECT a FROM Address AS a " +
                    "ORDER BY a.employees.size DESC", Address.class)
            .setMaxResults(10)
            .getResultList();

    addresses.forEach(address -> {
      System.out.printf("%s, %s - %d employees%n",
              address.getText(),
              address.getTown() == null ? "Unknown" : address.getTown().getName(),
              address.getEmployees().size());
    });
  }

  private void ex6addNewAddressAndUpdateEmployee() throws IOException {
    System.out.println("Please enter employee last name: ");
    String lastName = this.bufferedReader.readLine();

    Employee employee = this.entityManager.createQuery("SELECT e FROM Employee AS e " +
            "WHERE e.lastName = :ln", Employee.class)
            .setParameter("ln", lastName)
            .getSingleResult();

    Address address = initAddressWithTown();

    this.entityManager.getTransaction().begin();
    employee.setAddress(address);
    this.entityManager.getTransaction().commit();
  }

  private Address initAddressWithTown() {
    Address address = new Address();
    address.setText("Vitoshka 15");
    Town town = getTown("Sofia");

    address.setTown(town);

    this.entityManager.getTransaction().begin();
    this.entityManager.persist(address);
    this.entityManager.getTransaction().commit();

    return address;
  }

  private Town getTown(String sofia) {
    return this.entityManager.createQuery("SELECT t FROM Town t " +
            "WHERE t.name = 'Sofia'", Town.class)
            .getSingleResult();
  }

  private void ex5getEmployeesFromDepartment() {
    entityManager.createQuery(
            "SELECT e FROM Employee e " +
                    "WHERE e.department.name = :d_name " +
                    "ORDER BY e.salary, e.id", Employee.class)
            .setParameter("d_name", "Research and Development")
            .getResultStream()
            .forEach(employee -> {
              System.out.printf("%s %s from %s - $%.2f%n",
                      employee.getFirstName(),
                      employee.getLastName(),
                      employee.getDepartment().getName(),
                      employee.getSalary());
            });
  }

  private void ex4salaryOver50000() {
    this.entityManager.createQuery("SELECT e FROM Employee e " +
            "WHERE e.salary > :min_salary", Employee.class)
            .setParameter("min_salary", BigDecimal.valueOf(50000L))
            .getResultList()
            .stream()
            .map(Employee::getFirstName)
            .forEach(System.out::println);

//    entityManager.createQuery("SELECT e FROM Employee e " +
//            "WHERE e.salary > :min_salary", Employee.class)
//            .setParameter("min_salary", BigDecimal.valueOf(50000L))
//            .getResultStream()
//            .map(Employee::getFirstName)
//            .forEach(System.out::println);
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
//    System.out.println(query.executeUpdate());
    this.entityManager.getTransaction().commit();
  }
}
