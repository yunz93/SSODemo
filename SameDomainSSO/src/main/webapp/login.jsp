<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/5 0005
  Time: 上午 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录页面</title>
</head>
<body>
    <div style="text-align: center;">
        <h1>请登录</h1>
        <form action="/sso/doLogin.action" method="post">
            <span>用户名：</span><input type="text" name="username">
            <span>密码：</span><input type="password" name="password">
            <input type="hidden" name="gotoUrl" value="${gotoUrl}" />
            <input type="submit" />
        </form>
    </div>
</body>
</html>
