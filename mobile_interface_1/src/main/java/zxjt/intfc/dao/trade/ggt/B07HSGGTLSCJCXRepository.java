package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B07HSGGTLSCJCX;

@Repository
	public interface B07HSGGTLSCJCXRepository extends BaseRepository<B07HSGGTLSCJCX> {

	//查询
	public List<B07HSGGTLSCJCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
