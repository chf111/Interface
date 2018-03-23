package zxjt.intfc.service.impl.common;

import java.util.List;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import zxjt.intfc.dao.common.StepReportRepository;
import zxjt.intfc.dao.common.TestReportRepository;
import zxjt.intfc.entity.common.StepReport;
import zxjt.intfc.entity.common.TestReport;
import zxjt.intfc.service.common.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Resource
	private TestReportRepository rep;
	@Resource
	private StepReportRepository step;

	/**
	 * 查询一次报告中，所有test模块的数据
	 */
	@Override
	public List<TestReport> getTestInfoByReporttimeAndFlg(String reporttime, String flg) {

		// TestReport t3=rep.findByTestId("1");
		// ObjectId oi = new ObjectId("5ab1f5150bf1e00716d81c39");
		// TestReport t = new TestReport(oi,"1","2","3","4","5","6","7","8","9");
		// TestReport t2 = rep.save(t);
		// System.out.println(t2.getId1());
		// System.out.println(t3.getId1());
		List<TestReport> listp = rep.findByReporttimeAndFlg(reporttime, flg);
		return listp;
	}

	/**
	 * 保存单个test模块的数据
	 */
	@Override
	public TestReport saveTestInfo(TestReport tp) {
		TestReport tpn = rep.save(tp);
		return tpn;
	}

	/**
	 * 查询一个test报告中，所有step模块的数据
	 */
	@Override
	public List<StepReport> getStepInfoByReporttimeAndFlg(ObjectId testId, String reporttime, String flg) {

		List<StepReport> listp = step.findByTestIdAndReporttimeAndFlg(testId, reporttime, flg);
		return listp;
	}

	/**
	 * 保存一个step模块的数据
	 */
	@Override
	public StepReport saveStepInfo(StepReport stp) {
		StepReport spn = step.save(stp);
		return spn;
	}
	
	/**
	 * 取得当前test模块的objid，作为对应的所有step的testid
	 */
//	@Override
//	public ObjectId findTestObjectid(String reporttime, String flg,String name){
//		TestReport tpid = rep.findByReporttimeAndFlgAndName(reporttime, flg, name);
//		ObjectId testId = tpid.getId();
//		return testId;
//	}
}
