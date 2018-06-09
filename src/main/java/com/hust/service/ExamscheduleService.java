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
	
	//��ӿ���
	public void addExam(Examschedule examschedule){
	    logger.info("��ӿ���");
	    examscheduleDao.addExamschedule(examschedule);
	}
	
	//��ȡ���԰���
	public List<Examschedule> queryExamscheduleById(String studentId){
	    logger.info("��ȡ���԰���");
	    return examscheduleDao.queryExamscheduleById(studentId);
	}
	
	//ɾ����Ŀ����
	public void deleteExamscheduleByName(String examName, String studentId, String createTime){
	    logger.info("ɾ����Ŀ" + examName + "����");
	    examscheduleDao.deleteExamscheduleByName(examName, studentId, createTime);
	}
	
	//���¿�����Ϣ
	public void updateExamscheduleById(Examschedule examschedule){
	    logger.info("����" + examschedule.getExamName() + "����");
	    examscheduleDao.updateExamscheduleById(examschedule);
	}
	
}