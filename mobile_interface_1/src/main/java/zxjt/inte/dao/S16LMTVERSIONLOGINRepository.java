package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S16LMTVERSIONLOGIN;

@Repository
	public interface S16LMTVERSIONLOGINRepository extends BaseRepository<S16LMTVERSIONLOGIN> {

	//查询
	public List<S16LMTVERSIONLOGIN> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
