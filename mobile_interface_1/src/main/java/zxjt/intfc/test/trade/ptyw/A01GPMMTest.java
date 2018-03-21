package zxjt.intfc.test.trade.ptyw;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.TestDataProvider;
import zxjt.intfc.service.trade.ptyw.A01GPMMService;
import zxjt.intfc.test.common.BaseController;

//自己的类名
public class A01GPMMTest extends BaseController {

	// *自己的Service名称
	@Resource
	private A01GPMMService gpmmService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(gpmmService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void A01(Map<String, String> param, Map<String, String> DependenceParam) {

		gpmmService.test(param, DependenceParam);
	}
}
