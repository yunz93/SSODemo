<%@page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录</title>
</head>
<body>
<div style="text-align: center;">
    <h1>请登录</h1>
    <form action="/sso/doLogin" method="post">
        <input type="hidden" name="gotoUrl" value="${gotoUrl}"/>
        <span>用户名：</span><input type="text" name="username"/>
        <span>密    码：</span><input type="password" name="password"/>
        <input type="submit">
    </form>
</div>
</body>
</html>
