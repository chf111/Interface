package zxjt.intfc.dao.quote;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.quote.W03GPPH;

@Repository
	public interface W03GPPHRepository extends BaseRepository<W03GPPH> {

	//查询
	public List<W03GPPH> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
