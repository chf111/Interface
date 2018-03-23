package zxjt.intfc.dao.common;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import zxjt.intfc.entity.common.TestReport;



@Repository
public interface TestReportRepository extends BaseRepository<TestReport> {

	// 查询
	public TestReport findByReporttimeAndFlgAndName(String reporttime,String flg,String name);
//	public TestReport findIdByFlg(String flg);

	public List<TestReport> findByReporttimeAndFlg(String reporttime, String flg);
	
//	public TestReport  save(TestReport entity);
}
