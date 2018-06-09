<%@ page import="com.hust.entity.User" %>
<%@ page import="com.hust.entity.Memo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("user");
    String day = (String)session.getAttribute("today");
    Memo memo = (Memo) session.getAttribute("editmemo");
    String action = "edit";
    if(memo == null){
        action = "add";
    }

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
                    <a href="#" class="active-menu-top">我的学习<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse in ">
                        <li>
                            <a href="coursetable">我的课表</a>
                        </li>
                        <li>
                            <a class="active-menu" href="examschedule">我的考试倒计时</a>
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
                    <h1 class="page-head-line">我的个人备忘录</h1>
                    <h1 class="page-subhead-line">经常忘事儿? 它能帮你!</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                                                                                添加备忘录
                        </div>
                        <div class="panel-body">
                            <form action="submitmemo?action=<%=action%>" method="post">
                                <div class="panel-body" style="padding: 0px;height: 460px;">
                                  <div class="chat-widget-main">
                                     <input id="title" name="title" placeholder="标题" type="text" style="width: 700px;height: 45px" value="<%=(action.equals("edit"))?memo.getTitle() : "" %>"><br><br>
                                     <textarea id="detail" name="detail" style="resize:none;height: 325px;width: 700px;"><%=(action.equals("edit"))? memo.getDetail() : "" %></textarea>
                                     <br><span id="msg" style="color:#F00;font-size:14px;text-align: center"></span>
                                  </div>
                               </div>
                               <div class="panel-footer">
                                  <div class="input-group">
                                                                                                 置顶首页<input id="home" name="home" type="checkbox" />
                                  </div>
                               </div>
                               <span id="msg" style="color:#F00;font-size:14px;text-align: center"></span>
                               <center><button type="submit" class="btn btn-success">确认添加</button><a href="memo" class="btn btn-default">返回</a> </center>
                           </form>
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