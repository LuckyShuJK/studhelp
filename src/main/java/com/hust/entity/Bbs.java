package com.hust.entity;

public class Bbs {
	
	private String studentId;//发布帖子的学生的学号
	private String studentName;//发布帖子的学生的名字
	private String title;//帖子的标题
	private String createTime;//帖子的发布时间
	private String detail;//帖子的内容
	private int good;//帖子的点赞数
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}

}
