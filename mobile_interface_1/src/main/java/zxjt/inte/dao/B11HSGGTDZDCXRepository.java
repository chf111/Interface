package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B11HSGGTDZDCX;

@Repository
	public interface B11HSGGTDZDCXRepository extends BaseRepository<B11HSGGTDZDCX> {

	//查询
	public List<B11HSGGTDZDCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
