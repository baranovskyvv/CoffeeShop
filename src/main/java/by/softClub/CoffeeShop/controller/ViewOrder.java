package by.softClub.CoffeeShop.controller;

import by.softClub.CoffeeShop.model.Delivery;
import by.softClub.CoffeeShop.model.Order;
import by.softClub.CoffeeShop.service.OrderService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.time.LocalDateTime;
import java.util.List;


@SessionScoped
@ManagedBean(name = "controllerOrder")
public class ViewOrder {
    private OrderService orderService = new OrderService();
    private Order orderHelper;
    private String nameCoffee;
    private Integer weight;
    private String phone;
    private boolean deliveryFlag = false;
    private String address;

    public List<String> getAllName() {
        return orderService.getAllNames();
    }

    public String updateOrder() {
        orderHelper.getDelivery().setTimeFrom(LocalDateTime.of(ViewDateTime.date, ViewDateTime.timeFrom));
        orderHelper.getDelivery().setTimeTo(LocalDateTime.of(ViewDateTime.date, ViewDateTime.timeTo));
        orderService.update(orderHelper);

        return "/orderList.xhtml?faces-redirect=true";
    }

    public String createOrder() {
        if (deliveryFlag) {
            Delivery delivery = new Delivery(address, LocalDateTime.of(ViewDateTime.date, ViewDateTime.timeFrom),
                    LocalDateTime.of(ViewDateTime.date, ViewDateTime.timeTo));
            orderService.createOrder(delivery, phone, orderService.findCoffee(nameCoffee), weight);
        } else {
            orderService.createOrder(null, phone, orderService.findCoffee(nameCoffee), weight);
        }
        showMessage();
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "/home.xhtml?faces-redirect=true";
    }

    public Long countOfOrders() {
        return orderService.getCount();
    }

    public List<Order> createOrderList() {
        return orderService.getAllOrders();
    }

    public String goToDeletePage(long id) {
        orderHelper = orderService.getOrder(id);
        return "/delete.xhtml?faces-redirect=true";
    }

    public String goToUpdate(long id) {
        orderHelper = orderService.getOrder(id);
        ViewDateTime.date = orderHelper.getDelivery().getTimeFrom().toLocalDate();
        ViewDateTime.timeFrom = orderHelper.getDelivery().getTimeFrom().toLocalTime();
        ViewDateTime.timeTo = orderHelper.getDelivery().getTimeTo().toLocalTime();
        return "/update.xhtml?faces-redirect=true";
    }

    public String delete(long id) {
        orderService.remove(id);
        return "/orderList.xhtml?faces-redirect=true";
    }

    public void deliveryFlag() {
        deliveryFlag = true;
    }

    public void findCoffee(String name) {
        orderHelper.setCoffee(orderService.findCoffee(name));
    }

    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Сообщение", " Заказ успешно добавлен!");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public Order getOrderHelper() {
        return orderHelper;
    }

    public void setOrderHelper(Order orderHelper) {
        this.orderHelper = orderHelper;
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
