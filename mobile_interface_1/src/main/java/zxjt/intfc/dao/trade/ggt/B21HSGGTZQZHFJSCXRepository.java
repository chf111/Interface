package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B21HSGGTZQZHFJSCX;

@Repository
	public interface B21HSGGTZQZHFJSCXRepository extends BaseRepository<B21HSGGTZQZHFJSCX> {

	//查询
	public List<B21HSGGTZQZHFJSCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
