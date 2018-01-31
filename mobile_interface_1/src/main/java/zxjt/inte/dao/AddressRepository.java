package zxjt.inte.dao;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.CommonAddress;

@Repository
public interface AddressRepository extends BaseRepository<CommonAddress> {

	// 查询
	public CommonAddress findByFunctionid(int functionid);
}
