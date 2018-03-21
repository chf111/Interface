package zxjt.intfc.service.trade.ggt;

import java.util.Map;

public interface B08HSGGTWTXDService{

	Object[][] getParamsInfo();
	void test(Map<String, String> param,Map<String, String> tempKmmsl,B02HSGGTKMMSLCXService kmmslcxService);
}
