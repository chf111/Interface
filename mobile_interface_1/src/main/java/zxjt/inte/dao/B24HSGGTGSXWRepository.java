package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B24HSGGTGSXW;

@Repository
	public interface B24HSGGTGSXWRepository extends BaseRepository<B24HSGGTGSXW> {

	//查询
	public List<B24HSGGTGSXW> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
