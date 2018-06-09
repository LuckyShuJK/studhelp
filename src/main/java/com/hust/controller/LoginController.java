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

import com.hust.entity.Memo;
import com.hust.entity.Inform;
import com.hust.action.InformDigger;
import com.hust.entity.Examschedule;
import com.hust.entity.User;
import com.hust.service.CourseService;
import com.hust.service.ExamscheduleService;
import com.hust.service.MemoService;
import com.hust.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private CourseService courseService;
	
    @Autowired
    private ExamscheduleService examscheduleService;
    
    @Autowired
    private MemoService memoService;
    
    @RequestMapping("/toLogin")
    public String toLogin() {
    	return "login";
    }
    /**
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, 
    		                 @RequestParam("password") String password, 
    		                 HttpSession session) {
    	User user = userService.login(username, password);
    	if(user != null) {
    		session.setAttribute("user", user);
    		List<String> todayClass = courseService.queryDaytableById(user.getUsername());
    		List<Examschedule> examschedules = examscheduleService.queryExamscheduleById(user.getUsername());
    		List<Memo> homememo = memoService.queryHomeMemoById(user.getUsername());
    		InformDigger informDigger = new InformDigger();
    		List<Inform> informs = null;
    		try {
                informs = informDigger.getInform();
            } catch (Exception e) {
                e.printStackTrace();
            }
    		session.setAttribute("homememo", homememo);
            session.setAttribute("informlist", informs);
            session.setAttribute("examschedule", examschedules);
            session.setAttribute("todaytable", todayClass);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日E");
            Date date = new Date();
            String day = sdf.format(date);
            session.setAttribute("today", day);
            return "welcome";
    	}else {
    		return "login";
    	}
    }*/
    @RequestMapping("/login")
    public String login(HttpSession session,HttpServletRequest request) {
    	User user = (User) session.getAttribute("user");
    	if(user == null) {
    		String username = request.getParameter("username");
    		String password = request.getParameter("password");
    		user = userService.login(username, password);
    	}    	
    	if(user != null) {
    		session.setAttribute("user", user);
    		List<String> todayClass = courseService.queryDaytableById(user.getUsername());
    		List<Examschedule> examschedules = examscheduleService.queryExamscheduleById(user.getUsername());
    		List<Memo> homememo = memoService.queryHomeMemoById(user.getUsername());
    		InformDigger informDigger = new InformDigger();
    		List<Inform> informs = null;
    		try {
                informs = informDigger.getInform();
            } catch (Exception e) {
                e.printStackTrace();
            }
    		session.setAttribute("homememo", homememo);
            session.setAttribute("informlist", informs);
            session.setAttribute("examschedule", examschedules);
            session.setAttribute("todaytable", todayClass);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日E");
            Date date = new Date();
            String day = sdf.format(date);
            session.setAttribute("today", day);
            return "welcome";
    	}else {
    		return "login";
    	}
    }
       
    @RequestMapping("/regester")
    public String regester() {
    	return "regester";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user");
        session.removeAttribute("today");
        session.removeAttribute("Coursetable");
        session.removeAttribute("informlist");
        session.removeAttribute("memolist");
        session.removeAttribute("homememo");
        session.setMaxInactiveInterval(1);
        return "redirect:/login";
    }
    
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
	
}