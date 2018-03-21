package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B19GGTZJCX;

@Repository
	public interface B19GGTZJCXRepository extends BaseRepository<B19GGTZJCX> {

	//查询
	public List<B19GGTZJCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
