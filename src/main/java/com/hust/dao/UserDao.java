package com.hust.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hust.entity.User;

@Repository
public interface UserDao {
    
	User login (@Param("username") String username, @Param("password")String password);//验证登入用户
	
	void revisePassword(@Param("studentId") String studentId, @Param("revisepwd") String revisepwd);//修改用户密码
	
	void updateUser(User user);//更新用户
	
	User queryUserById(String username);//查询用户
	
	void regester(User user);//注册用户
	
	void updateIntroduction(String introduction, String username);//更新自我介绍
	
	List<User> getUserlistByUser(User user);//获取用户信息
	
}
