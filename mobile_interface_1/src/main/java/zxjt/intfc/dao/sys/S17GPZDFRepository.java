package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S17GPZDF;

@Repository
	public interface S17GPZDFRepository extends BaseRepository<S17GPZDF> {

	//查询
	public List<S17GPZDF> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
