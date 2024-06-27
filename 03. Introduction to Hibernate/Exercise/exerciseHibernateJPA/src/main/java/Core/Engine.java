package Core;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        case 8 -> ex8getEmployeeById();
        case 9 -> ex9findLatest10Projects();
        case 10 -> ex10updateSalary();
        case 11 -> ex11findEmployeesByFirstName();
        case 12 -> ex12employeeMaxSalaries();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  private void ex12employeeMaxSalaries() {
    List<Object[]> resultList = entityManager.createNativeQuery(
            "SELECT d.name, MAX(e.salary) AS `m_salary`\n" +
                    "FROM departments AS d\n" +
                    "JOIN employees e on d.department_id = e.department_id\n" +
                    "GROUP BY d.name\n" +
                    "HAVING `m_salary` NOT BETWEEN 30000 AND 70000;")
            .getResultList();

    resultList.forEach(obj -> System.out.println(obj[0] + " " + obj[1]));

//    String jpql = "SELECT d.name, MAX(e.salary) " +
//            "FROM Department d JOIN d.employees e " +
//            "GROUP BY d.name " +
//            "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000";
//
//    TypedQuery<Object[]> query = this.entityManager.createQuery(jpql, Object[].class);
//    List<Object[]> results = query.getResultList();
//
//    for (Object[] result : results) {
//      String departmentName = (String) result[0];
//      BigDecimal maxSalary = (BigDecimal) result[1];
//      System.out.println("Department: " + departmentName + ", Max Salary: " + maxSalary);
    }

  private void ex11findEmployeesByFirstName() throws IOException {
    System.out.println("Please enter required pattern: ");
    String input = bufferedReader.readLine();

    String pattern = input + "%";
    this.entityManager.createQuery("SELECT e FROM Employee AS e" +
            " WHERE e.firstName " +
            "LIKE :patt", Employee.class)
            .setParameter("patt", pattern)
            .getResultStream()
            .forEach(e -> {
              System.out.printf("%s %s - %s - ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary());
            });
  }

  private void ex10updateSalary() {
    Query query = this.entityManager.createQuery(
            "UPDATE Employee AS e " +
                    "SET e.salary = e.salary *1.2" +
                    "WHERE e.department.id IN :ids")
            .setParameter("ids", Set.of(1, 2, 4, 11));

    this.entityManager.getTransaction().begin();
    System.out.println(query.executeUpdate());
    this.entityManager.getTransaction().commit();

  }

  private void ex9findLatest10Projects() {
    List<Project> resultList = this.entityManager.createQuery("SELECT p FROM Project AS p " +
            "ORDER BY p.startDate DESC", Project.class)
            .setMaxResults(10)
            .getResultList();

    resultList.sort(Comparator.comparing(Project::getName));

    StringBuilder sb = new StringBuilder();

    resultList.forEach(p -> {
      sb.append("Project name: " + p.getName()).append(System.lineSeparator());
      sb.append("Project Description: ").append(p.getDescription()).append(System.lineSeparator());
      sb.append("Project Start Date: ").append(p.getStartDate()).append(System.lineSeparator());
      sb.append("Project End Date: ").append(p.getEndDate()).append(System.lineSeparator());
    });

    System.out.println(sb);
  }

  private void ex8getEmployeeById() throws IOException {
    int employeeId = Integer.parseInt(this.bufferedReader.readLine());

    Employee employee = entityManager.find(Employee.class, employeeId);

    StringBuilder sb = new StringBuilder();

    employee
            .getProjects()
            .forEach(project -> sb.append(project.getName()).append("\n"));

    System.out.printf("%s %s - %s\n %s",
            employee.getFirstName(),
            employee.getLastName(),
            employee.getJobTitle(),
            sb.toString());
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
            .getResultStream()
            .map(Employee::getFirstName)
            .forEach(System.out::println);
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
