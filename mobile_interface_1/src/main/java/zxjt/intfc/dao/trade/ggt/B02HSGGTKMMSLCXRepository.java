package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B02HSGGTKMMSLCX;

@Repository
	public interface B02HSGGTKMMSLCXRepository extends BaseRepository<B02HSGGTKMMSLCX> {

	//查询
	public List<B02HSGGTKMMSLCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
	public B02HSGGTKMMSLCX findOneByFunctionid(int functionid);	
}
