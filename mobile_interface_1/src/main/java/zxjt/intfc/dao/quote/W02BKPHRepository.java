package zxjt.intfc.dao.quote;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.quote.W02BKPH;

@Repository
	public interface W02BKPHRepository extends BaseRepository<W02BKPH> {

	//查询
	public List<W02BKPH> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
