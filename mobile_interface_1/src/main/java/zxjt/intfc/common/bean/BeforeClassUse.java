package zxjt.intfc.common.bean;

import java.util.HashMap;
import java.util.Map;

import zxjt.intfc.common.constant.ParamConstant;

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
	public static void setReportInfo(Object aService) {
		Map<String, Object> mapS = new HashMap<String, Object>();
		mapS.put(ParamConstant.REPORT_SERVICE, aService);
		DPContainer.setReportData(mapS);
	}
	
	public static Object getReportInfo() {
		
		Map<String, Object> mapG = DPContainer.getReportData();
		Object aServiceG = mapG.get(ParamConstant.REPORT_SERVICE);
		return aServiceG;
	}
}
