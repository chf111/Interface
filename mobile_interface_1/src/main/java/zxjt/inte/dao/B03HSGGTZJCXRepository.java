package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B03HSGGTZJCX;

@Repository
	public interface B03HSGGTZJCXRepository extends BaseRepository<B03HSGGTZJCX> {

	//查询
	public List<B03HSGGTZJCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
