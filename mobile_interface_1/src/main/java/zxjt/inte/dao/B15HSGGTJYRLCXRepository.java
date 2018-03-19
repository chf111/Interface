package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B15HSGGTJYRLCX;

@Repository
	public interface B15HSGGTJYRLCXRepository extends BaseRepository<B15HSGGTJYRLCX> {

	//查询
	public List<B15HSGGTJYRLCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
