package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B20HSGGTZJZCCX;

@Repository
	public interface B20HSGGTZJZCCXRepository extends BaseRepository<B20HSGGTZJZCCX> {

	//查询
	public List<B20HSGGTZJZCCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
