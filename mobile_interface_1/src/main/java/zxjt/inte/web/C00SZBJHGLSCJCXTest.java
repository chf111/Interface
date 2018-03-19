package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.C00SZBJHGLSCJCXService;
import zxjt.inte.util.BeforeClassUse;

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
