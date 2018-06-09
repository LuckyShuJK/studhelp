package com.hust.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hust.entity.User;
import com.hust.service.UserService;

@Controller
public class UserInfoController {
	
	@Autowired
    private UserService userService;
	
	@RequestMapping("/personalInfo")
    public String personInfo(HttpSession session){
        Object obj = session.getAttribute("user");
        if(obj == null){
            return "redirect:/login";
        }
        return "personal";
    }
	
	@RequestMapping("/introduction")
	public String introduction(HttpSession session, @RequestParam("introduction") String introduction){
        User user = (User) session.getAttribute("user");
        userService.updateIntroduction(introduction, user.getUsername());
        user.setIntroduction(introduction);
        session.setAttribute("user",user);
        return "forward:/personalInfo";
    }
	
	@RequestMapping("/updateuser")
    public String updateuser(HttpSession session, 
    		@RequestParam("phone") String phone, @RequestParam("email") String email, 
    		@RequestParam("ismailsecret") int ismailsecret, @RequestParam("isphonesecret") int isphonesecret){
        User user = (User) session.getAttribute("user");
        user.setEmail(email);
        user.setPhone(phone);
        user.setIsphonesecret(isphonesecret);
        user.setIsmailsecret(ismailsecret);
        userService.updateUser(user);
        session.setAttribute("user", user);
        List<User> classmemberlist = userService.getUserlistByUser(user);
        session.setAttribute("classmember", classmemberlist);
        return "forward:/personalInfo";
    }
	
	@RequestMapping("/revisepassword")
	public String revisepassword(HttpSession session,@RequestParam("oldpwd") String oldpwd, 
			@RequestParam("newpwd") String newpwd,@RequestParam("repeat") String repeat){
        User user = (User) session.getAttribute("user");
        if(!oldpwd.equals(user.getPassword())){
        	System.out.println("原密码输入错误");
            return "error";
        }else{
        	if(!newpwd.equals(repeat)) {
        		System.out.println("两次密码输入不一致");
        		return "error";
        	}
            user.setPassword(newpwd);
            session.setAttribute("user", user);
            userService.revisePassword(user.getUsername(), newpwd);
            return "forward:/personalInfo";
        }
    }
	
}