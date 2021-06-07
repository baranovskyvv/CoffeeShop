package by.softClub.CoffeeShop.repo;

import by.softClub.CoffeeShop.model.Delivery;
import by.softClub.CoffeeShop.model.Order;
import by.softClub.CoffeeShop.model.product.Coffee;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


class OrderRepoTest {
    CrudRepository orderRepo = new OrderRepo();
    CoffeeRepo coffeeRepo = new CoffeeRepo();


    @Test
    void save() {
        Coffee coffee= coffeeRepo.findById(1);
        Order order = new Order(new Delivery("Pushkina 7-4", LocalDateTime.now(),
                LocalDateTime.now().plusDays(1)),"+375669516532",coffee,250);
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


    }

    @Test
    void findAll() {
    }

}