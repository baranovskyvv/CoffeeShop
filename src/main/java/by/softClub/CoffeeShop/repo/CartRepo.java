package by.softClub.CoffeeShop.repo;

import by.softClub.CoffeeShop.model.Cart;
import by.softClub.CoffeeShop.util.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CartRepo implements CrudRepository<Cart> {
    @Override
    public void save(Cart cart) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cart);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Cart cart) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(cart);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Cart cart = (Cart) session.load(Cart.class, id);
        session.delete(cart);
        transaction.commit();
        session.close();
    }

    @Override
    public Cart findById(long id) {
        return (Cart) HibernateSessionFactory.getSessionFactory().openSession().get(Cart.class, id);
    }

    @Override
    public List<Cart> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("From Cart");
        return query.list();
    }
}
