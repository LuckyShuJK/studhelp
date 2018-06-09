package com.hust.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hust.entity.Coursetable;

@Repository
public interface CoursetableDao {
	
	List<Coursetable> queryCoursetableById (String username);//����ѧ�Ų�ѯ�α�
	
	void upadteCoursetable (Coursetable coursetable);//���¿α�
	
	List<String> queryDaytableById(@Param("day") String day, @Param("studentId") String studentId);//��ѯĳ��ѧ��ĳһ��Ŀγ�
	
	void regester(String studentId);//ע��ѧ��
	
}
