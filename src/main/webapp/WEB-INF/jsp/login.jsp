<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>华中大助手 -- 登录</title>
    <link rel="stylesheet" href="../../css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Lambent Login Form Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
</head>
<body>
<h1>华中大助手</h1>
<div class="main-agileinfo">
    <h2>登录</h2>
    <form action="login" method="post" >
        <input type="text" id="username" name="username" class="name" style="width: 477px;" placeholder="用户名" required="required" />
        <input type="password" id="password" name="password" class="password" style="width:477px;" placeholder="密码" required="required" /><br>
        <span id="msg" style="color:#F00;font-size:14px;"></span>
        <a href="regester">注册
        </a><br>
        <div class="clear"></div>
        <input type="submit" id="submit" value="登录" />
    </form>
</div>
<div class="footer-w3l">
    <p class="agile">Copyright &copy; 2018 <a href="https://github.com/LuckyShuJK" target="_blank" title="">LuckyShuJk</a></p>
</div>
</body>
</html>