package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B23HSGGTTZXXWJCX;

@Repository
	public interface B23HSGGTTZXXWJCXRepository extends BaseRepository<B23HSGGTTZXXWJCX> {

	//查询
	public List<B23HSGGTTZXXWJCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
