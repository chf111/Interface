package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.C01SZBJHGLSWTCX;

@Repository
	public interface C01SZBJHGLSWTCXRepository extends BaseRepository<C01SZBJHGLSWTCX> {

	//查询
	public List<C01SZBJHGLSWTCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
