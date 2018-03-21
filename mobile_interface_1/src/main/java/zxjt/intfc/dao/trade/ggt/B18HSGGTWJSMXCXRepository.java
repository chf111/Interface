package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B18HSGGTWJSMXCX;

@Repository
	public interface B18HSGGTWJSMXCXRepository extends BaseRepository<B18HSGGTWJSMXCX> {

	//查询
	public List<B18HSGGTWJSMXCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
