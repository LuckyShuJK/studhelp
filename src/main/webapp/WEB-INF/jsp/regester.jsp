<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
          "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>华中大助手 -- 注册</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="../../css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="../../css/font-awesome.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="../../css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="../../css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<!-- /. NAV SIDE  -->
<div id="page-inner">
    <div class="row">
        <div class="col-md-12">
            <h1 class="page-head-line">用户注册</h1>
            <h1 class="page-subhead-line">很感谢使用华中大助手，快快加入我们吧！</h1>
        </div>
    </div>
    <!-- /. ROW  -->
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="panel panel-info">
                <div class="panel-body">
                    <form action="regestersubmit" method="post" >
                        <div class="form-group">
                            <label>学号(学号将是您的用户名)</label>
                            <input id="username" name="username" class="form-control" type="text" />
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input id="password" name="password" class="form-control" type="password" />
                        </div>
                        <div class="form-group">
                            <label>确认密码</label>
                            <input id="passwordcheck" name="passwordcheck" class="form-control" type="password" />
                        </div>
                        <div class="form-group">
                            <label>学生姓名</label>
                            <input id="name" name="name" class="form-control" type="text" />
                        </div>
                        <div class="form-group">
                            <label>性别</label>
                            <select id="sex" name="sex" class="form-control">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>联系电话</label>&nbsp;&nbsp;&nbsp;<select name="isphonesecret"><option value="1">保密</option><option value="0">公开</option></select>
                            <input id="phone" name="phone" class="form-control" type="text" />
                        </div>
                        <div class="form-group">
                            <label>E-Mail</label>&nbsp;&nbsp;&nbsp;<select name="ismailsecret"><option value="1">保密</option><option value="0">公开</option></select>
                            <input id="email" name="email" class="form-control" type="text" />
                        </div>
                        <div class="form-group">
                            <label>所在学院</label>
                            <input id="collage" name="collage" class="form-control" type="text" />
                        </div>
                        <div class="form-group">
                            <label>就读专业</label>
                            <input id="major" name="major" class="form-control" type="text" />
                        </div>
                        <div class="form-group">
                            <label>所在年级</label>
                            <select id="grade" name="grade" class="form-control">
                                <option value="2018">2018</option>
                                <option value="2017">2017</option>
                                <option value="2016">2016</option>
                                <option value="2015">2015</option>
                                <option value="2014">2014</option>
                                <option value="2013">2013</option>
                                <option value="2012">2012</option>
                                <option value="2011">2011</option>
                                <option value="2010">2010</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>班级</label>
                            <select id="classNo" name="classNo" class="form-control">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                        <span id="msg" style="color:#F00;font-size:14px;text-align: center"></span>
                        <center><input type="submit" id="submit" value="提交注册" /></center>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="footer-sec">
    Copyright &copy; 2018 <a href="https://github.com/LuckyShuJK" target="_blank" title="">LuckyShuJK</a>
</div>
</body>
</html>