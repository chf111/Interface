package zxjt.intfc.dao.trade.ptyw;

import java.util.List;

import org.springframework.stereotype.Repository;

import zxjt.intfc.dao.common.BaseRepository;
import zxjt.intfc.entity.trade.ptyw.A00Login;

//@Repository("A00LoginRepository")
@Repository
	public interface A00LoginRepository extends BaseRepository<A00Login> {

	//查询
	public List<A00Login> findByFunctionidAndIsExcuteIgnoreCase(int functionid,String isExcute);	
}
