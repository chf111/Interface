package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.C00SZBJHGLSCJCX;

@Repository
	public interface C00SZBJHGLSCJCXRepository extends BaseRepository<C00SZBJHGLSCJCX> {

	//查询
	public List<C00SZBJHGLSCJCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
