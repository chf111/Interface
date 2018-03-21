package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S15RDVERIFY;

@Repository
	public interface S15RDVERIFYRepository extends BaseRepository<S15RDVERIFY> {

	//查询
	public List<S15RDVERIFY> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
