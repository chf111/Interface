package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B04HSGGTDRWTCX;

@Repository
	public interface B04HSGGTDRWTCXRepository extends BaseRepository<B04HSGGTDRWTCX> {

	//查询
	public List<B04HSGGTDRWTCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
