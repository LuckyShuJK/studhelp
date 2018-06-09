package com.hust.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.entity.Memo;
import com.hust.dao.MemoDao;

@Service
public class MemoService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private MemoDao memoDao;
	
	//添加备忘录
    public void addMemo(Memo memo){
        logger.info("添加备忘录");
        memoDao.addMemo(memo);
    }
    
    //获取备忘录
    public List<Memo> queryMemoById(String studentId){
        logger.info("获取备忘录");
        return memoDao.queryMemoById(studentId);
    }
    
    //更新备忘录
    public void updateMemo(Memo memo){
        logger.info("更新备忘录");;
        memoDao.updateMemo(memo);
    }
    
    //删除备忘录
    public void deleteMemo(String studentId,String createTime){
        logger.info("删除备忘录");
        memoDao.deleteMemo(studentId, createTime);
    }
    
    //获取首页备忘录
    public List<Memo> queryHomeMemoById(String studentId){
        logger.info("获取首页备忘录");
        return memoDao.queryHomeMemoById(studentId);
    }
	
}
