package by.softClub.CoffeeShop.repo;

import by.softClub.CoffeeShop.model.Delivery;
import by.softClub.CoffeeShop.util.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeliveryRepo implements CrudRepository<Delivery> {
    @Override
    public void save(Delivery delivery) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(delivery);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Delivery delivery) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(delivery);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Delivery user = (Delivery) session.load(Delivery.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public Delivery findById(long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Delivery.class, id);
    }

    @Override
    public List<Delivery> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("From Delivery");
        return query.list();
    }
}
