package by.softClub.CoffeeShop.model.product;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coffee")
public class Coffee extends Product {
    @Column(name = "type_of_coffee")
    @Enumerated(EnumType.STRING)
    private TypeOfCoffe typeOfCoffe;
    @Column(name = "weight")
    private int weightInGram;

    public Coffee() {
    }

    public Coffee(String name, Manufacturer manufacturer, String description, Integer price, TypeOfCoffe typeOfCoffe, int weightInGram) {
        super(name, manufacturer, description, price);
        this.typeOfCoffe = typeOfCoffe;
        this.weightInGram = weightInGram;
    }

    public TypeOfCoffe getTypeOfCoffe() {
        return typeOfCoffe;
    }

    public void setTypeOfCoffe(TypeOfCoffe typeOfCoffe) {
        this.typeOfCoffe = typeOfCoffe;
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
                typeOfCoffe == coffee.typeOfCoffe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfCoffe, weightInGram);
    }

}
