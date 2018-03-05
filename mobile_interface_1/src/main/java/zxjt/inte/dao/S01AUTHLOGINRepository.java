package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S01AUTHLOGIN;

@Repository
	public interface S01AUTHLOGINRepository extends BaseRepository<S01AUTHLOGIN> {

	//查询
	public List<S01AUTHLOGIN> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
