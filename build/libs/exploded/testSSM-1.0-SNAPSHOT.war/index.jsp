<%--
  Created by IntelliJ IDEA.
  User: mlj
  Date: 17-10-18
  Time: 下午9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    <table>
        <tr>
            <td>用户名：
            <td><input type="text" name="username"/></td>
            </td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"/></td>
            <td><a href="${pageContext.request.contextPath}/rejister.jsp">注册</a></td>
        </tr>
    </table>


</form>
</body>
</html>
