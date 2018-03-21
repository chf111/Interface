package zxjt.intfc.dao.common;

import org.springframework.stereotype.Repository;

import zxjt.intfc.entity.common.CommonAddress;



@Repository
public interface AddressRepository extends BaseRepository<CommonAddress> {

	// 查询
	public CommonAddress findByFunctionid(int functionid);
}
