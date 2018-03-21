package zxjt.intfc.test.sys;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.TestDataProvider;
import zxjt.intfc.service.sys.S09CNXHService;
import zxjt.intfc.test.common.BaseController;

//自己的类名
public class S09CNXHTest extends BaseController {

	// *自己的Service名称
	@Resource
	private S09CNXHService systemService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(systemService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void S09(Map<String, String> param) {

		systemService.test(param);
	}
}
