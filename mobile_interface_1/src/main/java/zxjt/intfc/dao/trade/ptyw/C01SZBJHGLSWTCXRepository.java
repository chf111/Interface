package zxjt.intfc.dao.trade.ptyw;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ptyw.C01SZBJHGLSWTCX;

@Repository
	public interface C01SZBJHGLSWTCXRepository extends BaseRepository<C01SZBJHGLSWTCX> {

	//查询
	public List<C01SZBJHGLSWTCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
