package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B18HSGGTWJSMXCX;

@Repository
	public interface B18HSGGTWJSMXCXRepository extends BaseRepository<B18HSGGTWJSMXCX> {

	//查询
	public List<B18HSGGTWJSMXCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
