package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.W04BKPHIndex;

@Repository
	public interface W04BKPHIndexRepository extends BaseRepository<W04BKPHIndex> {

	//查询
	public List<W04BKPHIndex> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
