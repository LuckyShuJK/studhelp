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

import com.hust.entity.Examschedule;
import com.hust.entity.User;
import com.hust.service.ExamscheduleService;

@Controller
public class ExamscheduleController {
	
	@Autowired
    private ExamscheduleService examscheduleService;
	
	@RequestMapping("/examschedule")
    public String examschedule(HttpSession session){
        Object obj = session.getAttribute("user");
        if(obj == null){
            return "redirect:/login";
        }
        String studentId = ((User)session.getAttribute("user")).getUsername();
        List<Examschedule> examschedules = examscheduleService.queryExamscheduleById(studentId);
        session.setAttribute("examschedule", examschedules);
        return "examschedule";
    }
	
	@RequestMapping("/examedit")
    public String addexam(HttpServletRequest request, HttpSession session){
        Object obj = session.getAttribute("user");
        if(obj == null){
            return "redirect:/login";
        }
        String edit = request.getParameter("edit");
        if(edit != null){
            String studentId = ((User)session.getAttribute("user")).getUsername();
            List<Examschedule> examschedules = examscheduleService.queryExamscheduleById(studentId);
            Examschedule examschedule = examschedules.get(Integer.parseInt(edit));
            session.setAttribute("editexam", examschedule);
        }
        else{
            session.removeAttribute("editexam");
        }
        return "examedit";
    }
	
	 @RequestMapping("/submitexam")
	 public String submitexam(@RequestParam("date") String date,
	    		              @RequestParam("examsubject") String examsubject,
	    		              @RequestParam("place") String place,
	    		              @RequestParam("remark") String remark, 
	    		              HttpSession session, HttpServletRequest request){
	     Object obj = session.getAttribute("user");
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	     if(obj == null){
	         return "redirect:/login";
	     }
	     String action = request.getParameter("action");
	     Examschedule examschedule = new Examschedule();
	     examschedule.setStudentId(((User)session.getAttribute("user")).getUsername());
	     examschedule.setExamName(examsubject);
	     examschedule.setExamPlace(place);
	     examschedule.setExamTime(date);
	     examschedule.setRemark(remark);
	     if(action.equals("add")){
	         Date date1 = new Date();
	         examschedule.setCreateTime(sdf.format(date1));
	         examscheduleService.addExam(examschedule);
	     }
	     else {
	         Examschedule oldexam = (Examschedule) session.getAttribute("editexam");
	         examschedule.setOldName(oldexam.getExamName());
	         examscheduleService.updateExamscheduleById(examschedule);
	     }
	     return this.examschedule(session);
	 }
	 
	 @RequestMapping("examdelete")
	 public String examdelete(HttpSession session, HttpServletRequest request){
	     Object obj = session.getAttribute("user");
	     if(obj == null){
	         return "/login";
	     }
	     String deletenum = request.getParameter("delete");
	     String studentId = ((User)session.getAttribute("user")).getUsername();
	     Examschedule examschedule = ((List<Examschedule>)session.getAttribute("examschedule")).get(Integer.parseInt(deletenum));
	     String examName =examschedule.getExamName();
	     String createTime = examschedule.getCreateTime();
	     examscheduleService.deleteExamscheduleByName(examName, studentId, createTime);
	     return this.examschedule(session);
	 }
	
}