package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S04FAVORSELECT;

@Repository
	public interface S04FAVORSELECTRepository extends BaseRepository<S04FAVORSELECT> {

	//查询
	public List<S04FAVORSELECT> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
