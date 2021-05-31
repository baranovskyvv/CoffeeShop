package by.softClub.CoffeeShop.repo;

import by.softClub.CoffeeShop.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepoTest {

    @Test
    void save() {
       User user= new User("+3755520596156", "Vlad", null);
       CrudRepository userRepo = new UserRepo();
       userRepo.save(user);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }
}