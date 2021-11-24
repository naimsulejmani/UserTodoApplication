package ict.kosovo.growth.usertodoapplication.repository;

import java.util.List;

public interface CrudRepository<T,Tid> {
    boolean add(T item);

    boolean update(T item);
    boolean delete(T item);
    boolean deleteById(Tid key);

    T getById(Tid key);

    List<T> getAll();
}
