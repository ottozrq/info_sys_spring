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

/**
 * Created by zhangruoqiu on 2017/5/3.
 */
@WebServlet(name = "RegistServlet", urlPatterns = "/registServlet")
public class RegistServlet extends HttpServlet {

    BeanFactory bf = new ClassPathXmlApplicationContext("/appContext.xml");
    IdentityDaoImpl dao = bf.getBean("dao", IdentityDaoImpl.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        String name = request.getParameter("name");
        String password = request.getParameter("pwd");
        String rpassword = request.getParameter("rpwd");
        String email = request.getParameter("email");
        if (! password.equals(rpassword)){
            request.setAttribute("msg", "Password doesn't match, please confirm your password.");
            rd = request.getRequestDispatcher("regist.jsp");
            rd.forward(request, response);
        }
        Identity identity = new Identity(name, name, password, email);
        try {
            dao.add(identity);
        } catch (Exception e) {
            System.err.println(e.toString());
            request.setAttribute("msg", "name or email already exist.");
            rd = request.getRequestDispatcher("regist.jsp");
            rd.forward(request, response);
        }
        request.getSession().setAttribute("flag", "login_success");
        request.getSession().setAttribute("email", identity.getEmail());
        request.getSession().setAttribute("username", identity.getName());
        request.getSession().setAttribute("courses", identity.getCourses());
        rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
