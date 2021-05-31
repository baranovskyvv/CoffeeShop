package by.softClub.CoffeeShop.repo;

import by.softClub.CoffeeShop.model.product.Coffee;
import by.softClub.CoffeeShop.model.product.Manufacturer;
import by.softClub.CoffeeShop.model.product.TypeOfCoffe;
import org.junit.jupiter.api.Test;

import java.util.List;

class CoffeeRepoTest {
    @Test
    public void create() {
        CoffeeRepo coffeeRepo = new CoffeeRepo();
        coffeeRepo.save(new Coffee("lavezza", Manufacturer.MEXICO, "descr", 123, TypeOfCoffe.Arabica, 150));
    }

    @Test
    public void delete() {
        // public Coffee(String name, Manufacturer manufacturer, String description, Integer price, TypeOfCoffe typeOfCoffe, int weightInGram)
        CoffeeRepo coffeeRepo = new CoffeeRepo();
        coffeeRepo.delete(2);
    }

    @Test
    public void update() {
        CoffeeRepo coffeeRepo = new CoffeeRepo();
        Coffee coffee = new Coffee("lavazzzza", Manufacturer.MEXICO, "descr", 123, TypeOfCoffe.Arabica, 150);
        coffee.setId(1L);
        coffeeRepo.update(coffee);
    }

    @Test
    public void find() {
        CoffeeRepo coffeeRepo = new CoffeeRepo();
        System.out.println(coffeeRepo.findById(1).getName());

    }

    @Test
    public void findAll() {
        CoffeeRepo coffeeRepo = new CoffeeRepo();
        List<Coffee> list = coffeeRepo.findAll();
        System.out.println(list);
    }
}