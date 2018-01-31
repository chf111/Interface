package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B01HSGGTJYZTXXCX;

@Repository
	public interface B01HSGGTJYZTXXCXRepository extends BaseRepository<B01HSGGTJYZTXXCX> {

	//查询
	public List<B01HSGGTJYZTXXCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
