package by.softClub.CoffeeShop.repo;

import by.softClub.CoffeeShop.model.Order;
import by.softClub.CoffeeShop.model.StatusOrder;
import by.softClub.CoffeeShop.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {
    CrudRepository orderRepo = new OrderRepo();
    CrudRepository userRepo = new UserRepo();

    @Test
    void save() {
        Order order = new Order((User) userRepo.findById(1), null, StatusOrder.Active);
        orderRepo.save(order);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
        Order order = (Order) orderRepo.findById(1);
        System.out.println(order.getCart());
    }

    @Test
    void findAll() {
    }
}