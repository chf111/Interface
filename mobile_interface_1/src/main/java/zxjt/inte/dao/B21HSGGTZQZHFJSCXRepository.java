package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B21HSGGTZQZHFJSCX;

@Repository
	public interface B21HSGGTZQZHFJSCXRepository extends BaseRepository<B21HSGGTZQZHFJSCX> {

	//查询
	public List<B21HSGGTZQZHFJSCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
