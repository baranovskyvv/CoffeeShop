package by.softClub.CoffeeShop.service;

import by.softClub.CoffeeShop.model.Delivery;
import by.softClub.CoffeeShop.model.Order;
import by.softClub.CoffeeShop.model.product.Coffee;
import by.softClub.CoffeeShop.repo.OrderRepo;
import by.softClub.CoffeeShop.repo.CoffeeRepo;

import java.util.List;


public class OrderService {
    private OrderRepo orderRepo = new OrderRepo();
    private CoffeeRepo coffeeRepo = new CoffeeRepo();

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public void remove(long id) {
        orderRepo.delete(id);
    }

    public Long getCount() {
        return orderRepo.getCount();
    }

    public List<String> getAllNames() {
        return coffeeRepo.getAllNames();
    }

    public void createOrder(Delivery delivery, String phone, Coffee coffee, int weightInGram) {
        orderRepo.save(new Order(delivery, phone, coffee, weightInGram));
    }

    public Order getOrder(long id) {
        return orderRepo.findById(id);
    }

    public Coffee findCoffee(String name) {
        return coffeeRepo.findByName(name);
    }

    public void update(Order orderHelper) {
        orderRepo.update(orderHelper);
    }

    public Double getCost(String name) {
        return coffeeRepo.findByName(name).getPrice();
    }
}
