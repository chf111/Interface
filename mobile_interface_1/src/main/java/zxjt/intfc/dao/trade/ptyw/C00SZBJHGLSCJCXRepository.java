package zxjt.intfc.dao.trade.ptyw;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ptyw.C00SZBJHGLSCJCX;

@Repository
	public interface C00SZBJHGLSCJCXRepository extends BaseRepository<C00SZBJHGLSCJCX> {

	//查询
	public List<C00SZBJHGLSCJCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
