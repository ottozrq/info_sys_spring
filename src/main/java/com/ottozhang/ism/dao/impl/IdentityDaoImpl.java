package com.ottozhang.ism.dao.impl;

import com.ottozhang.ism.dao.IdentityDao;
import com.ottozhang.ism.dataModel.Identity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by zhangruoqiu on 2017/4/21.
 */
public class IdentityDaoImpl implements IdentityDao<Identity> {

    @Inject
    SessionFactory sf;

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
}
