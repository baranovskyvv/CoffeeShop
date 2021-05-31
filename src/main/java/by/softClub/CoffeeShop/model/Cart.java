package by.softClub.CoffeeShop.model;

import by.softClub.CoffeeShop.model.product.Coffee;
import by.softClub.CoffeeShop.model.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Coffee coffee;

    public Cart(Order order, Integer quantity, Coffee coffee) {
        this.order = order;
        this.quantity = quantity;
        this.coffee = coffee;
    }

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
}
