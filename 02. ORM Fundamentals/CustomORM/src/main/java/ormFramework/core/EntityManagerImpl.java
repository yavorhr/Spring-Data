package ormFramework.core;

import java.sql.Connection;

public class EntityManagerImpl implements  EntityManager {
  private final Connection connection;

  public EntityManagerImpl(Connection connection) {
    this.connection = connection;
  }


}
