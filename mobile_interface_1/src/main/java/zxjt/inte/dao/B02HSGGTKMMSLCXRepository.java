package zxjt.inte.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.B02HSGGTKMMSLCX;

@Repository
	public interface B02HSGGTKMMSLCXRepository extends BaseRepository<B02HSGGTKMMSLCX> {

	//查询
	public List<B02HSGGTKMMSLCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
	public B02HSGGTKMMSLCX findOneByFunctionid(int functionid);	
}
