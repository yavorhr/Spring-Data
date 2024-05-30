import java.sql.*;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws SQLException {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruk_database",
            "root", "00000");

    PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE salary > ?");

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the salary you want to search for: ");
    double inputSalary = Double.parseDouble(scanner.nextLine());

    statement.setDouble(1, inputSalary);

    ResultSet resultSet = statement.executeQuery();

    while (resultSet.next()) {
      long id = resultSet.getLong(1);
      String firstName = resultSet.getString(2);
      double salary = resultSet.getDouble(4);
      System.out.println(id + "| " + firstName + " |" + salary);
    }
  }
}