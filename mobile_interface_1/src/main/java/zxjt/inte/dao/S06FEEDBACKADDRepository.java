package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S06FEEDBACKADD;

@Repository
	public interface S06FEEDBACKADDRepository extends BaseRepository<S06FEEDBACKADD> {

	//查询
	public List<S06FEEDBACKADD> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
