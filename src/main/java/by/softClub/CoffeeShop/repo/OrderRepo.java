package by.softClub.CoffeeShop.repo;

import by.softClub.CoffeeShop.model.Order;
import by.softClub.CoffeeShop.util.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderRepo implements CrudRepository<Order> {
    @Override
    public void save(Order order) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Order order) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(order);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Order order = (Order) session.load(Order.class, id);
        session.delete(order);
        transaction.commit();
        session.close();
    }

    @Override
    public Order findById(long id) {
        return (Order) HibernateSessionFactory.getSessionFactory().openSession().get(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("From Order");
        return query.list();
    }
}
