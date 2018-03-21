package zxjt.intfc.service.trade.ggt;

import java.util.Map;

public interface B02HSGGTKMMSLCXService{

	Object[][] getParamsInfo();
	void test(Map<String, String> param);
	String dependentDest(Map<String, String> param);
}
