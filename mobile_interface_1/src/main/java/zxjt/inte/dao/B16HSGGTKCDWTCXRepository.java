package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B16HSGGTKCDWTCX;

@Repository
	public interface B16HSGGTKCDWTCXRepository extends BaseRepository<B16HSGGTKCDWTCX> {

	//查询
	public List<B16HSGGTKCDWTCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
