package zxjt.intfc.dao.trade.ptyw;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ptyw.A01GPMM;

@Repository
	public interface A01GPMMRepository extends BaseRepository<A01GPMM> {

	//查询
	public List<A01GPMM> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
