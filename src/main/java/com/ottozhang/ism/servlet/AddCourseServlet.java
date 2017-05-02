package com.ottozhang.ism.servlet;

import com.ottozhang.ism.dao.impl.IdentityDaoImpl;
import com.ottozhang.ism.dataModel.Identity;
import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhangruoqiu on 2017/5/2.
 */
@WebServlet(name = "AddCourseServlet")

public class AddCourseServlet extends HttpServlet {
    BeanFactory bf = new ClassPathXmlApplicationContext("/appContext.xml");
    IdentityDaoImpl dao = bf.getBean("dao", IdentityDaoImpl.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        Identity identity = new Identity();
        String email = request.getSession().getAttribute("email").toString();
        identity.setEmail(email);
        List<Identity> users = dao.get(identity);
        Identity user = users.get(0);
        String course = request.getParameter("course");
        String groups = request.getParameter("groups");
        String jsstr = "{\"" + course + "\":\"" + groups + "\"}";
        JSONObject js = new JSONObject(jsstr);
        user.addCourse(js.toString());
        request.getSession().setAttribute("courses", user.getCourses());
        dao.update(user);
        rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }
}
