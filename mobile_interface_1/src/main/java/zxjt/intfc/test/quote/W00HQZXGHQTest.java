package zxjt.intfc.test.quote;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.TestDataProvider;
import zxjt.intfc.service.quote.W00HQZXGHQService;
import zxjt.intfc.test.common.BaseController;

/**
 * // http://ip:port/api/quote/pb_selected 自选股
 * @author Administrator
 *
 */
public class W00HQZXGHQTest extends BaseController {

	// *自己的Service名称
	@Resource
	private W00HQZXGHQService zxgService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(zxgService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void W00(Map<String, String> param) {

		zxgService.test(param);
	}
}