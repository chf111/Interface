package zxjt.inte.dao;

import org.springframework.stereotype.Repository;

import zxjt.inte.entity.CommonAccount;

@Repository
public interface AccountRepository extends BaseRepository<CommonAccount> {

	// 查询
	public CommonAccount findByKhbz(String khbz);
}
