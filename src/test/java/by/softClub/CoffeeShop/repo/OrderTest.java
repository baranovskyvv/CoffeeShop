package by.softClub.CoffeeShop.repo;

import by.softClub.CoffeeShop.model.Delivery;
import by.softClub.CoffeeShop.model.Order;
import by.softClub.CoffeeShop.model.product.Coffee;
import by.softClub.CoffeeShop.model.product.Manufacturer;
import by.softClub.CoffeeShop.model.product.TypeOfCoffee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class OrderTest {
    @Test
    public void getStringFromOrderWithoutDelivery() {
        Coffee coffee = new Coffee("lavazzza", Manufacturer.MEXICO, "blabla", 200.0, TypeOfCoffee.Arabica);
        Order order = new Order(null,"+375669516532",coffee,250);
        System.out.println(order);
    }
    @Test
    public void getStringFromOrderWithoutDeliveryZero() {
        Coffee coffee = new Coffee("lavazzza", Manufacturer.MEXICO, "blabla", 13.0, TypeOfCoffee.Arabica);
        Order order = new Order(null, "+375669516532", coffee, 136);
        Assert.assertEquals(order.toString(),"136гр. lavazzza (Arabica) - 1.77");
    }
      @Test
    public void getStringFromOrderWithDelivery() {
          Delivery delivery= new Delivery("asdasd", LocalDateTime.of(2021,6,3,15,37)
                  ,LocalDateTime.of(2021,6,3,16,37));
        Coffee coffee = new Coffee("lavazzza", Manufacturer.MEXICO, "blabla", 13.0, TypeOfCoffee.Arabica);
        Order order = new Order(delivery, "+375669516532", coffee, 136);
          Assert.assertEquals(order.toString(),"136гр. lavazzza (Arabica) 15.37 по 16.37 3.6.2021 - 4.77");
    }


}
