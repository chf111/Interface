package zxjt.inte.util;

import java.util.HashMap;
import java.util.Map;

public class BeforeClassUse {

	public static void setDPInfo(Object aService) {
		Map<String, Object> mapS = new HashMap<String, Object>();
		mapS.put(ParamConstant.SERVICE, aService);
		DPContainer.setDpData(mapS);
	}

	public static Object getDPInfo() {

		Map<String, Object> mapG = DPContainer.getDpData();
		Object aServiceG = mapG.get(ParamConstant.SERVICE);
		return aServiceG;
	}
}
