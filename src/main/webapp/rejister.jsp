<%--
  Created by IntelliJ IDEA.
  User: mlj
  Date: 17-10-18
  Time: 下午11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/rejister" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="user.username"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="user.password"/></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="number" name="user.age"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"/></td>
            <td><a href="${pageContext.request.contextPath}/index.jsp">登录</a></td>
        </tr>
    </table>
</form>
</body>
</html>
