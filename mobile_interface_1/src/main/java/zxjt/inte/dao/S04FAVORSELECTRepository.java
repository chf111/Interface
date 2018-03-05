package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S04FAVORSELECT;

@Repository
	public interface S04FAVORSELECTRepository extends BaseRepository<S04FAVORSELECT> {

	//查询
	public List<S04FAVORSELECT> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
