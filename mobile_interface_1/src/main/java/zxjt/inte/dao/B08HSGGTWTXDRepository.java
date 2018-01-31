package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B08HSGGTWTXD;

@Repository
	public interface B08HSGGTWTXDRepository extends BaseRepository<B08HSGGTWTXD> {

	//查询
	public List<B08HSGGTWTXD> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
