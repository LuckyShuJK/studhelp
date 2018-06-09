<%@ page import="com.hust.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hust.entity.Examschedule" %>
<%@ page import="com.hust.action.TimeCalculator" %>
<%@ page import="com.hust.entity.Inform" %>
<%@ page import="com.hust.entity.Memo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("user");
    List<String> todaytable = (List<String>)session.getAttribute("todaytable");
    String day = (String)session.getAttribute("today");
    List<Examschedule> examschedules = (List<Examschedule>)session.getAttribute("examschedule");
    List<Inform> informs = (List<Inform>) session.getAttribute("informlist");
    List<Memo> homememo = (List<Memo>) session.getAttribute("homememo");
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
                    <a class="active-menu" href="login">主页</a>
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
                    <h1 class="page-head-line">我的主页</h1>
                    <h1 class="page-subhead-line">看看今天有哪些需要关心的事儿吧！</h1>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <a href="personalInfo">我的信息</a>
                    </div>
                    <div class="panel-body">
                        <h4>学校:华中科技大学</h4>
                        <h4>学号:<%=user.getUsername()%></h4>
                        <h4>姓名:<%=user.getName()%></h4>
                        <h4>性别:<%=user.getSex()%></h4>
                        <h4>学院:<%=user.getCollage()%></h4>
                        <h4>专业:<%=user.getMajor()%></h4>
                        <h4>年级:<%=user.getGrade()%>级</h4>
                        <h4>班级:<%=user.getClassNo()%>班</h4>
                        <h4>属性:<%=(user.getIdentity() == 1) ? "学生" : "教职工"%></h4>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <i class="fa fa-bell fa-fw"></i>校学生通知
                    </div>

                    <div class="panel-body">
                        <div class="list-group">
                            <%
                                Inform inform = null;
                                for (int i = 0; i < 5; i++){
                                    inform = informs.get(i);
                            %>
                            <a href="detail?num=<%=i%>" target="_blank" class="list-group-item">
                                <%=inform.getTitle()%>
                                <span class="pull-right text-muted small"><em><%=inform.getInfo()%></em></span>
                            </a>
                            <%
                                }
                            %>
                        </div>
                        <a href="inform" class="btn btn-info btn-block">查看全部通知</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <a href="coursetable">我的今日课表</a>
                    </div>
                    <div class="panel-body">
                        <p class="text-muted">1-2节 08:00-09:35 <%=(todaytable.size() == 0) ? "" : todaytable.get(0)%></p>
                        <p class="text-muted">3-4节 10:00-11:35 <%=(todaytable.size() == 0) ? "" : todaytable.get(1)%></p>
                        <p class="text-muted">5-6节 13:30-15:05 <%=(todaytable.size() == 0) ? "" : todaytable.get(2)%></p>
                        <p class="text-muted">7-8节 15:30-17:05 <%=(todaytable.size() == 0) ? "" : todaytable.get(3)%></p>
                        <p class="text-muted">9-10节 18:00-19:35 <%=(todaytable.size() == 0) ? "" : todaytable.get(4)%></p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <a href="examschedule">我的考试倒计时</a>
                    </div>
                    <div class="panel-body">
                        <%
                            int size = examschedules.size();
                            Examschedule examschedule = null;
                            for (int i = 0; i < 5; i++){
                                if(i < size)
                                    examschedule = examschedules.get(i);
                                else
                                    examschedule = null;
                        %>
                        <p style="color: #000000;" class="text-muted"><%=i+1%>.<%=(examschedule == null)? "" : examschedule.getExamName()%> <%=(examschedule == null)? "" : examschedule.getExamPlace()%> <%=(examschedule == null)? "" : examschedule.getRemark()%> <%=(examschedule == null)? "" : TimeCalculator.timeCalculate(examschedule.getExamTime())%></p>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading"><a href="memo">我的个人备忘录</a></div>

                        <!-- Table -->
                        <table class="table">
                            <thead>
                            <tr>
                                <th> </th>
                                <th>标题</th>
                                <th>详情</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                Memo memo;
                                for (int i = 0; i < homememo.size(); i++) {
                                    memo = homememo.get(i);
                                
                            %>
                            <tr class="list-group-item-text">
                                <td><%=i + 1%></td>
                                <td><%=memo.getTitle()%></td>
                                <td><%=(memo.getDetail().length() >= 190) ? memo.getDetail().substring(0, 190) + "..." : memo.getDetail()%></td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
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