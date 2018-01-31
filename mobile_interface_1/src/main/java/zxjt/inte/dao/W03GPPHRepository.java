package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.W03GPPH;

@Repository
	public interface W03GPPHRepository extends BaseRepository<W03GPPH> {

	//查询
	public List<W03GPPH> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
