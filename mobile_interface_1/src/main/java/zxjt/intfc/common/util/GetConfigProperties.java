package zxjt.intfc.common.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * 根据用户需求，获取config文件并将内容读出来
 * 
 * @author Administrator
 *
 */
public class GetConfigProperties {

	public static Map<String, String> getConfigProToCommon() {
		Map<String, String> commonDataMap = new HashMap<>();
		Properties prop = new Properties();
		try {
			// 读取属性文件config.properties
			InputStream in = new BufferedInputStream(new FileInputStream("config.properties"));
			prop.load(in); /// 加载属性列表

			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				System.out.print(key + "          ");
				String value = prop.getProperty(key);
				System.out.println(value);
				commonDataMap.put(key, value);
			}
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return commonDataMap;
	}
}
