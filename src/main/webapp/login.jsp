<%--
  Created by IntelliJ IDEA.
  User: zhangruoqiu
  Date: 2017/4/30
  Time: 下午8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/signin.js"></script>
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">

</head>
<body>
    <div class="container">
        <form class="form-signin" name="loginForm" method="post" action="<%=request.getContextPath()%>/loginServlet">
            <% if(request.getAttribute("return_uri") !=null) {%>
                <input type="hidden" name="return_uri" value="<%request.getAttribute("return_uri"); %>">
            <%} %>
            <h2 class="form-signin-heading">Please sign in</h2>
            <% if (request.getAttribute("msg") != null) {%>
                <h4 class="bg-danger"><%=request.getAttribute("msg")%></h4>
            <%}%>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control"  placeholder="Password" name="pwd" required>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <input class="btn btn-lg btn-primary btn-block" type="submit" onclick="return check(this)" value="Sign in">
            <a class="btn btn-lg btn-primary btn-block" href="regist.jsp">Register</a>
        </form>

    </div>
</body>
</html>
