package com.hust.entity;

public class Comment {
	
	private String topicStudentId;//帖子发布者的学号
	private String createTime;//帖子的创建时间
	private String commentStudentId;//评论者的学号
	private String commentTime;//评论时间
	private String studentName;//评论者的名字
	private String comment;//评论内容
	
	public String getTopicStudentId() {
		return topicStudentId;
	}
	public void setTopicStudentId(String topicStudentId) {
		this.topicStudentId = topicStudentId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCommentStudentId() {
		return commentStudentId;
	}
	public void setCommentStudentId(String commentStudentId) {
		this.commentStudentId = commentStudentId;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
		
}
