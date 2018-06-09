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
	
	//��ӱ���¼
    public void addMemo(Memo memo){
        logger.info("��ӱ���¼");
        memoDao.addMemo(memo);
    }
    
    //��ȡ����¼
    public List<Memo> queryMemoById(String studentId){
        logger.info("��ȡ����¼");
        return memoDao.queryMemoById(studentId);
    }
    
    //���±���¼
    public void updateMemo(Memo memo){
        logger.info("���±���¼");;
        memoDao.updateMemo(memo);
    }
    
    //ɾ������¼
    public void deleteMemo(String studentId,String createTime){
        logger.info("ɾ������¼");
        memoDao.deleteMemo(studentId, createTime);
    }
    
    //��ȡ��ҳ����¼
    public List<Memo> queryHomeMemoById(String studentId){
        logger.info("��ȡ��ҳ����¼");
        return memoDao.queryHomeMemoById(studentId);
    }
	
}
