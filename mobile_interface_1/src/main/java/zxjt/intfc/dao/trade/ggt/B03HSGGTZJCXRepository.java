package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B03HSGGTZJCX;

@Repository
	public interface B03HSGGTZJCXRepository extends BaseRepository<B03HSGGTZJCX> {

	//查询
	public List<B03HSGGTZJCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
