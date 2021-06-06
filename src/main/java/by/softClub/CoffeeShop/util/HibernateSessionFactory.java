package by.softClub.CoffeeShop.util;


import by.softClub.CoffeeShop.model.Delivery;
import by.softClub.CoffeeShop.model.Order;
import by.softClub.CoffeeShop.model.product.Coffee;
import by.softClub.CoffeeShop.model.product.Product;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(Coffee.class);
                configuration.addAnnotatedClass(Delivery.class);
                configuration.addAnnotatedClass(Order.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
