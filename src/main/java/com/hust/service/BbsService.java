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
	
	//发表新主题
	public void newTopic(Bbs bbs) {
		logger.info("发表新主题");
		bbsDao.newTopic(bbs);
	}
	
	//获取所有主题
	public List<Bbs> getTopicByUser(User user){
		logger.info("获取所有主题");
		return bbsDao.getTopicByUser(user);
	}
	
	//获取用户主题
	public List<Bbs> getOwnTopic(String studentId){
	    logger.info("获取用户主题");
	    return bbsDao.getOwnTopic(studentId);
	}
	
	//获取选中主题
	public Bbs queryBbsByIdAndTime(String studentId, String createTime){
	    logger.info("获取选中主题");
	    return bbsDao.queryBbsByIdAndTime(studentId, createTime);
	}
	
	//点赞功能
	public void good(String studentId, String createTime, String goodStudentId){
	    logger.info("点赞");
	    bbsDao.good(studentId, createTime, goodStudentId);
	}
	
	//取消点赞
	public void cancelGood(String studentId,String createTime,String goodStudentId) {
		logger.info("取消点赞");
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
