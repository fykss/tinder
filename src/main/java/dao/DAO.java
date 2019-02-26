package dao;

import java.util.Collection;

public interface DAO<T> {
    T get(int id);
    Collection<T> getAll();
//    boolean check(T value);
    int getId(T value);
    void put(T item);
}
