package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B00HSGGTCCCX;

@Repository
	public interface B00HSGGTCCCXRepository extends BaseRepository<B00HSGGTCCCX> {

	//查询
	public List<B00HSGGTCCCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
