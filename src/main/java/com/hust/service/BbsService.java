package com.hust.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.entity.Comment;
import com.hust.dao.BbsDao;
import com.hust.entity.Bbs;
import com.hust.entity.User;

@Service
public class BbsService {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private BbsDao bbsDao;
	
	//����������
	public void newTopic(Bbs bbs) {
		logger.info("����������");
		bbsDao.newTopic(bbs);
	}
	
	//��ȡ��������
	public List<Bbs> getTopicByUser(User user){
		logger.info("��ȡ��������");
		return bbsDao.getTopicByUser(user);
	}
	
	//��ȡ�û�����
	public List<Bbs> getOwnTopic(String studentId){
	    logger.info("��ȡ�û�����");
	    return bbsDao.getOwnTopic(studentId);
	}
	
	//��ȡѡ������
	public Bbs queryBbsByIdAndTime(String studentId, String createTime){
	    logger.info("��ȡѡ������");
	    return bbsDao.queryBbsByIdAndTime(studentId, createTime);
	}
	
	//���޹���
	public void good(String studentId, String createTime, String goodStudentId){
	    logger.info("����");
	    bbsDao.good(studentId, createTime, goodStudentId);
	}
	
	//ȡ������
	public void cancelGood(String studentId,String createTime,String goodStudentId) {
		logger.info("ȡ������");
		bbsDao.cancelGood(studentId,createTime,goodStudentId);
	}
	
	public String queryIsGood(String topicStudentId, String createTime, String goodStudentId){
        return bbsDao.queryIsGood(topicStudentId, createTime, goodStudentId);
    }
	
	public void reply(String topicStudentId, String createTime, String reply, String commentStudentId, String studentName, String commentTime){
        bbsDao.reply(topicStudentId, createTime, reply, commentStudentId, studentName, commentTime);
    }
	
	public List<Comment> getReply(String topicStudentId, String createTime){
        return bbsDao.getReply(topicStudentId, createTime);
    }
	
	public void deleteReply(String topicStudentId,String createTime,String commentStudentId,String commentTime) {
		bbsDao.deleteReply(topicStudentId,createTime,commentStudentId, commentTime);
	}
	
	public void deleteTopic(String topicStudentId, String createTime){
        bbsDao.deleteTopic(topicStudentId, createTime);
    }
	
}
