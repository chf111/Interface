package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.W01DML;

@Repository
	public interface W01DMLRepository extends BaseRepository<W01DML> {

	//查询
	public List<W01DML> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
