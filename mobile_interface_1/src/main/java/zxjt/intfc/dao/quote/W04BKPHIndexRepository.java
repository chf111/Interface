package zxjt.intfc.dao.quote;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.quote.W04BKPHIndex;

@Repository
	public interface W04BKPHIndexRepository extends BaseRepository<W04BKPHIndex> {

	//查询
	public List<W04BKPHIndex> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
