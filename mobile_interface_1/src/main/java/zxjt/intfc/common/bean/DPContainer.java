package zxjt.intfc.common.bean;

import java.util.Map;

public class DPContainer {

	private static Map<String, Object> dpData;

	public static Map<String, Object> getDpData() {
		return dpData;
	}

	public static void setDpData(Map<String, Object> dpData) {
		DPContainer.dpData = dpData;
	}

}
