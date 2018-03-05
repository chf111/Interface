package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S11TGZL;

@Repository
	public interface S11TGZLRepository extends BaseRepository<S11TGZL> {

	//查询
	public List<S11TGZL> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
