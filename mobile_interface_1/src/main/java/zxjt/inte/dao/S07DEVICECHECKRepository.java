package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.S07DEVICECHECK;

@Repository
	public interface S07DEVICECHECKRepository extends BaseRepository<S07DEVICECHECK> {

	//查询
	public List<S07DEVICECHECK> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
