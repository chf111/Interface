package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S12USERINFOSELECT;

@Repository
	public interface S12USERINFOSELECTRepository extends BaseRepository<S12USERINFOSELECT> {

	//查询
	public List<S12USERINFOSELECT> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
