package com.ottozhang.ism.dao.impl;

import com.ottozhang.ism.dao.IdentityDao;
import com.ottozhang.ism.dataModel.Identity;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by zhangruoqiu on 2017/4/21.
 */
@ContextConfiguration("file:/resources/appContext.xml")
public class IdentityDaoImpl implements IdentityDao<Identity> {
    @Inject
    SessionFactory sf;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }

    public void add(Identity identity) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(identity);
        transaction.commit();
        session.close();
    }

    public void update(Identity identity) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(identity);
        transaction.commit();
        session.close();
    }

    public void delete(Identity identity) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(identity);
        transaction.commit();
        session.close();
    }

    public List<Identity> show() {
        Session session = sf.openSession();
        String queryString = "from Identity";
        Query query = session.createQuery(queryString);
        List<Identity> identityList = query.list();
        session.close();
        return identityList;
    }

    public List<Identity> get(Identity identity) {
        Session session = sf.openSession();
        String queryString = "from Identity where email = :email";
        Query query = session.createQuery(queryString);
        query.setParameter("email", identity.getEmail());
        List<Identity> identityList = query.list();
        session.close();
        return identityList;
    }

    public List<Identity> check(Identity identity){
        Session session = sf.openSession();
        String queryString = "from Identity where email = :email and password = :password";
        Query query = session.createQuery(queryString);
        query.setParameter("email", identity.getEmail());
        query.setParameter("password", identity.getPassword());
        List<Identity> identityList = query.list();
        session.close();
        return identityList;
    }


}
