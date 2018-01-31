package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B07HSGGTLSCJCX;

@Repository
	public interface B07HSGGTLSCJCXRepository extends BaseRepository<B07HSGGTLSCJCX> {

	//查询
	public List<B07HSGGTLSCJCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
