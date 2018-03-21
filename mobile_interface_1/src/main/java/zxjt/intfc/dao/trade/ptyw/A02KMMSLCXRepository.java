package zxjt.intfc.dao.trade.ptyw;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ptyw.A02KMMSLCX;

@Repository
	public interface A02KMMSLCXRepository extends BaseRepository<A02KMMSLCX> {

	//查询
	public A02KMMSLCX findOneByFunctionid(int functionid);	
}
