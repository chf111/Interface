package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S10GPLT;

@Repository
	public interface S10GPLTRepository extends BaseRepository<S10GPLT> {

	//查询
	public List<S10GPLT> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
