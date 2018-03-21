package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S18LEVEL2JUDGE;

@Repository
	public interface S18LEVEL2JUDGERepository extends BaseRepository<S18LEVEL2JUDGE> {

	//查询
	public List<S18LEVEL2JUDGE> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
