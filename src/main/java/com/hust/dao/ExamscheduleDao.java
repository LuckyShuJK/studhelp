package com.hust.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hust.entity.Examschedule;

@Repository
public interface ExamscheduleDao {
	
	void addExamschedule(Examschedule examschedule);//��ӿ�����Ϣ
	
	List<Examschedule> queryExamscheduleById(String studentId);//����ѧ�Ų�ѯ���԰���
	
	void deleteExamscheduleByName(String examName, String studentId, String createTime);//ɾ��������Ϣ
	
	void updateExamscheduleById (Examschedule examschedule);//���¿�����Ϣ
	
}
