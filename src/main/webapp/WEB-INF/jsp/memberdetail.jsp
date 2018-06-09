<%@ page import="com.hust.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("user");
    String day = (String)session.getAttribute("today");
    User detailmember = (User) session.getAttribute("detailmember");
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
                        <img src="../../images/user.png" class="img-thumbnail" />
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
                    <a class="active-menu" href="myclass">我的班级</a>
                </li>
                <li>
                    <a href="memo">我的个人备忘录</a>
                </li>
                <li>
                    <a href="inform">校学生通知</a>
                </li>
                <li>
                    <a href="#"><%=user.getName()%><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="personalInfo">我的个人信息</a>
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
                    <h1 class="page-head-line"><a href="myclass" class="btn btn-default">←</a><%=detailmember.getName()%></h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="row pad-top-botm client-info">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <h4>学号:<%=detailmember.getUsername()%></h4>
                            <br />
                            <h4>姓名:<%=detailmember.getName()%></h4>
                            <br />
                            <h4>性别:<%=detailmember.getSex()%></h4>
                            <br />
                            <h4>学院:<%=detailmember.getCollage()%></h4>
                            <br />
                            <h4>专业:<%=detailmember.getMajor()%></h4>
                            <br />
                            <h4>班级:<%=detailmember.getGrade() + "级" + detailmember.getClassNo() + "班"%></h4>
                            <br />
                            <h4>邮箱:<%=(detailmember.getIsmailsecret() == 1) ? "保密" : detailmember.getEmail()%></h4>
                            <br />
                            <h4>联系电话:<%=(detailmember.getIsphonesecret() == 1) ? "保密" : detailmember.getPhone()%></h4>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <h4>自我介绍:</h4>
                            <br />
                            <h4><%=detailmember.getIntroduction()%></h4>
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
