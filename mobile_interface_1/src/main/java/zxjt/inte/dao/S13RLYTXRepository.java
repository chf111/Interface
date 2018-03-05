package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S13RLYTX;

@Repository
	public interface S13RLYTXRepository extends BaseRepository<S13RLYTX> {

	//查询
	public List<S13RLYTX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
