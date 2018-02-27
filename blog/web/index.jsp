<%--
  Created by IntelliJ IDEA.
  User: jiayu
  Date: 2018/2/26
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>java 博客</title>
  </head>
  <body>
  我的java博客
  <hr>
  <a href="./FirstServlet">传统的Servlet(3.0之前)写法，Get方式请求FirstServlet</a>
  <form action="./FirstServlet" method="post">
    <input type="submit" value="传统的Servlet(3.0之前)写法，Post方式请求FirstServlet">
  </form>
  <hr>
  <a href="./AddServlet?a=12&b=34">新版Servlet(3.0)的写法，Get方式请求AddServlet</a>
  </body>
</html>
