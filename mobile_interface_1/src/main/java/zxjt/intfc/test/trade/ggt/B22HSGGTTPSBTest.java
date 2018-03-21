package zxjt.intfc.test.trade.ggt;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.TestDataProvider;
import zxjt.intfc.service.trade.ggt.B22HSGGTTPSBService;
import zxjt.intfc.test.common.BaseController;

//自己的类名
public class B22HSGGTTPSBTest extends BaseController {

	@Resource
	private B22HSGGTTPSBService hsggtService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(hsggtService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B22(Map<String, String> param) {

		hsggtService.test(param);
	}
}
