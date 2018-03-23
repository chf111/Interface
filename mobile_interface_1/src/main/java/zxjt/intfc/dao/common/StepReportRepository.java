package zxjt.intfc.dao.common;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import zxjt.intfc.entity.common.StepReport;



@Repository
public interface StepReportRepository extends BaseRepository<StepReport> {

	// 查询
	public List<StepReport> findByTestIdAndReporttimeAndFlg(ObjectId testId,String reporttime,String flg);
	
//	public TestReport  save(TestReport entity);
}
