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
 * Created by zhangruoqiu on 2017/5/1.
 */
@WebServlet(name = "LoginServlet")
// TODO [Q] why inject doesn't work here
//@ContextConfiguration("file:/resources/appContext.xml")
public class LoginServlet extends HttpServlet {
    //@interface  IdentityDaoImpl dao;
    BeanFactory bf = new ClassPathXmlApplicationContext("/appContext.xml");
    IdentityDaoImpl dao = bf.getBean("dao", IdentityDaoImpl.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String returnUri = request.getParameter("return_uri");

        RequestDispatcher rd = null;

        if (email == null || pwd == null){
            request.setAttribute("msg", "plz type in password and username");
            rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } else {
            Identity identity = new Identity();
            identity.setEmail(email);
            identity.setPassword(pwd);
            List<Identity> ids = dao.get(identity);
            if (ids != null && ! ids.isEmpty()){
                request.setAttribute("flag", "login_success");
                request.setAttribute("email", ids.get(0).getName());
                if (returnUri != null) {
                    rd = request.getRequestDispatcher(returnUri);
                } else {
                    rd = request.getRequestDispatcher("index.jsp");
                }
            } else {
                request.getSession().setAttribute("flag", "login_error");
                request.setAttribute("msg", "username or password error!");
                rd = request.getRequestDispatcher("login.jsp");
            }
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
