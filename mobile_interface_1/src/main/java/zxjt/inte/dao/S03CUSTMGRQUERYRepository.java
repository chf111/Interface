package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S03CUSTMGRQUERY;

@Repository
	public interface S03CUSTMGRQUERYRepository extends BaseRepository<S03CUSTMGRQUERY> {

	//查询
	public List<S03CUSTMGRQUERY> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
