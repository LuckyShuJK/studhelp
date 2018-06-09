package com.hust.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.entity.User;
import com.hust.dao.UserDao;

@Service
public class UserService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserDao userDao;
	
	public User login(String username, String password){
        logger.info("用户登录");
        return userDao.login(username, password);
    }
	
	public void revisePassword(String studentId, String revisepwd){
        logger.info("修改密码");
        userDao.revisePassword(studentId, revisepwd);
    }
	
	public void updateUser(User user){
        logger.info("修改个人资料");
        userDao.updateUser(user);
    }
	
	public User queryUserById(String username){
        return userDao.queryUserById(username);
    }
	
	public void regester(User user){
        logger.info("注册账号");
        userDao.regester(user);
    }
	
	public void updateIntroduction(String introduction, String username){
        logger.info("修改自我介绍");
        userDao.updateIntroduction(introduction, username);
    }
	
	public List<User> getUserlistByUser(User user){
        logger.info("获取同班同学");
        return userDao.getUserlistByUser(user);
    }
	
}
