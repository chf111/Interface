package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.W02BKPH;

@Repository
	public interface W02BKPHRepository extends BaseRepository<W02BKPH> {

	//查询
	public List<W02BKPH> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
