package zxjt.intfc.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.sys.S09CNXH;

@Repository
	public interface S09CNXHRepository extends BaseRepository<S09CNXH> {

	//查询
	public List<S09CNXH> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
