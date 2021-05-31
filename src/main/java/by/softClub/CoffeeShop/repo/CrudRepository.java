package by.softClub.CoffeeShop.repo;

import java.util.List;

public interface CrudRepository<T> {
    void save(T t);

    void update(T t);

    void delete(long id);

    T findById(long id);

    List<T> findAll();

}
