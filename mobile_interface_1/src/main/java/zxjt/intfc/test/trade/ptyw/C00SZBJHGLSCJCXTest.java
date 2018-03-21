package zxjt.intfc.test.trade.ptyw;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.TestDataProvider;
import zxjt.intfc.service.trade.ptyw.C00SZBJHGLSCJCXService;
import zxjt.intfc.test.common.BaseController;

//自己的类名
public class C00SZBJHGLSCJCXTest extends BaseController {

	@Resource
	private C00SZBJHGLSCJCXService hsggtService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(hsggtService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void C00(Map<String, String> param) {

		hsggtService.test(param);
	}
}
