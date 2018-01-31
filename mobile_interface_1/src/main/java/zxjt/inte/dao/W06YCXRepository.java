package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.W06YCX;

@Repository
	public interface W06YCXRepository extends BaseRepository<W06YCX> {

	//查询
	public List<W06YCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
