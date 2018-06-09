package com.hust.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hust.entity.User;
import com.hust.service.CourseService;
import com.hust.service.UserService;

@Controller
public class RegesterController {
	
	@Autowired
    private UserService userService;
    
    @Autowired
    private CourseService courseService;
 
    @RequestMapping("/regestersubmit")
    public String regestersubmit(HttpSession session,@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("passwordcheck") String passwordcheck,
                                 @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("email") String email,
                                 @RequestParam("collage") String collage,@RequestParam("major") String major,@RequestParam("grade") int grade,
                                 @RequestParam("classNo") int classNo, @RequestParam("sex") String sex, @RequestParam("ismailsecret") int ismailsecret, @RequestParam("isphonesecret") int isphonesecret){
    	if(userService.queryUserById(username) != null) {
    		System.out.println("该用户已注册");
    		return "regester";
    	}
    	if(!password.equals(passwordcheck)) {
    		System.out.println("两次密码不一致");
    		return "regester";
    	}
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setClassNo(classNo);
        user.setCollage(collage);
        user.setEmail(email);
        user.setPhone(phone);
        user.setSex(sex);
        user.setMajor(major);
        user.setGrade(grade);
        user.setName(name);
        user.setIsmailsecret(ismailsecret);
        user.setIsphonesecret(isphonesecret);
        System.out.println(user.getSex());
        userService.regester(user);
        courseService.regester(user.getUsername());
        return "login";
    }
	
}
