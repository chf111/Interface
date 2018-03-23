package zxjt.intfc.common.bean;

import java.util.Map;

public class DPContainer {

	private static Map<String, Object> dpData;
	private static Map<String, Object> reportData;

	public static Map<String, Object> getDpData() {
		return dpData;
	}

	public static void setDpData(Map<String, Object> dpData) {
		DPContainer.dpData = dpData;
	}
	public static Map<String, Object> getReportData() {
		return reportData;
	}
	
	public static void setReportData(Map<String, Object> reportData) {
		DPContainer.reportData = reportData;
	}

}
