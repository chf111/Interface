package zxjt.intfc.dao.quote;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.quote.W00HQZXGHQ;

@Repository
	public interface W00HQZXGHQRepository extends BaseRepository<W00HQZXGHQ> {

	//查询
	public List<W00HQZXGHQ> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
