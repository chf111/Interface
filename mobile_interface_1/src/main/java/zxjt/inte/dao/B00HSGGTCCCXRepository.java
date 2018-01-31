package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B00HSGGTCCCX;

@Repository
	public interface B00HSGGTCCCXRepository extends BaseRepository<B00HSGGTCCCX> {

	//查询
	public List<B00HSGGTCCCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
