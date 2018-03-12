package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S17GPZDF;

@Repository
	public interface S17GPZDFRepository extends BaseRepository<S17GPZDF> {

	//查询
	public List<S17GPZDF> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
