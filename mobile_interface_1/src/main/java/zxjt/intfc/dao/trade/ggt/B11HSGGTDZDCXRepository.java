package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B11HSGGTDZDCX;

@Repository
	public interface B11HSGGTDZDCXRepository extends BaseRepository<B11HSGGTDZDCX> {

	//查询
	public List<B11HSGGTDZDCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
