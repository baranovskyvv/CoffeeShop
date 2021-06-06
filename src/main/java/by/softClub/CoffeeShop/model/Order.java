package by.softClub.CoffeeShop.model;

import by.softClub.CoffeeShop.model.product.Coffee;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id", referencedColumnName = "id")
    private Delivery delivery;
    @Column(name = "phone")
    private String phone;
    @ManyToOne()
    @JoinColumn(name = "coffee_id", referencedColumnName = "id")
    private Coffee coffee;
    @Column(name = "weight")
    private int weightInGram;
    @Column(name = "cost")
    private double cost;

    private Double calculateCost() {
        Double cost = weightInGram * coffee.getPrice() / 1000;
        DecimalFormat df = new DecimalFormat("#.##");
        String format = df.format(cost);
        try {
            cost = df.parse(format).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (delivery == null) {
            return cost;
        } else return cost + 3;
    }

    public Order() {
    }

    public Order(Delivery delivery, String phone, Coffee coffee, int weightInGram) {
        this.delivery = delivery;
        this.phone = phone;
        this.coffee = coffee;
        this.weightInGram = weightInGram;
        this.cost = calculateCost();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public int getWeightInGram() {
        return weightInGram;
    }

    public void setWeightInGram(int weightInGram) {
        this.weightInGram = weightInGram;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        if (delivery == null) {
            return weightInGram + "гр. " + coffee.getName() +
                    " (" + coffee.getTypeOfCoffee() + ") - " + cost;
        } else
            return weightInGram + "гр. " + coffee.getName() +
                    " (" + coffee.getTypeOfCoffee() + ") " +
                    delivery.toString() + " - " + cost;
    }
}

