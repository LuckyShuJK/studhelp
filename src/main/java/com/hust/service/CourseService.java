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
	
	//��ȡ�γ̱�
	public List<Coursetable> queryCoursetableById(String username){
	    logger.info("��ȡ�γ̱�");
	    return coursetableDao.queryCoursetableById(username);
	}
	
	//���¿γ̱�
	public void upadteCoursetable(Coursetable coursetable){
	    logger.info("���¿γ̱�");
	    coursetableDao.upadteCoursetable(coursetable);
	}
	
	public List<String> queryDaytableById(String studentId){
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.ENGLISH);
        Date date = new Date();
        String day = sdf.format(date).toLowerCase();
        logger.info("��ȡ" + studentId + "-" + day + "�γ̱�");
        return coursetableDao.queryDaytableById(day, studentId);
    }
	
	//ע���˺ſγ̱�
	public void regester(String studentId){
	    logger.info("ע���˺ſγ̱�");
	    coursetableDao.regester(studentId);
	}
	
}
