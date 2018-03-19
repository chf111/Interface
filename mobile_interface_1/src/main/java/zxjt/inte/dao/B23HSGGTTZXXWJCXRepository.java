package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B23HSGGTTZXXWJCX;

@Repository
	public interface B23HSGGTTZXXWJCXRepository extends BaseRepository<B23HSGGTTZXXWJCX> {

	//查询
	public List<B23HSGGTTZXXWJCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
