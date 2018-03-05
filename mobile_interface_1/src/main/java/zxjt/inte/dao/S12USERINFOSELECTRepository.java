package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S12USERINFOSELECT;

@Repository
	public interface S12USERINFOSELECTRepository extends BaseRepository<S12USERINFOSELECT> {

	//查询
	public List<S12USERINFOSELECT> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
