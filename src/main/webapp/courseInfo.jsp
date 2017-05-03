<%@ page import="org.springframework.beans.factory.BeanFactory" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.ottozhang.ism.dao.impl.CourseDaoImpl" %>
<%@ page import="com.ottozhang.ism.dataModel.Course" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangruoqiu
  Date: 2017/5/1
  Time: 上午12:35
  To change this template use File | Settings | File Templates.
--%>

<%
    BeanFactory bf = new ClassPathXmlApplicationContext("/appContext.xml");
    CourseDaoImpl dao = bf.getBean("courseDao", CourseDaoImpl.class);
    String courseStr = request.getParameter("course").replace("'", "\"");
    String groupss = request.getParameter("groups");
    Course coursec = new Course();
    coursec.setTitle(courseStr);
    coursec.setGroyps(groupss);
    List<Course> courseList = dao.get(coursec);
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course Info</title>
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/dashboard.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">EPITA exchange course manage system</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="index.jsp">Dashboard</a></li>
                <li><a href="#">Profile</a></li>
                <li><a href="<%=request.getContextPath()%>/logoutServlet">Log out</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="courseList.jsp">Courses list <span class="sr-only">(current)</span></a></li>
                <li class="active"><a  href="index.jsp">My Courses</a></li>
                <li><a href="calender.jsp">Calender</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Welcome, <%=session.getAttribute("username")%></h1>

            <h2 class="sub-header">Info of <%=courseList.get(0).getTitle()%></h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Date</th>
                        <th>Duration</th>
                        <th>Room</th>
                        <th>Teacher</th>
                        <th>Groups</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for(Course course:courseList){
                            String title = course.getTitle();
                            String date = course.getDatet();
                            String duration = course.getDuration();
                            String room = course.getRoom();
                            String teacher = course.getTeacher();
                            String groups = course.getGroyps();
                    %>
                    <tr>
                        <th><%= title%></th>
                        <th><%= date%></th>
                        <th><%= duration%></th>
                        <th><%= room%></th>
                        <th><%= teacher%></th>
                        <th><%= groups%></th>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
