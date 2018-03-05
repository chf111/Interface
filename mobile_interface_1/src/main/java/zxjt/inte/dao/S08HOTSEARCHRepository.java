package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S08HOTSEARCH;

@Repository
	public interface S08HOTSEARCHRepository extends BaseRepository<S08HOTSEARCH> {

	//查询
	public List<S08HOTSEARCH> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
