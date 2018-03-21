package zxjt.intfc.test.trade.ggt;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.testng.TestDataProvider;
import zxjt.intfc.service.trade.ggt.B02HSGGTKMMSLCXService;
import zxjt.intfc.service.trade.ggt.B08HSGGTWTXDService;
import zxjt.intfc.test.common.BaseController;

//自己的类名
public class B08HSGGTWTXDTest extends BaseController {

	// *自己的Service名称
	@Resource
	private B08HSGGTWTXDService wtxdService;
	
	@Resource
	private B02HSGGTKMMSLCXService kmmslcxService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(wtxdService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B08(Map<String, String> param,Map<String, String> tempKmmsl) {

		wtxdService.test(param,tempKmmsl,kmmslcxService);
	}
}
