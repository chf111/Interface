package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.B13HSGGTJCCXService;
import zxjt.inte.util.BeforeClassUse;

//自己的类名
public class B13HSGGTJCCXTest extends BaseController {

	@Resource
	private B13HSGGTJCCXService hsggtService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(hsggtService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B13(Map<String, String> param) {

		hsggtService.test(param);
	}
}
