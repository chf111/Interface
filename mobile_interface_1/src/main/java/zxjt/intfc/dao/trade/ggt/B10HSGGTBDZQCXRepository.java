package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B10HSGGTBDZQCX;

@Repository
	public interface B10HSGGTBDZQCXRepository extends BaseRepository<B10HSGGTBDZQCX> {

	//查询
	public List<B10HSGGTBDZQCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
