package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S10GPLT;

@Repository
	public interface S10GPLTRepository extends BaseRepository<S10GPLT> {

	//查询
	public List<S10GPLT> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
