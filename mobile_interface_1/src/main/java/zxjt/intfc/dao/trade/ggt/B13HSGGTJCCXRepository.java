package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B13HSGGTJCCX;

@Repository
	public interface B13HSGGTJCCXRepository extends BaseRepository<B13HSGGTJCCX> {

	//查询
	public List<B13HSGGTJCCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
