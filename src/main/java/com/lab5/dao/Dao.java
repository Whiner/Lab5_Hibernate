package com.lab5.dao;

import com.lab5.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class Dao<T, Id extends Serializable> {

    private Class<T> tClass;

    public T findById(Id id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(tClass, id);
    }

    public void save(T t) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(t);
        tx1.commit();
        session.close();
    }

    public void update(T t) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(t);
        tx1.commit();
        session.close();
    }

    public void delete(T t) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(t);
        tx1.commit();
        session.close();
    }

    public List findAll() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From " + tClass.getName()).list();
    }
}
