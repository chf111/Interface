package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B08HSGGTWTXD;

@Repository
	public interface B08HSGGTWTXDRepository extends BaseRepository<B08HSGGTWTXD> {

	//查询
	public List<B08HSGGTWTXD> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
