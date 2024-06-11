package ormFramework.core;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EntityManagerFactory {

  public static EntityManager create(
          String dbType,
          String host,
          int port,
          String user,
          String pass,
          String dbName,
          Class<?> mainClass
  ) throws SQLException, URISyntaxException, ClassNotFoundException {
    Connection connection = createConnection(dbType, host, port, user, pass, dbName);

//    List<Class<?>> classes = getEntities(mainClass);

//        createTables(connection, classes);

    return new EntityManagerImpl(connection);
  }

  private static Connection createConnection(String dbType, String host, int port, String user, String pass, String dbName) throws SQLException {
    return DriverManager.getConnection(
            "jdbc:" + dbType + "://" + host + ":" + port + "/" + dbName,
            user,
            pass
    );
  }
}
