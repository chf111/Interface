package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B06HSGGTLSWTCX;

@Repository
	public interface B06HSGGTLSWTCXRepository extends BaseRepository<B06HSGGTLSWTCX> {

	//查询
	public List<B06HSGGTLSWTCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
