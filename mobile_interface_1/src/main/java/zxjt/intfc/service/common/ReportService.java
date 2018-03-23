package zxjt.intfc.service.common;

import java.util.List;

import org.bson.types.ObjectId;

import zxjt.intfc.entity.common.StepReport;
import zxjt.intfc.entity.common.TestReport;

public interface ReportService{

	List<TestReport> getTestInfoByReporttimeAndFlg(String reporttime, String flg);

	TestReport saveTestInfo(TestReport tp);

	List<StepReport> getStepInfoByReporttimeAndFlg(ObjectId testId, String reporttime, String flg);

	StepReport saveStepInfo(StepReport stp);

//	ObjectId findTestObjectid(String reporttime, String flg, String name);
}
