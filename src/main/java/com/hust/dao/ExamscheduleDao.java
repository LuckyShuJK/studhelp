package com.hust.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hust.entity.Examschedule;

@Repository
public interface ExamscheduleDao {
	
	void addExamschedule(Examschedule examschedule);//添加考试信息
	
	List<Examschedule> queryExamscheduleById(String studentId);//根据学号查询考试安排
	
	void deleteExamscheduleByName(String examName, String studentId, String createTime);//删除考试信息
	
	void updateExamscheduleById (Examschedule examschedule);//更新考试信息
	
}
