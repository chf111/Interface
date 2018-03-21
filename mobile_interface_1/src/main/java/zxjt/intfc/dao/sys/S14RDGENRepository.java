package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S14RDGEN;

@Repository
	public interface S14RDGENRepository extends BaseRepository<S14RDGEN> {

	//查询
	public List<S14RDGEN> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
