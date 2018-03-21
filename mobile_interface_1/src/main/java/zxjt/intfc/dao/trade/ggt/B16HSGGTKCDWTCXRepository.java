package zxjt.intfc.dao.trade.ggt;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ggt.B16HSGGTKCDWTCX;

@Repository
	public interface B16HSGGTKCDWTCXRepository extends BaseRepository<B16HSGGTKCDWTCX> {

	//查询
	public List<B16HSGGTKCDWTCX> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
