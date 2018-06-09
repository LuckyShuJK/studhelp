package com.hust.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hust.entity.Memo;

@Repository
public interface MemoDao {
	
	void addMemo(Memo memo);//���뱸��¼
	
	List<Memo> queryMemoById(@Param("studentId") String studentId);//��ѯ����¼
	
	void updateMemo(Memo memo);//�༭����¼
	
	void deleteMemo(@Param("studentId") String studentId, @Param("createTime") String createTime);//ɾ������¼
	
	List<Memo> queryHomeMemoById(String studentId);//��ѯ��ҳ����¼
	
}
