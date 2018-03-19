package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B14HSGGTJGDCX;

@Repository
	public interface B14HSGGTJGDCXRepository extends BaseRepository<B14HSGGTJGDCX> {

	//查询
	public List<B14HSGGTJGDCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
