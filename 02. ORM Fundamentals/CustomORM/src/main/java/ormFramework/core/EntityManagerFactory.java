package ormFramework.core;

import ormFramework.annotation.Entity;

import java.io.File;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    List<Class<?>> classes = getEntities(mainClass);

//        createTables(connection, classes);

    return new EntityManagerImpl(connection);
  }

  private static List<Class<?>> getEntities(Class<?> mainClass) throws URISyntaxException, ClassNotFoundException {
    String path = mainClass.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
    String packageName = mainClass.getPackageName();


    File rootDir = new File(path + packageName.replace(".", "/"));
    List<Class<?>> classes = new ArrayList<>();

    scanEntities(
            rootDir,
            packageName,
            classes
    );
    return classes;
  }

  private static void scanEntities(File dir, String packageName, List<Class<?>> classes) throws ClassNotFoundException {
    for (File file : dir.listFiles()) {
      if (file.isDirectory()) {
        scanEntities(file, packageName + "." + file.getName(), classes);
      } else if (file.getName().endsWith(".class")) {
        Class<?> classInfo = Class.forName(packageName + "." + file.getName().replace(".class", ""));
        if (classInfo.isAnnotationPresent(Entity.class)) {
          classes.add(classInfo);
        }
      }
    }
  }


  private static Connection createConnection(String dbType, String host, int port, String user, String pass, String dbName) throws SQLException {
    return DriverManager.getConnection(
            "jdbc:" + dbType + "://" + host + ":" + port + "/" + dbName,
            user,
            pass
    );
  }
}
