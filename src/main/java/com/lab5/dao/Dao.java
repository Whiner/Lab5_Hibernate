package com.lab5.dao;

import com.lab5.entities.EntityInDb;
import com.lab5.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dao implements AutoCloseable {

    public EntityInDb findById(Integer id, Class<?> tClass) throws IllegalAccessException, InstantiationException {
        return (EntityInDb) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(tClass.newInstance().getClass(), id); //создать новый инстанс для дженерика
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

    @Override
    public void close() throws IOException {
        HibernateSessionFactoryUtil.getSessionFactory().close();

    }
}

