package com.hust.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hust.entity.User;

@Repository
public interface UserDao {
    
	User login (@Param("username") String username, @Param("password")String password);//��֤�����û�
	
	void revisePassword(@Param("studentId") String studentId, @Param("revisepwd") String revisepwd);//�޸��û�����
	
	void updateUser(User user);//�����û�
	
	User queryUserById(String username);//��ѯ�û�
	
	void regester(User user);//ע���û�
	
	void updateIntroduction(String introduction, String username);//�������ҽ���
	
	List<User> getUserlistByUser(User user);//��ȡ�û���Ϣ
	
}
