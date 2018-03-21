package zxjt.intfc.dao.trade.ptyw;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ptyw.A03SJKMMSLCX;

@Repository
	public interface A03SJKMMSLCXRepository extends BaseRepository<A03SJKMMSLCX> {

	//查询
	public A03SJKMMSLCX findOneByFunctionid(int functionid);	
}
