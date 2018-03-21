package zxjt.intfc.test.trade.ggt;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.TestDataProvider;
import zxjt.intfc.service.trade.ggt.B06HSGGTLSWTCXService;
import zxjt.intfc.test.common.BaseController;

//自己的类名
public class B06HSGGTLSWTCXTest extends BaseController {

	// *自己的Service名称
	@Resource
	private B06HSGGTLSWTCXService hsggtService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(hsggtService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B06(Map<String, String> param) {

		hsggtService.test(param);
	}
}
