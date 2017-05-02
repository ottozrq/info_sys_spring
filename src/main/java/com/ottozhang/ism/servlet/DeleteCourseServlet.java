package com.ottozhang.ism.servlet;

import com.ottozhang.ism.dao.impl.IdentityDaoImpl;
import com.ottozhang.ism.dataModel.Identity;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
@WebServlet(name = "DeleteCourseServlet",urlPatterns = "/deleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
    BeanFactory bf = new ClassPathXmlApplicationContext("/appContext.xml");
    IdentityDaoImpl dao = bf.getBean("dao", IdentityDaoImpl.class);


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Identity identity = new Identity();
        String email = request.getSession().getAttribute("email").toString();
        identity.setEmail(email);
        List<Identity> users = dao.get(identity);
        Identity user = users.get(0);
        String course = request.getParameter("course");
        String groups = request.getParameter("groups");
        String jsstr = "{\"" + course + "\":\"" + groups + "\"}";
        user.deleteCourse(jsstr);
        request.getSession().setAttribute("courses", user.getCourses());
        dao.update(user);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
