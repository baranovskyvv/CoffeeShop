package by.softClub.CoffeeShop.controller;

import by.softClub.CoffeeShop.model.product.Coffee;
import by.softClub.CoffeeShop.model.product.Manufacturer;
import by.softClub.CoffeeShop.model.product.TypeOfCoffee;
import by.softClub.CoffeeShop.repo.CoffeeRepo;

import javax.faces.bean.ManagedBean;



public class CoffeeController {
    private String name;
    private Manufacturer manufacturer;
    private String description;
    private Integer price;
    private TypeOfCoffee typeOfCoffee;
    private int weightInGram;

    public String createCoffee() {
        CoffeeRepo coffeeRepo = new CoffeeRepo();
        coffeeRepo.save(new Coffee(name, manufacturer, description, price, typeOfCoffee, weightInGram));
        return "index.html";
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

}
