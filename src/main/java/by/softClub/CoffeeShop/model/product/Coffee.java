package by.softClub.CoffeeShop.model.product;

import by.softClub.CoffeeShop.repo.CoffeeRepo;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.util.Objects;

@ManagedBean(name = "coffee")
@Entity
@Table(name = "coffee")
public class Coffee extends Product {
    @Column(name = "type_of_coffee")
    @Enumerated(EnumType.STRING)
    private TypeOfCoffee typeOfCoffee;
    @Column(name = "weight")
    private int weightInGram;

    public Coffee() {
    }

    public Coffee(String name, Manufacturer manufacturer, String description, Integer price, TypeOfCoffee typeOfCoffee, int weightInGram) {
        super(name, manufacturer, description, price);
        this.typeOfCoffee = typeOfCoffee;
        this.weightInGram = weightInGram;
    }

    public String createCoffee() {
        CoffeeRepo coffeeRepo = new CoffeeRepo();
        coffeeRepo.save(new Coffee(this.getName(), this.getManufacturer(), getDescription(),getPrice(), typeOfCoffee, weightInGram));
        return "index.html";
    }

    public TypeOfCoffee getTypeOfCoffee() {
        return typeOfCoffee;
    }

    public void setTypeOfCoffee(TypeOfCoffee typeOfCoffee) {
        this.typeOfCoffee = typeOfCoffee;
    }

    public int getWeightInGram() {
        return weightInGram;
    }

    public void setWeightInGram(int weightInGram) {
        this.weightInGram = weightInGram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee)) return false;
        if (!super.equals(o)) return false;
        Coffee coffee = (Coffee) o;
        return weightInGram == coffee.weightInGram &&
                typeOfCoffee == coffee.typeOfCoffee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfCoffee, weightInGram);
    }

}
