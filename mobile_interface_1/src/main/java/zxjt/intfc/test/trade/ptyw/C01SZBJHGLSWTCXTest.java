package zxjt.intfc.test.trade.ptyw;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.TestDataProvider;
import zxjt.intfc.service.trade.ptyw.C01SZBJHGLSWTCXService;
import zxjt.intfc.test.common.BaseController;

//自己的类名
public class C01SZBJHGLSWTCXTest extends BaseController {

	@Resource
	private C01SZBJHGLSWTCXService hsggtService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(hsggtService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void C01(Map<String, String> param) {

		hsggtService.test(param);
	}
}
