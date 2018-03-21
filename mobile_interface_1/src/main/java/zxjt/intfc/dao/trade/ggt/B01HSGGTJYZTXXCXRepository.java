package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B01HSGGTJYZTXXCX;

@Repository
	public interface B01HSGGTJYZTXXCXRepository extends BaseRepository<B01HSGGTJYZTXXCX> {

	//查询
	public List<B01HSGGTJYZTXXCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
