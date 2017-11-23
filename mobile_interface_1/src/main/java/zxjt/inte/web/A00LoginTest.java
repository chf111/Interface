package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.A00LoginService;
import zxjt.inte.util.BeforeClassUse;

//自己的类名
public class A00LoginTest extends BaseController {

	// *自己的Service名称
	@Resource
	private A00LoginService loginService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(loginService);
	}

	// *自己的controller和别名
	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)

	// *自己的方法名
	public void A00LoginZL(Map<String, String> param) {

		// 发请求
		loginService.test(param);
	}
}
