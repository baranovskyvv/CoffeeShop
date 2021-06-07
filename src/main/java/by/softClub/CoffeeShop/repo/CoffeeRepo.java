package by.softClub.CoffeeShop.repo;

import by.softClub.CoffeeShop.model.product.Coffee;
import by.softClub.CoffeeShop.util.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CoffeeRepo implements CrudRepository<Coffee> {
    public void save(Coffee coffee) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(coffee);
        transaction.commit();
        session.close();
    }

    public void update(Coffee coffee) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(coffee);
        transaction.commit();
        session.close();
    }

    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Coffee coffee = session.load(Coffee.class, id);
        session.delete(coffee);
        transaction.commit();
        session.close();
    }

    public Coffee findById(long id) {
        return  HibernateSessionFactory.getSessionFactory().openSession().get(Coffee.class, id);
    }

    public List<Coffee> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("From Coffee");
        return query.list();
    }

    public List<String> getAllNames() {
        Session session= HibernateSessionFactory.getSessionFactory().openSession();
        Query query= session.createQuery("select name from Coffee");
        return query.list();
    }

    public Coffee findByName(String name) {
        Session session= HibernateSessionFactory.getSessionFactory().openSession();
        Query query= session.createQuery("from Coffee where name=:paramName");
        query.setParameter("paramName",name);
        return (Coffee) query.uniqueResult();
    }


}
