package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S11TGZL;

@Repository
	public interface S11TGZLRepository extends BaseRepository<S11TGZL> {

	//查询
	public List<S11TGZL> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
