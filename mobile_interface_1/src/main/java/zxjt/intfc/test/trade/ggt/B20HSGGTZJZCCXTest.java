package zxjt.intfc.test.trade.ggt;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.TestDataProvider;
import zxjt.intfc.service.trade.ggt.B20HSGGTZJZCCXService;
import zxjt.intfc.test.common.BaseController;

//自己的类名
public class B20HSGGTZJZCCXTest extends BaseController {

	@Resource
	private B20HSGGTZJZCCXService hsggtService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(hsggtService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B20(Map<String, String> param) {

		hsggtService.test(param);
	}
}
