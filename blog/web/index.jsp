<%--
  Created by IntelliJ IDEA.
  User: jiayu
  Date: 2018/2/26
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
  <head>
    <title>docker的tomcat容器</title>
    <!-- favicon 图标 -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon">
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon">
  </head>
  <body>
  docker-tomcat
  <br>
  测试页面
  <hr>
  FirstServlet部分
  <br>
  <a href="./FirstServlet">传统的Servlet(3.0之前)写法，Get方式请求FirstServlet</a>
  <form action="./FirstServlet" method="post">
    <input type="submit" value="传统的Servlet(3.0之前)写法，Post方式请求FirstServlet">
  </form>
  <hr>
  AddServlet部分
  <br>
  <a href="./AddServlet?a=12&b=34">新版Servlet(3.0)的写法，Get方式请求AddServlet</a>
  <form action="./AddServlet" method="post">
    整数a:<input type="text" name="a" value="12">
    <br>
    整数b:<input type="text" name="b" value="34">
    <br>
    <input type="submit" value="新版Servlet(3.0)的写法，Post方式请求AddServlet">
  </form>
  <hr>
  用户登录测试
  <br>
  <a href="login.jsp">去登录页面</a>
  </body>
</html>
