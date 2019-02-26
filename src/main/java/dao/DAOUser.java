package dao;

import java.util.Collection;

public interface DAOUser <T> {
    T get(int id);
    Collection<T> getAll();
    boolean check(T value);
    int getId(T value);
}
