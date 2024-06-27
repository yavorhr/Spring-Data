import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
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

    @Override
    public void run() {
        System.out.println("Select exercise number: ");

        try {
            int exNumber = Integer.parseInt(bufferedReader.readLine());

            switch (exNumber) {
                case 2 -> ex2changeCasing();;
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
                case 13 -> ex13removeTowns();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    private void ex13removeTowns() throws IOException {
        System.out.println("Please enter town name: ");
        String townName = bufferedReader.readLine();

        Town town = entityManager
                .createQuery("SELECT t FROM Town t " +
                        "WHERE t.name = :t_name", Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();

        int affectedRows = removeAddressesByTownId(town.getId());

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.printf("%d address in %s deleted",affectedRows,town.getName());
    }

    private int removeAddressesByTownId(Integer id) {
        List<Address> addresses = entityManager.createQuery(
                "SELECT a FROM Address a" +
                        " WHERE a.town.id = :p_id", Address.class)
                .setParameter("p_id", id)
                .getResultList();

        entityManager.getTransaction().begin();
        addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();

        return addresses.size();
    }

    @SuppressWarnings("unchecked")
    private void ex12employeeMaxSalaries() {
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT d.name, MAX(e.salary) AS `m_salary`\n" +
                "FROM departments AS d\n" +
                "JOIN employees e on d.department_id = e.department_id\n" +
                "GROUP BY d.name\n" +
                "HAVING `m_salary` NOT BETWEEN 30000 AND 70000;")
                .getResultList();

        resultList.forEach(obj -> {
            System.out.println(obj[0] + " " + obj[1]);
        });

    }

    private void ex11findEmployeesByFirstName() throws IOException {
        System.out.println("Please enter required pattern: ");
        String input = bufferedReader.readLine();
        String pattern = input + "%";
        System.out.println(pattern);

        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.firstName" +
                " LIKE :patt", Employee.class)
                .setParameter("patt", pattern)
                .getResultStream()
                .forEach(e -> {
                    System.out.printf("%s %s - %s - ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary());
                });
    }

    private void ex10updateSalary() {
        entityManager.getTransaction().begin();
        int affectedRows =
                entityManager
                        .createQuery("UPDATE Employee e " +
                                "SET e.salary = e.salary* 1.2 " +
                                "WHERE e.department.id " +
                                "IN :ids")
                        .setParameter("ids", Set.of(1, 2, 4, 11)).executeUpdate();

        System.out.println(affectedRows);

        entityManager.getTransaction().commit();
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
        System.out.println("Please enter your employee id: ");
        int id = Integer.parseInt(bufferedReader.readLine());

        Set<Project> projects = entityManager.find(Employee.class, id).getProjects();

        StringBuilder sb = new StringBuilder();

        projects.forEach(project -> {
            sb.append(project.getName()).append("\n");
        });

        Employee employee = entityManager.find(Employee.class, id);

        System.out.printf("%s %s - %s\n %s",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle(),
                sb.toString());

    }

    private void ex7addressesEmployeeCount() {
        List<Address> addresses = entityManager
                .createQuery(
                        "SELECT a FROM Address a " +
                                "ORDER BY a.employees.size DESC "
                        , Address.class)
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
        System.out.println("Please enter last name: ");
        String lastName = bufferedReader.readLine();

        Employee employee = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName = :ln", Employee.class)
                .setParameter("ln", lastName)
                .getSingleResult();

        Address address = createAddress("Vitoshka 15");

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);

        entityManager.getTransaction().commit();
        return address;
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
        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.salary > :min_salary", Employee.class)
                .setParameter("min_salary", BigDecimal.valueOf(50000L))
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private void ex3containsEmployee() throws IOException {
        System.out.println("Please enter employee full name: ");
        String[] fullName = bufferedReader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long singleResult = entityManager.createQuery("SELECT count(e) FROM Employee e " +
                "WHERE e.firstName = :fn " +
                "AND e.lastName = :ln", Long.class)
                .setParameter("fn", firstName)
                .setParameter("ln", lastName)
                .getSingleResult();

        System.out.println(singleResult == 0 ? "No" : "Yes");
    }

    private void ex2changeCasing() {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("UPDATE Town t SET t.name = upper(t.name) " +
                "WHERE length(t.name) <= 5");

        System.out.println(query.executeUpdate());

        entityManager.getTransaction().commit();
    }
}

