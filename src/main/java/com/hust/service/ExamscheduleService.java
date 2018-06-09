package com.hust.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.entity.Examschedule;
import com.hust.dao.ExamscheduleDao;

@Service
public class ExamscheduleService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ExamscheduleDao examscheduleDao;
	
	//添加考试
	public void addExam(Examschedule examschedule){
	    logger.info("添加考试");
	    examscheduleDao.addExamschedule(examschedule);
	}
	
	//获取考试安排
	public List<Examschedule> queryExamscheduleById(String studentId){
	    logger.info("获取考试安排");
	    return examscheduleDao.queryExamscheduleById(studentId);
	}
	
	//删除科目考试
	public void deleteExamscheduleByName(String examName, String studentId, String createTime){
	    logger.info("删除科目" + examName + "考试");
	    examscheduleDao.deleteExamscheduleByName(examName, studentId, createTime);
	}
	
	//更新考试信息
	public void updateExamscheduleById(Examschedule examschedule){
	    logger.info("更新" + examschedule.getExamName() + "考试");
	    examscheduleDao.updateExamscheduleById(examschedule);
	}
	
}