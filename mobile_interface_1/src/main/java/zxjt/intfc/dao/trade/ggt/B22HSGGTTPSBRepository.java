package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B22HSGGTTPSB;

@Repository
	public interface B22HSGGTTPSBRepository extends BaseRepository<B22HSGGTTPSB> {

	//查询
	public List<B22HSGGTTPSB> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
