package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B24HSGGTGSXW;

@Repository
	public interface B24HSGGTGSXWRepository extends BaseRepository<B24HSGGTGSXW> {

	//查询
	public List<B24HSGGTGSXW> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
