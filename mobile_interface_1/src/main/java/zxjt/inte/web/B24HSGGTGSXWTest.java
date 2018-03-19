package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.B24HSGGTGSXWService;
import zxjt.inte.util.BeforeClassUse;

//自己的类名
public class B24HSGGTGSXWTest extends BaseController {

	@Resource
	private B24HSGGTGSXWService hsggtService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(hsggtService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B24(Map<String, String> param) {

		hsggtService.test(param);
	}
}
