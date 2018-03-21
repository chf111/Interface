package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S08HOTSEARCH;

@Repository
	public interface S08HOTSEARCHRepository extends BaseRepository<S08HOTSEARCH> {

	//查询
	public List<S08HOTSEARCH> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
