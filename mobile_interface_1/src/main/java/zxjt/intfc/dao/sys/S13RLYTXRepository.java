package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S13RLYTX;

@Repository
	public interface S13RLYTXRepository extends BaseRepository<S13RLYTX> {

	//查询
	public List<S13RLYTX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
