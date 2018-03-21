package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B15HSGGTJYRLCX;

@Repository
	public interface B15HSGGTJYRLCXRepository extends BaseRepository<B15HSGGTJYRLCX> {

	//查询
	public List<B15HSGGTJYRLCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
