package zxjt.intfc.dao.common;

import org.springframework.stereotype.Repository;

import zxjt.intfc.entity.common.CommonAccount;


@Repository
public interface AccountRepository extends BaseRepository<CommonAccount> {

	// 查询
	public CommonAccount findByKhbz(String khbz);
}
