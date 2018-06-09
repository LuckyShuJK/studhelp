package com.hust.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hust.entity.User;
import com.hust.entity.Comment;
import com.hust.entity.Bbs;

@Repository
public interface BbsDao {
	
	void newTopic(Bbs bbs);//�����µ�����
	
	List<Bbs> getTopicByUser(User user);//��ȡ�û����ڰ༶�����˵�����
	
	List<Bbs> getOwnTopic(String studentId);//��ȡ�Լ�������
	
	Bbs queryBbsByIdAndTime(String studentId, String createTime);//ͨ��ѧ�źʹ���ʱ���ѯ����
	
	void good(String studentId, String createTime, String goodStudentId);//ʵ�ֵ��޹���
	
	void cancelGood(String studentId, String createTime, String goodStudentId);//ȡ������
	
	String queryIsGood(String topicStudentId, String createTime, String goodStudentId);//��֤�Ƿ����
	
	void reply(String topicStudentId, String createTime, String reply, String commentStudentId, String studentName, String commentTime);//ʵ�����۹���
	
	List<Comment> getReply(String topicStudentId, String createTime);//���ݷ�����ѧ�ź����Ӵ���ʱ���ȡ����
	
	void deleteReply(String topicStudentId,String createTime,String commentStudentId,String commentTime);//ɾ������
	
	void deleteTopic(String topicStudentId, String createTime);//���ݷ�����ѧ�ź����Ӵ���ʱ��ɾ������
	
}
