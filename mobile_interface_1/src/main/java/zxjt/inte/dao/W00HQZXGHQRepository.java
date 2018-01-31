package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.W00HQZXGHQ;

@Repository
	public interface W00HQZXGHQRepository extends BaseRepository<W00HQZXGHQ> {

	//查询
	public List<W00HQZXGHQ> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
