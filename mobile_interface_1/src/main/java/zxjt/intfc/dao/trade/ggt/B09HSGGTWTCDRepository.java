package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B09HSGGTWTCD;

@Repository
	public interface B09HSGGTWTCDRepository extends BaseRepository<B09HSGGTWTCD> {

	//查询
	public List<B09HSGGTWTCD> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
