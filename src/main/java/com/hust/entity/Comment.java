package com.hust.entity;

public class Comment {
	
	private String topicStudentId;//���ӷ����ߵ�ѧ��
	private String createTime;//���ӵĴ���ʱ��
	private String commentStudentId;//�����ߵ�ѧ��
	private String commentTime;//����ʱ��
	private String studentName;//�����ߵ�����
	private String comment;//��������
	
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
