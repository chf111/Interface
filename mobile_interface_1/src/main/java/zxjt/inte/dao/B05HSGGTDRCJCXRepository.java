package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B05HSGGTDRCJCX;

@Repository
	public interface B05HSGGTDRCJCXRepository extends BaseRepository<B05HSGGTDRCJCX> {

	//查询
	public List<B05HSGGTDRCJCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
