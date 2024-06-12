package ormFramework.core;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EntityManager {

    <T> T findById(int id, Class<T> type) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;

    <T> boolean persist(T entity) throws IllegalAccessException, SQLException;
}
