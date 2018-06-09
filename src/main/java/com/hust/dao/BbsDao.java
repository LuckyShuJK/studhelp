package com.hust.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hust.entity.User;
import com.hust.entity.Comment;
import com.hust.entity.Bbs;

@Repository
public interface BbsDao {
	
	void newTopic(Bbs bbs);//创建新的帖子
	
	List<Bbs> getTopicByUser(User user);//获取用户所在班级所有人的帖子
	
	List<Bbs> getOwnTopic(String studentId);//获取自己的帖子
	
	Bbs queryBbsByIdAndTime(String studentId, String createTime);//通过学号和创建时间查询帖子
	
	void good(String studentId, String createTime, String goodStudentId);//实现点赞功能
	
	void cancelGood(String studentId, String createTime, String goodStudentId);//取消点赞
	
	String queryIsGood(String topicStudentId, String createTime, String goodStudentId);//验证是否点赞
	
	void reply(String topicStudentId, String createTime, String reply, String commentStudentId, String studentName, String commentTime);//实现评论功能
	
	List<Comment> getReply(String topicStudentId, String createTime);//根据发帖人学号和帖子创建时间获取评论
	
	void deleteReply(String topicStudentId,String createTime,String commentStudentId,String commentTime);//删除评论
	
	void deleteTopic(String topicStudentId, String createTime);//根据发帖人学号和帖子创建时间删除帖子
	
}
