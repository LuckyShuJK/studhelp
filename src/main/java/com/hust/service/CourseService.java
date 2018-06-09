package com.hust.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.entity.Coursetable;
import com.hust.dao.CoursetableDao;

@Service
public class CourseService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private CoursetableDao coursetableDao;
	
	//获取课程表
	public List<Coursetable> queryCoursetableById(String username){
	    logger.info("获取课程表");
	    return coursetableDao.queryCoursetableById(username);
	}
	
	//更新课程表
	public void upadteCoursetable(Coursetable coursetable){
	    logger.info("更新课程表");
	    coursetableDao.upadteCoursetable(coursetable);
	}
	
	public List<String> queryDaytableById(String studentId){
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.ENGLISH);
        Date date = new Date();
        String day = sdf.format(date).toLowerCase();
        logger.info("获取" + studentId + "-" + day + "课程表");
        return coursetableDao.queryDaytableById(day, studentId);
    }
	
	//注册账号课程表
	public void regester(String studentId){
	    logger.info("注册账号课程表");
	    coursetableDao.regester(studentId);
	}
	
}
