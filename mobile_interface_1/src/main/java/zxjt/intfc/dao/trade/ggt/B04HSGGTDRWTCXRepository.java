package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B04HSGGTDRWTCX;

@Repository
	public interface B04HSGGTDRWTCXRepository extends BaseRepository<B04HSGGTDRWTCX> {

	//查询
	public List<B04HSGGTDRWTCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
