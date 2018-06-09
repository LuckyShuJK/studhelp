package com.hust.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hust.entity.Coursetable;
import com.hust.entity.User;
import com.hust.service.CourseService;

@Controller
public class CoursetableController {
	
	@Autowired
    private CourseService courseService;
	
	@RequestMapping("/coursetable")
    public String coursetable(HttpSession session){
        Object obj = session.getAttribute("user");
        if(obj == null){
            return "redirect:/login";
        }
        String username = ((User)session.getAttribute("user")).getUsername();
        List<Coursetable> coursetables = courseService.queryCoursetableById(username);
        session.setAttribute("coursetable", coursetables);
        return "coursetable";
    }
	
	@RequestMapping("/editcoursetable")
    public String editcoursetable(HttpSession session){
        Object obj = session.getAttribute("user");
        if(obj == null){
            return "redirect:/login";
        }
        return "editcoursetable";
    }
	
	@RequestMapping("/submitcoursetable")
    public String submitCoursetable(HttpSession session, HttpServletRequest request){
        String username = ((User)session.getAttribute("user")).getUsername();
        Coursetable coursetable = null;
        for (int i = 0; i < 5; i++) {
            coursetable = new Coursetable();
            coursetable.setStudentId(username);
            coursetable.setClassNo(i + 1);
            coursetable.setMon(request.getParameter(i + 1 + "Mon"));
            coursetable.setTue(request.getParameter(i + 1 + "Tue"));
            coursetable.setWed(request.getParameter(i + 1 + "Wed"));
            coursetable.setThu(request.getParameter(i + 1 + "Thu"));
            coursetable.setFri(request.getParameter(i + 1 + "Fri"));
            coursetable.setSat(request.getParameter(i + 1 + "Sat"));
            coursetable.setSun(request.getParameter(i + 1 + "Sun"));
            courseService.upadteCoursetable(coursetable);
        }
        List<String> todayClass = courseService.queryDaytableById(username);
        session.setAttribute("todaytable", todayClass);
        return "redirect:" + this.coursetable(session);
    }
	
}
