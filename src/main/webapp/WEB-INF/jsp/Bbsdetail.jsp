<%@ page import="com.hust.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hust.entity.Bbs" %>
<%@ page import="com.hust.entity.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("user");
    String day = (String)session.getAttribute("today");
    Bbs bbs = (Bbs)session.getAttribute("bbs");
    List<Comment> commentList = ( List<Comment>)session.getAttribute("commentList");
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
                    <h1 class="page-head-line"><span><%=bbs.getTitle()%></span></h1>
                    <h1 class="page-subhead-line"><a href="memberdetail?id=<%=bbs.getStudentId()%>" target="_blank"><%=bbs.getStudentName()%></a> <%=" 发表于 " + bbs.getCreateTime()%></h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-info">
                        <div class="panel-body" style="padding: 2px;height: 1000px;width: 1510px; ">
                            <div class="chat-widget-main" style="height: 998px;">
                                <div class="col-md-12 col-sm-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <a href="memberdetail?id=<%=bbs.getStudentId()%>" target="_blank"><%=bbs.getStudentName()%></a>
                                        </div>
                                        <div class="panel-body" style="min-height: 200px;">
                                            <%
                                                out.println(bbs.getDetail().replace("\n", "<br>").replace(" ", "&nbsp;"));
                                            %>
                                        </div>
                                        <div class="panel-footer">
                                            <%=" 发表于 " + bbs.getCreateTime()%>&nbsp;&nbsp;
                                            <a href="good?topicStudentId=<%= bbs.getStudentId() %>&createTime=<%= bbs.getCreateTime() %>&goodStudentId=<%=user.getUsername() %>">点赞(<%=bbs.getGood()%>)</a>
                                            &nbsp;&nbsp;<span id="msg" style="color:#F00;font-size:14px;"></span>
                                        </div>
                                    </div>
                                </div>
                                <%
                                    Comment comment = null;
                                    for (int i = 0; i < commentList.size(); i++) {
                                        comment = commentList.get(i);
                                %>
                                <div class="col-md-12 col-sm-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <a href="memberdetail?id=<%=comment.getCommentStudentId()%>"><%=comment.getStudentName()%></a>
                                        </div>
                                        <div class="panel-body" style="min-height: 200px;">
                                            <%
                                                out.println(comment.getComment().replace("\n", "<br>").replace(" ", "&nbsp;"));
                                            %>
                                            <c:if test="<%=comment.getCommentStudentId().equals(user.getUsername())  %>">
                                                 <a href="deleteReply?topicStudentId=<%= comment.getTopicStudentId()%>&createTime=<%=comment.getCreateTime() %>&commentStudentId=<%=comment.getCommentStudentId() %>&commentTime=<%=comment.getCommentTime() %>">删除</a>
                                            </c:if>                                      
                                        </div>
                                        <div class="panel-footer">
                                            <%=" 回复于 " + comment.getCommentTime()%>
                                        </div>
                                    </div>
                                </div>
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="panel panel-info">
                        <div class="panel-body">
                        <form action="reply?topicStudentId=<%=bbs.getStudentId() %>&createTime=<%=bbs.getCreateTime() %>" method="post">
                            <div class="form-group">
                                <label>回复主题</label>
                                <textarea class="form-control" id="reply" name="reply" placeholder="内容(不多于1500字)" style="width: 1469px;height: 350px;resize:none;"></textarea>
                            </div>
                            <span id="replymsg" style="color:#F00;font-size:14px;"></span><br>
                            <input type="submit" id="submit" value="回复" />
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