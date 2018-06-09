package com.hust.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hust.entity.Coursetable;

@Repository
public interface CoursetableDao {
	
	List<Coursetable> queryCoursetableById (String username);//根据学号查询课表
	
	void upadteCoursetable (Coursetable coursetable);//更新课表
	
	List<String> queryDaytableById(@Param("day") String day, @Param("studentId") String studentId);//查询某个学生某一天的课程
	
	void regester(String studentId);//注册学生
	
}
