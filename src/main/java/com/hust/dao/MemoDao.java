package com.hust.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hust.entity.Memo;

@Repository
public interface MemoDao {
	
	void addMemo(Memo memo);//插入备忘录
	
	List<Memo> queryMemoById(@Param("studentId") String studentId);//查询备忘录
	
	void updateMemo(Memo memo);//编辑备忘录
	
	void deleteMemo(@Param("studentId") String studentId, @Param("createTime") String createTime);//删除备忘录
	
	List<Memo> queryHomeMemoById(String studentId);//查询首页备忘录
	
}
