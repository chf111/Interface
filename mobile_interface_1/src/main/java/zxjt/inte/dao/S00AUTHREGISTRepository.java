package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S00AUTHREGIST;

@Repository
	public interface S00AUTHREGISTRepository extends BaseRepository<S00AUTHREGIST> {

	//查询
	public List<S00AUTHREGIST> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
