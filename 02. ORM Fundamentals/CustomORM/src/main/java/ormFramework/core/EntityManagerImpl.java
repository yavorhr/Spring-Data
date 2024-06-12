package ormFramework.core;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public class EntityManagerImpl implements  EntityManager {
  private final Connection connection;

  public EntityManagerImpl(Connection connection) {
    this.connection = connection;
  }


  @Override
  public <T> T findById(int id, Class<T> type) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    return null;
  }
}
