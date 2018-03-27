<%--
  Created by IntelliJ IDEA.
  User: jiayu
  Date: 2018/3/26
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>用户登录</title>
  <!-- favicon 图标 -->
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon">
  <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon">
</head>
<body>
  <form name="formLogin" action="./LoginServlet" method="post">
    <h1 align="center">用户登录</h1>
    <br>
    <div align="center">
    账号:<input type="text" name="userName" size="20" maxlength="20"><br>
    密码:<input type="password" name="passWord" size="20" maxlength="20"><br>
    <input type="submit" name="submit" value="提交">
    <input type="reset" name="reset" value="重置">
    </div>
  </form>
</body>
</html>
