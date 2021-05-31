package by.softClub.CoffeeShop.model.product;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "manufacturer")
    @Enumerated(EnumType.STRING)
    private Manufacturer manufacturer;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;
    public Product() {
    }

    public Product(String name, Manufacturer manufacturer, String description, Integer price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                manufacturer == product.manufacturer &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer, description, price);
    }
}
