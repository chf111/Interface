package zxjt.intfc.dao.quote;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.quote.W05GGZH;

@Repository
	public interface W05GGZHRepository extends BaseRepository<W05GGZH> {

	//查询
	public List<W05GGZH> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
