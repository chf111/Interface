package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B09HSGGTWTCD;

@Repository
	public interface B09HSGGTWTCDRepository extends BaseRepository<B09HSGGTWTCD> {

	//查询
	public List<B09HSGGTWTCD> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
