package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B12HSGGTHLCX;

@Repository
	public interface B12HSGGTHLCXRepository extends BaseRepository<B12HSGGTHLCX> {

	//查询
	public List<B12HSGGTHLCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
