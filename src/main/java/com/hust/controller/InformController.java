package com.hust.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hust.action.InformDigger;
import com.hust.entity.Inform;

@Controller
public class InformController {
	
	@RequestMapping("/inform")
    public String inform(HttpSession session){
        Object obj = session.getAttribute("user");
        if(obj == null){
            return "redirect:/login";
        }
        InformDigger informDigger = new InformDigger();
        List<Inform> informs = null;
        try {
            informs = informDigger.getInform();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("informlist", informs);
        return  "inform";
    }
	
	@RequestMapping("/detail")
    public String  detail(HttpSession session, HttpServletRequest request){
        Object obj = session.getAttribute("user");
        if(obj == null){
            return "redirect:/login";
        }
        int num = Integer.parseInt(request.getParameter("num"));
        List<Inform> informs = (List<Inform>) session.getAttribute("informlist");
        session.setAttribute("detailnum", ((List<Inform>) session.getAttribute("informlist")).get(num));
        return "informdetail";
    }
	
}
