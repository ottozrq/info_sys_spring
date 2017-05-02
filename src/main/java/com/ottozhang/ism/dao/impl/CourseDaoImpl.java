package com.ottozhang.ism.dao.impl;

import com.ottozhang.ism.dao.IdentityDao;
import com.ottozhang.ism.dataModel.Course;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.test.context.ContextConfiguration;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangruoqiu on 2017/5/1.
 */
@ContextConfiguration("file:/resources/appContext.xml")
public class CourseDaoImpl implements IdentityDao<Course> {
    @Inject
    SessionFactory sf;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }

    public void add(Course identity) {
    }

    public void update(Course identity) {
    }

    public void delete(Course identity) {
    }

    public List<Course> show() {
        Session session = sf.openSession();
        String queryString = "from Course";
        Query query = session.createQuery(queryString);
        List<Course> courseList = query.list();
        session.close();
        return courseList;
    }

    public List<Course> get(Course identity) {
        Session session = sf.openSession();
        String queryString = "from Course " +
                "where title = :title and groups = :groups " +
                "order by datet";
        Query query = session.createQuery(queryString);
        query.setParameter("title", identity.getTitle());
        query.setParameter("groups", identity.getGroyps());
        List<Course> courseList = query.list();
        session.close();
        return courseList;
    }

    public List<Course> getList(){
        Session session = sf.openSession();
        String queryString = "from Course " +
                "group by title, groups " +
                "order by title";
        Query query = session.createQuery(queryString);
        List<Course> courseList = query.list();
        session.close();
        return courseList;
    }

    public List<Course> getMyList(String courses){
        JSONArray js = new JSONArray(courses);
        Session session = sf.openSession();
        String queryString = "from Course " +
                "where title = :title and groups = :groups " +
                "group by title " +
                "order by title";
        List<Course> courseList = null;
        for (int i = 0; i < js.length(); i++){
            JSONObject jso = js.getJSONObject(i);
            String title = jso.keys().next();
            String groups = jso.getString(title);
            Query query = session.createQuery(queryString);
            query.setParameter("title",title.replace("'", "\""));
            query.setParameter("groups",groups);
            if (courseList == null)
                courseList = new ArrayList<Course>(query.list());
            else
                courseList.addAll(query.list());
        }
        session.close();
        return courseList;
    }
}
