package com.hust.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hust.entity.Comment;
import com.hust.entity.Bbs;
import com.hust.entity.User;
import com.hust.service.BbsService;
import com.hust.service.UserService;

@Controller
public class ClassController {
	
	@Autowired
    private UserService userService;
    
    @Autowired
    private BbsService bbsService;
    
    @RequestMapping("/myclass")
    public String myclass(HttpSession session){
        User user = (User)session.getAttribute("user");
        List<User> classmemberlist = userService.getUserlistByUser(user);
        session.setAttribute("classmember", classmemberlist);
        List<Bbs> bbsList = bbsService.getTopicByUser(user);
        List<Bbs> usertopiclist = bbsService.getOwnTopic(user.getUsername());
        session.setAttribute("usertopiclist", usertopiclist);
        session.setAttribute("bbsList", bbsList);
        return "myclass";
    }
    
    @RequestMapping("/memberdetail")
    public String memberdetail(HttpSession session, HttpServletRequest request){
        String id = request.getParameter("id");
        User detailmember = userService.queryUserById(id);
        session.setAttribute("detailmember", detailmember);
        return "memberdetail";
    }
    
    @RequestMapping("/Bbsdetail")
    public String Bbsdetail(HttpSession session, HttpServletRequest request){
        String studentId = request.getParameter("topicStudentId");
        String time = request.getParameter("createTime");
        Bbs bbs = bbsService.queryBbsByIdAndTime(studentId, time);
        List<Comment> commentList = bbsService.getReply(studentId, time);
        session.setAttribute("commentList", commentList);
        session.setAttribute("bbs", bbs);
        return "Bbsdetail";
    }
    
    @RequestMapping("/good")
    public String good(HttpSession session, HttpServletRequest request){
        String topicStudentId = request.getParameter("topicStudentId");
        String createTime = request.getParameter("createTime");
        String goodStudentId = request.getParameter("goodStudentId");
        String response = bbsService.queryIsGood(topicStudentId, createTime, goodStudentId);
        if(response == null){
            bbsService.good(topicStudentId, createTime, goodStudentId);
        }
        else{
        	bbsService.cancelGood(topicStudentId, createTime, goodStudentId);
        }
        return "forward:/Bbsdetail";
    }
    
    @RequestMapping("/reply")
    public String reply (HttpSession session,
    		             @RequestParam("reply") String reply, 
    		             @RequestParam("topicStudentId") String topicStudentId, 
    		             @RequestParam("createTime") String createTime){
        User user = (User)session.getAttribute("user");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        bbsService.reply(topicStudentId, createTime, reply, user.getUsername(), user.getName(), sdf.format(new Date()));
        return "forward:/Bbsdetail";
    }
    
    @RequestMapping("/deleteReply")
    public String deleteReply(HttpSession session,
    		                  @RequestParam("topicStudentId") String topicStudentId,
    		                  @RequestParam("createTime") String createTime,
    		                  @RequestParam("commentStudentId") String commentStudentId,
    		                  @RequestParam("commentTime") String commentTime) {
    	bbsService.deleteReply(topicStudentId, createTime, commentStudentId, commentTime);
    	return "forward:/Bbsdetail";
    }
    
    @RequestMapping("/newtopic")
    public String newtopic(HttpSession session, @RequestParam("topictitle") String topictitle, @RequestParam("topicdetail") String topicdetail){
        Bbs bbs = new Bbs();
        User user = (User)session.getAttribute("user");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        bbs.setStudentId(user.getUsername());
        bbs.setDetail(topicdetail);
        bbs.setCreateTime(sdf.format(new Date()));
        bbs.setTitle(topictitle);
        bbsService.newTopic(bbs);
        return this.myclass(session);
    }
    
    @RequestMapping("/deletetopic")
    public String deletetopic(HttpSession session, HttpServletRequest request){
        String createTime = request.getParameter("time");
        User user = (User)session.getAttribute("user");
        bbsService.deleteTopic(user.getUsername(), createTime);
        return this.myclass(session);
    }
	
}
