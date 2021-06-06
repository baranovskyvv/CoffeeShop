package by.softClub.CoffeeShop.controller;


import by.softClub.CoffeeShop.model.Delivery;
import by.softClub.CoffeeShop.model.Order;
import by.softClub.CoffeeShop.service.OrderService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.List;


@SessionScoped
@ManagedBean(name = "controllerOrder")
public class ViewOrder {

    private OrderService orderService = new OrderService();
    private Order orderDeleteHelper;
    private String nameCoffee;
    private Integer weight;
    private String phone;
    private boolean deliveryFlag = false;
    private String address;


    public List<String> getAllName() {
        return orderService.getAllNames();
    }

    public String createOrder() {
        if (deliveryFlag) {
            Delivery delivery = new Delivery(address, LocalDateTime.of(ViewDateTime.date, ViewDateTime.timeFrom),
                    LocalDateTime.of(ViewDateTime.date, ViewDateTime.timeTo));
            orderService.createOrder(delivery, phone, orderService.findCoffee(nameCoffee), weight);
        } else
            orderService.createOrder(null, phone, orderService.findCoffee(nameCoffee), weight);
        return "/orderList.xhtml?faces-redirect=true";
    }

    public Long countOfOrders() {
        return orderService.getCount();
    }

    public List<Order> createOrderList() {
        return orderService.getAllOrders();
    }

    public String goToDeletePage(long id) {
        orderDeleteHelper = orderService.getOrder(id);
        return "/delete.xhtml?faces-redirect=true";
    }

    public String delete(long id) {
        orderService.remove(id);
        return "/orderList.xhtml?faces-redirect=true";
    }

    public void deliveryFlag() {
        deliveryFlag = true;
    }

    public void findCoffee(String name) {
        orderDeleteHelper.setCoffee(orderService.findCoffee(name));
    }

    public Order getOrderDeleteHelper() {
        return orderDeleteHelper;
    }

    public void setOrderDeleteHelper(Order orderDeleteHelper) {
        this.orderDeleteHelper = orderDeleteHelper;
    }

    public String getNameCoffee() {
        return nameCoffee;
    }

    public void setNameCoffee(String nameCoffee) {
        this.nameCoffee = nameCoffee;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isDeliveryFlag() {
        return deliveryFlag;
    }

    public void setDeliveryFlag(boolean deliveryFlag) {
        this.deliveryFlag = deliveryFlag;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
