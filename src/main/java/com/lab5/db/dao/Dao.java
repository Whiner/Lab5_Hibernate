package com.lab5.db.dao;

import com.lab5.db.entities.EntityInDb;
import com.lab5.db.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Dao {

    public EntityInDb findById(Integer id, Class<?> tClass) throws IllegalAccessException, InstantiationException {
        return (EntityInDb) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(tClass.newInstance().getClass(), id);
    }

    public void save(EntityInDb t) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(t);
        tx1.commit();
        session.close();
    }

    public void update(EntityInDb t) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(t);
        tx1.commit();
        session.close();
    }

    public void delete(EntityInDb t) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(t);
        tx1.commit();
        session.close();
    }

    public List<EntityInDb> findAll(Class<? extends EntityInDb> tClass) {
        List list = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From " + tClass.getSimpleName()).list();
        List<EntityInDb> entities = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof EntityInDb) {
                entities.add((EntityInDb) obj);
            }
        }
        return entities;

    }

    private Dao() {
    }

    private static Dao instance = new Dao();

    public static Dao getInstance() {
        return instance;
    }


    public void close() {
        HibernateSessionFactoryUtil.getSessionFactory().close();
    }
}

