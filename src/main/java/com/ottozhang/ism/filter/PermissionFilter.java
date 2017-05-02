package com.ottozhang.ism.filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by zhangruoqiu on 2017/5/2.
 */
@WebFilter(filterName = "PermissionFilter", urlPatterns = "/*")
public class PermissionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();
        HttpSession session = request.getSession();
        String flag = (String)session.getAttribute("flag");
        if (servletPath!=null
                && (servletPath.equals("login.jsp")
                    || servletPath.equals("/loginServlet")
                    || servletPath.indexOf("/webjars") > 0
                    || servletPath.indexOf("js/") > 0
                    || servletPath.indexOf("css/") > 0)) {
            chain.doFilter(request, response);
        }else {
            if (flag != null && flag.equals("login_success")) {
                chain.doFilter(req, resp);
            } else if (flag != null && flag.equals("login_error")) {
                request.setAttribute("msg", "login error");
                request.setAttribute("return_uri", servletPath);
                RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                rd.forward(req, resp);
            } else {
                req.setAttribute("msg", "Please login first");
                req.setAttribute("return_uri", servletPath);
                RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                rd.forward(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
