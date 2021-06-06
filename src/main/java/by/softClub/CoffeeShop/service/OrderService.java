package by.softClub.CoffeeShop.service;

import by.softClub.CoffeeShop.model.Delivery;
import by.softClub.CoffeeShop.model.Order;
import by.softClub.CoffeeShop.model.product.Coffee;
import by.softClub.CoffeeShop.repo.OrderRepo;
import by.softClub.CoffeeShop.repo.garbage.CoffeeRepo;

import java.util.LinkedHashMap;
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

    public LinkedHashMap<Long, String> getOrdersMap() {
        List<Order> list = getAllOrders();
        LinkedHashMap<Long, String> map = new LinkedHashMap<>();
        for (Order order : list) {
            map.put(order.getId(), order.toString());
        }
        return map;
    }

    public Order getOrder(long id) {
        return orderRepo.findById(id);
    }

    public Coffee findCoffee(String name) {
        return coffeeRepo.findByName(name);
    }
}
