package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B20HSGGTZJZCCX;

@Repository
	public interface B20HSGGTZJZCCXRepository extends BaseRepository<B20HSGGTZJZCCX> {

	//查询
	public List<B20HSGGTZJZCCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
