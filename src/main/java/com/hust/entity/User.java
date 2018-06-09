package com.hust.entity;

public class User {
	
	private String username;//用户名(学号)
    private String password;//密码
    private String name;//学生姓名  
    private String sex;//性别
    private String collage;//学院
    private String major;//专业
    private int grade;//年级
    private int classNo;//班级
    private int identity = 1;//身份
    private String phone;//电话
    private int isphonesecret;//电话是否保密
    private String email;//邮箱
    private int ismailsecret;//邮箱是否保密
    private String introduction;//自我介绍
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCollage() {
		return collage;
	}
	public void setCollage(String collage) {
		this.collage = collage;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getIsphonesecret() {
		return isphonesecret;
	}
	public void setIsphonesecret(int isphonesecret) {
		this.isphonesecret = isphonesecret;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsmailsecret() {
		return ismailsecret;
	}
	public void setIsmailsecret(int ismailsecret) {
		this.ismailsecret = ismailsecret;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
    
}
