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
  <a href="/blog/FirstServlet">Get方式请求FirstServlet</a>
  <form action="/blog/FirstServlet" method="post">
    <input type="submit" value="Post方式请求FirstServlet">
  </form>
  <hr>
  <a href="/blog/AddServlet?a=12&b=34">Get方式请求AddServlet</a>
  </body>
</html>
