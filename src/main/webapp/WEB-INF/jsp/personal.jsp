<%@ page import="com.hust.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("user");
    String day = (String)session.getAttribute("today");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>华中大助手 -- <%=user.getName()%></title>
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
<div id="wrapper">
    <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">华中科技大学</a>
        </div>
    </nav>
    <!-- /. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <div class="user-img-div">
                        <img src="images/user.png" class="img-thumbnail" />
                        <div class="inner-text">
                            <%=user.getName()%>&nbsp;<%=user.getCollage()%>&nbsp;
                            <br />
                            <small><%=user.getGrade()%>级&nbsp;<%=user.getMajor()%>&nbsp;<%=user.getClassNo()%>班 <br> <%=day%></small>
                        </div>
                    </div>
                </li>

                <li>
                    <a href="login">主页</a>
                </li>
                <li>
                    <a href="#">我的学习<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="coursetable">我的课表</a>
                        </li>
                        <li>
                            <a href="examschedule">我的考试倒计时</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="myclass">我的班级</a>
                </li>
                <li>
                    <a href="memo">我的个人备忘录</a>
                </li>
                <li>
                    <a href="inform">校学生通知</a>
                </li>
                <li>
                    <a href="#" class="active-menu-top"><%=user.getName()%><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse in ">
                        <li>
                            <a href="personalInfo" class="active-menu">我的个人信息</a>
                        </li>
                        <li>
                            <a href="logout">注销</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="about" >关于</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-head-line">我的个人信息</h1>
                    <h1 class="page-subhead-line">查信息? 看这儿就够了!</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#home" data-toggle="tab">我的基本信息</a>
                                </li>
                                <li class=""><a href="#profile" data-toggle="tab">我的信息修改</a>
                                </li>
                                <li class=""><a href="#messages" data-toggle="tab">密码修改</a>
                            </ul>

                            <div class="tab-content">
                                <div class="tab-pane fade active in" id="home">
                                    <div  class="row pad-top-botm client-info">
                                        <div class="col-lg-6 col-md-6 col-sm-6">
                                            <h4>  <strong>基本信息</strong></h4>
                                            <strong>  <%=user.getName()%>&nbsp;&nbsp; <%=user.getSex()%></strong>
                                            <br />
                                            <b>学号 :</b> <%=user.getUsername()%><br/>
                                            <b>联系电话 :</b> <%=user.getPhone()%><br/>
                                            <b>E-mail :</b> <%=user.getEmail()%><br/>
                                            <b>自我介绍(300字以内) :</b><span id="introductioncheck" style="color:#F00;font-size:14px;"></span><br/>
                                            <form action="introduction" method="post">
                                              <textarea id="introduction" name="introduction" style="width: 1090px;height: 135px;resize:none;"><%=user.getIntroduction()%></textarea><br/>
                                              <button type="submit" class="btn btn-info">保存</button>
                                            </form>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6">
                                            <h4><strong>学位信息</strong></h4>
                                            <b>所在学院 :  <%=user.getCollage()%> </b>
                                            <br />
                                            <b>就读专业 :  <%=user.getMajor()%> </b>
                                            <br />
                                            <b>年级 :  <%=user.getGrade()%>级 </b>
                                            <br />
                                            <b>班级 :  <%=user.getClassNo()%> 班</b>
                                            <br />
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="profile">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="panel panel-info">
                                            <div class="panel-body">
                                                <form role="form" action="updateuser" method="post">
                                                    <div class="form-group">
                                                        <label>姓名</label>
                                                        <input class="form-control" disabled="disabled" name="name" value="<%=user.getName()%>" type="text">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>性别</label>
                                                        <input class="form-control" disabled="disabled" name="sex" value="<%=user.getSex()%>" type="text">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>联系电话</label>>&nbsp;&nbsp;&nbsp;<select name="isphonesecret"><option value="<%=user.getIsphonesecret()%>"><%=(user.getIsphonesecret() == 1) ? "保密" : "公开"%></option><option value="<%=1-user.getIsphonesecret()%>"><%=(user.getIsphonesecret() != 1) ? "保密" : "公开"%></option></select>
                                                        <input class="form-control" id="phone" name="phone" value="<%=user.getPhone()%>" type="text">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>E-mail</label>&nbsp;&nbsp;&nbsp;<select name="ismailsecret"><option value="<%=user.getIsmailsecret()%>"><%=(user.getIsmailsecret() == 1) ? "保密" : "公开"%></option><option value="<%=1-user.getIsmailsecret()%>"><%=(user.getIsmailsecret() != 1) ? "保密" : "公开"%></option></select>
                                                        <input class="form-control" id="email" name="email" value="<%=user.getEmail()%>" type="text">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>所在学院</label>
                                                        <input class="form-control" disabled="disabled" name="collage" value="<%=user.getCollage()%>" type="text">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>就读专业</label>
                                                        <input class="form-control" disabled="disabled" name="major" value="<%=user.getMajor()%>" type="text">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>所在年级</label>
                                                        <input class="form-control" disabled="disabled" name="grade" value="<%=user.getGrade()%>" type="text">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>班级</label>
                                                        <input class="form-control" disabled="disabled" name="classno" value="<%=user.getClassNo()%>" type="text">
                                                    </div>
                                                    <span id="infomsg" style="color:#F00;font-size:14px;"></span><br>
                                                    <button type="submit" class="btn btn-info">提交</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="messages">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="panel panel-info">
                                            <div class="panel-body">
                                                <form action="revisepassword"  method="post">
                                                    <div class="form-group">
                                                        <label>学号</label>
                                                        <input class="form-control" value="<%=user.getUsername()%>" disabled="disabled" type="text">
                                                        <p class="help-block">修改学号请联系管理员</p>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>原密码</label>
                                                        <input id="old" name="oldpwd" class="form-control" type="password">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>新密码</label>
                                                        <input id="newpwd" name="newpwd" class="form-control" type="password">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>确认密码</label>
                                                        <input id="repeat" name="repeat" class="form-control" type="password">
                                                    </div>
                                                    <span id="msg" style="color:#F00;font-size:14px;"></span><br>
                                                    <button type="submit" class="btn btn-info">确认修改</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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
