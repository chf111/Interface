package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S19LEVEL2UPDATE;

@Repository
	public interface S19LEVEL2UPDATERepository extends BaseRepository<S19LEVEL2UPDATE> {

	//查询
	public List<S19LEVEL2UPDATE> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
