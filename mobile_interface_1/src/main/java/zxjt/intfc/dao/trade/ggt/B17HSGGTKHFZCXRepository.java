package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B17HSGGTKHFZCX;

@Repository
	public interface B17HSGGTKHFZCXRepository extends BaseRepository<B17HSGGTKHFZCX> {

	//查询
	public List<B17HSGGTKHFZCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
