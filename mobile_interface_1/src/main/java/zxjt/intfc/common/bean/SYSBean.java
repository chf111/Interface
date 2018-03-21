package zxjt.intfc.common.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SYSBean {
	
	// 存储合同单号用以撤单或查询等功能使用
	private static Map<Object, Object> sysData = new HashMap<>();

	public static String getSysData(String key) {
		return (String) sysData.get(key);

	}

	/*
	 * 仅需要操作合同序号进行撤单的
	 */
	public static void putSysData(String key, String value) {
		sysData.put(key, value);

	}

	public static Set<Object> ConkeySet() {
		Set<Object> conKeySet = sysData.keySet();
		return conKeySet;
	}

	public static void removeKey(String key) {
		sysData.remove(key);
	}

	/*
	 * 需要操作多个参数进行撤单的
	 */
	public static void putMap(String key, Map<String, String> param) {
		sysData.put(key, param);

	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> getMap(String key) {
		return (Map<String, String>) sysData.get(key);

	}
}
