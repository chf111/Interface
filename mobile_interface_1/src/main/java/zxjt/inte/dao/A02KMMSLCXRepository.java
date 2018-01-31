package zxjt.inte.dao;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.A02KMMSLCX;

@Repository
	public interface A02KMMSLCXRepository extends BaseRepository<A02KMMSLCX> {

	//查询
	public A02KMMSLCX findOneByFunctionid(int functionid);	
}
