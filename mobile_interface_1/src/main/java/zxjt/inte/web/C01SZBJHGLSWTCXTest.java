package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.C01SZBJHGLSWTCXService;
import zxjt.inte.util.BeforeClassUse;

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
