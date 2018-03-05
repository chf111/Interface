package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S05FAVORUPDATE;

@Repository
	public interface S05FAVORUPDATERepository extends BaseRepository<S05FAVORUPDATE> {

	//查询
	public List<S05FAVORUPDATE> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
