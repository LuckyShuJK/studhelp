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
        logger.info("�û���¼");
        return userDao.login(username, password);
    }
	
	public void revisePassword(String studentId, String revisepwd){
        logger.info("�޸�����");
        userDao.revisePassword(studentId, revisepwd);
    }
	
	public void updateUser(User user){
        logger.info("�޸ĸ�������");
        userDao.updateUser(user);
    }
	
	public User queryUserById(String username){
        return userDao.queryUserById(username);
    }
	
	public void regester(User user){
        logger.info("ע���˺�");
        userDao.regester(user);
    }
	
	public void updateIntroduction(String introduction, String username){
        logger.info("�޸����ҽ���");
        userDao.updateIntroduction(introduction, username);
    }
	
	public List<User> getUserlistByUser(User user){
        logger.info("��ȡͬ��ͬѧ");
        return userDao.getUserlistByUser(user);
    }
	
}
