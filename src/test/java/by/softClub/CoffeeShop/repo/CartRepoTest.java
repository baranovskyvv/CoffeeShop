package by.softClub.CoffeeShop.repo;

import by.softClub.CoffeeShop.model.Cart;
import by.softClub.CoffeeShop.model.Order;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CartRepoTest {

    @Test
    void save() {
        OrderRepo orderRepo = new OrderRepo();
        CartRepo cartRepo = new CartRepo();
        CoffeeRepo coffeeRepo = new CoffeeRepo();
        Order order = orderRepo.findById(1);
        Cart one = new Cart(order, 3, coffeeRepo.findById(3));
        Cart two = new Cart(order, 2, coffeeRepo.findById(1));
        cartRepo.save(one);
        cartRepo.save(two);

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