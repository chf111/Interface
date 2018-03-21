package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S03CUSTMGRQUERY;

@Repository
	public interface S03CUSTMGRQUERYRepository extends BaseRepository<S03CUSTMGRQUERY> {

	//查询
	public List<S03CUSTMGRQUERY> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
