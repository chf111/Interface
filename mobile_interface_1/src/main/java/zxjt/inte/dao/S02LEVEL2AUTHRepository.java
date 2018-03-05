package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S02LEVEL2AUTH;

@Repository
	public interface S02LEVEL2AUTHRepository extends BaseRepository<S02LEVEL2AUTH> {

	//查询
	public List<S02LEVEL2AUTH> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
