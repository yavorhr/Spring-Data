import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Main {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "minions_db";
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Connection connection;

    public static void main(String[] args) throws SQLException, IOException {
        connection = getConnection();

        int numberExcercise = Integer.parseInt(reader.readLine());

        switch (numberExcercise) {
            case 2 -> ex2getVillainsNames();
            case 3 -> ex3getMinionNames();
//            case 4 -> addMinion();
            case 5 -> ex5changeTownNameCasing();
            case 6 -> ex6removeVillain();
            case 7 -> ex7printAllNames();
            case 8 -> ex8increaseAge();
            case 9 -> ex9storedProcedure();
        }

        connection.close();
    }

    private static void ex8increaseAge() throws IOException, SQLException {
        System.out.println("Please enter minion ids: ");
        String minionIDs = reader.readLine();
        String[] tokens = minionIDs.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            int id = Integer.parseInt(tokens[i]);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE minions\n" +
                            "SET age = age+1 , name = lower(name)\n" +
                            "WHERE  id = ?");

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
        getAllMinions();
    }

    private static void getAllMinions() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id,name,age FROM  minions");

        while(resultSet.next()){
            System.out.printf("%s %s %s %n",
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("age"));
        }
    }


    private static void ex9storedProcedure() throws IOException, SQLException {
        System.out.println("Enter minion id :");
        int minionId = Integer.parseInt(reader.readLine());

        CallableStatement callableStatement = connection
                .prepareCall("CALL usp_get_oder(?)");
        callableStatement.setInt(1, minionId);

        int affected = callableStatement.executeUpdate();
        System.out.println(affected);
    }

//    private static void addMinion() throws IOException {
//        System.out.println("Please enter a minion name: ");
//        String minion = reader.readLine();
//        System.out.println("Please enter a Villain name: ");
//        String villain = reader.readLine();
//
//
//    }

    private static void ex7printAllNames() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM minions");
        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> minionNames = new ArrayList<>();
        while (resultSet.next()) {
            minionNames.add(resultSet.getString("name"));
        }

        int start = 0;
        int end = minionNames.size() - 1;

        for (int i = 0; i < minionNames.size(); i++) {
            System.out.println(i % 2 == 0
                    ? minionNames.get(start++)
                    : minionNames.get((end--)));
        }

    }

    private static void ex6removeVillain() throws IOException, SQLException {
        System.out.println("Enter villain id: ");
        int id = Integer.parseInt(reader.readLine());

        String villainName = findEntityNameById("villains", id);
        System.out.printf("%s was deleted%n", villainName);
        int count = getMinionsByVillainId(id);
        System.out.printf("%d minions released", count);

        deleteVillain(id);
    }

    private static void deleteVillain(int id) throws SQLException {
        String query = "DELETE FROM villains " +
                " WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
    }

    private static int getMinionsByVillainId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT count(*) FROM minions " +
                        "join minions_villains mv on minions.id = mv.minion_id " +
                        "WHERE villain_id =? " +
                        "GROUP BY  villain_id;");

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    private static void ex5changeTownNameCasing() throws IOException, SQLException {
        System.out.println("Enter country name: ");
        String countryName = reader.readLine();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE towns " +
                "SET name = UPPER(name) " +
                "WHERE country = ?");

        preparedStatement.setString(1, countryName);
        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0) {
            System.out.println("No town names");
        } else {
            System.out.printf("%d town names were affected.%n", affectedRows);
            PreparedStatement preparedStatementTowns = connection.prepareStatement("SELECT name FROM towns " +
                    " WHERE country =?");

            preparedStatementTowns.setString(1, countryName);
            ResultSet resultSet = preparedStatementTowns.executeQuery();

            List<String> resultList = new ArrayList<>();

            while (resultSet.next()) {
                resultList.add(resultSet.getString("name"));
            }

            String resultString = String.join(", ", resultList);
            System.out.println(resultString);
        }
    }

    private static void ex3getMinionNames() throws IOException, SQLException {
        System.out.println("Enter villain id: ");

        int villainId = Integer.parseInt(reader.readLine());
        String name = findEntityNameById("villains", villainId);
        System.out.println("Villain: " + name);

        printMinionsByGivenId(villainId);
    }

    private static void printMinionsByGivenId(int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, age from minions " +
                "join minions_villains as mv " +
                "    on minions.id = mv.minion_id " +
                "where mv.villain_id = ?");
        preparedStatement.setInt(1, villainId);

        ResultSet resultSet = preparedStatement.executeQuery();
        int counter = 0;

        while (resultSet.next()) {
            System.out.printf("%d. %s %d %n", ++counter, resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    private static String findEntityNameById(String tableName, int villainId) throws SQLException {
        String query = String.format("SELECT `name` from %s WHERE id = ?", tableName);
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, villainId);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getString("name");
    }

    private static void ex2getVillainsNames() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT v.name AS `Villian_name`, count(DISTINCT minion_id) AS `minion_count` " +
                        "From villains AS v " +
                        "JOIN minions_villains mv " +
                        "    ON v.id = mv.villain_id " +
                        "GROUP BY v.name " +
                        "HAVING `minion_count` > ?; ");

        preparedStatement.setInt(1, 15);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d %n", resultSet.getString(1), resultSet.getInt(2));
        }
    }

    private static Connection getConnection() throws IOException, SQLException {
        //TODO : Please enter your credentials :

//        System.out.println("Enter user: ");
//        String user = reader.readLine();
//        System.out.println("Enter password: ");
//        String password = reader.readLine();

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "showMeTheCode2020");

        return DriverManager.getConnection(CONNECTION_STRING + DATABASE_NAME, properties);

    }
}