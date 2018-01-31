package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.A01GPMM;

@Repository
	public interface A01GPMMRepository extends BaseRepository<A01GPMM> {

	//查询
	public List<A01GPMM> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
