package by.softClub.CoffeeShop.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    void getOrdersMap() {
        OrderService orderService = new OrderService();
        System.out.println(orderService.getOrdersMap());
    }
}