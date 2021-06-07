package by.softClub.CoffeeShop.model.product;

import javax.persistence.*;


@Entity
@Table(name = "coffee")
public class Coffee extends Product {
    @Column(name = "type_of_coffee")
    @Enumerated(EnumType.STRING)
    private TypeOfCoffee typeOfCoffee;

    public Coffee() {
    }

    public Coffee(String name, Manufacturer manufacturer, String description, Double price, TypeOfCoffee typeOfCoffee) {
        super(name, manufacturer, description, price);
        this.typeOfCoffee = typeOfCoffee;
    }

    public TypeOfCoffee getTypeOfCoffee() {
        return typeOfCoffee;
    }

    public void setTypeOfCoffee(TypeOfCoffee typeOfCoffee) {
        this.typeOfCoffee = typeOfCoffee;
    }
}
