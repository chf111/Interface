package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.S08HOTSEARCHService;
import zxjt.inte.util.BeforeClassUse;

//自己的类名
public class S08HOTSEARCHTest extends BaseController {

	// *自己的Service名称
	@Resource
	private S08HOTSEARCHService systemService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(systemService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void S08(Map<String, String> param) {

		systemService.test(param);
	}
}
