package zxjt.intfc.test.trade.ggt;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.TestDataProvider;
import zxjt.intfc.service.trade.ggt.B12HSGGTHLCXService;
import zxjt.intfc.test.common.BaseController;

//自己的类名
public class B12HSGGTHLCXTest extends BaseController {

	@Resource
	private B12HSGGTHLCXService hsggtService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(hsggtService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B12(Map<String, String> param) {

		hsggtService.test(param);
	}
}
