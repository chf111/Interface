package zxjt.inte.dao;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.A03SJKMMSLCX;

@Repository
	public interface A03SJKMMSLCXRepository extends BaseRepository<A03SJKMMSLCX> {

	//查询
	public A03SJKMMSLCX findOneByFunctionid(int functionid);	
}
