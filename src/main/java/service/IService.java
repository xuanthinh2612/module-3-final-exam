package service;

import java.util.List;

public interface IService <T> {

    List<T> findAll();

    boolean create(T r);

    T findById(int id);

    List<T> findByName(String name);

    boolean update(T t);

    boolean delete(int id);

}
