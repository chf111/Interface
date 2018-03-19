package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B22HSGGTTPSB;

@Repository
	public interface B22HSGGTTPSBRepository extends BaseRepository<B22HSGGTTPSB> {

	//查询
	public List<B22HSGGTTPSB> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
