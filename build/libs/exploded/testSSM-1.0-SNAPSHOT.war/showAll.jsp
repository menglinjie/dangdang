<%--
  Created by IntelliJ IDEA.
  User: mlj
  Date: 17-10-18
  Time: 下午11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>所有用户</title>
</head>
<body>
<h1>欢迎登陆，<s:property value="#session.username"></s:property></h1>
<table border="1">
    <tr>
        <td>用户id</td>
        <td>用户姓名</td>
        <td>用户密码</td>
        <td>用户年龄</td>
        <td>删除</td>
        <td>修改</td>
    </tr>
    <s:iterator value="users">
        <tr>
            <td><s:property value="id"></s:property></td>
            <td><s:property value="username"></s:property></td>
            <td><s:property value="password"></s:property></td>
            <td><s:property value="age"></s:property></td>
            <td><a href="${pageContext.request.contextPath}/user/delete?id=<s:property value="id"></s:property>">删除</a>
            </td>
        </tr>
    </s:iterator>
    <tr>
        <td colspan="5">
            <a href="${pageContext.request.contextPath}/index.jsp">登录</a>
            <a href="${pageContext.request.contextPath}/rejister.jsp">注册</a>
        </td>
    </tr>
</table>
</body>
</html>
