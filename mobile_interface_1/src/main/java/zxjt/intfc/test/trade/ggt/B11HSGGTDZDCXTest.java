package zxjt.intfc.test.trade.ggt;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.TestDataProvider;
import zxjt.intfc.service.trade.ggt.B11HSGGTDZDCXService;
import zxjt.intfc.test.common.BaseController;

//自己的类名
public class B11HSGGTDZDCXTest extends BaseController {

	@Resource
	private B11HSGGTDZDCXService hsggtService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(hsggtService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B11(Map<String, String> param) {

		hsggtService.test(param);
	}
}
