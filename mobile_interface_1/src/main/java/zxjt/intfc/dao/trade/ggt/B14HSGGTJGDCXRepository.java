package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B14HSGGTJGDCX;

@Repository
	public interface B14HSGGTJGDCXRepository extends BaseRepository<B14HSGGTJGDCX> {

	//查询
	public List<B14HSGGTJGDCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
