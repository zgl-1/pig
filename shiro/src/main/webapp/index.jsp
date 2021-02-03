<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World</title>
</head>
<body>
<h1>主页</h1>
<a href="${pageContext.request.contextPath}/user/encache">缓存测试</a>

<ul>
    <li><a href="">用户管理</a></li>
    <li><a href="">商品管理</a></li>
    <li><a href="">订单管理</a></li>
    <li><a href="">物流管理</a></li>
</ul>
<br>
<br>
<br>
<br>
<a href="${pageContext.request.contextPath}/user/loginout">退出登录</a>
</body>
</html>