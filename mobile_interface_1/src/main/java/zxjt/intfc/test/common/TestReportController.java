package zxjt.intfc.test.common;

import javax.annotation.Resource;

import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.DisableReportListener;
import zxjt.intfc.service.common.ReportService;

//自己的类名
@DisableReportListener
public class TestReportController extends BaseController {
	
	@Resource
	private ReportService tr;	

	@Test
	public void reportInit() {
		System.out.println("@@Test");
		BeforeClassUse.setReportInfo(tr);
	}
}
