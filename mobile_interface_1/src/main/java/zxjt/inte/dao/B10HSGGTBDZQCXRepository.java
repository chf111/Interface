package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B10HSGGTBDZQCX;

@Repository
	public interface B10HSGGTBDZQCXRepository extends BaseRepository<B10HSGGTBDZQCX> {

	//查询
	public List<B10HSGGTBDZQCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
