package zxjt.intfc.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

import zxjt.intfc.common.constant.ParamConstant;
import zxjt.intfc.dao.common.AccountRepository;
import zxjt.intfc.dao.common.AddressRepository;
import zxjt.intfc.entity.common.CommonAccount;
import zxjt.intfc.entity.common.CommonAddress;

public class CommonToolsUtil {

	/**
	 * 去除入参数据中包含的非传入数据，例如“测试点”、“类型”等等
	 * 
	 * @param param
	 * @return
	 */
	public static Map<String, String> getRParam(Map<String, String> param) {
		Map<String, String> RParam = new HashMap<>();
		RParam.putAll(param);
		RParam.remove("id");
		RParam.remove("isExcute");
		RParam.remove("type");
		RParam.remove("expectMsg");
		RParam.remove("testPoint");
		RParam.remove("url");
		RParam.remove("row");
		RParam.remove("functionid");
		RParam.remove(ParamConstant.SAFEURL);
		RParam.remove(ParamConstant.UNSAFEURL);
		return RParam;
	}

	/**
	 * 获取帐号相关信息，并以map存储返回
	 * 
	 * @param accoEntity
	 *            帐号entity
	 * @return
	 */
	private static Map<String, String> getAccountMap(CommonAccount accoEntity) {
		Map<String, String> map = new HashMap<String, String>();

		Field[] fEntity = accoEntity.getClass().getDeclaredFields();
		for (Field f : fEntity) {
			f.setAccessible(true);
			try {
				if ("id".equals(f.getName()) || f.getName().contains(ParamConstant.GDDM)) {
					continue;
				}
				map.put(f.getName(), String.valueOf(f.get(accoEntity)));
			} catch (IllegalArgumentException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return map;
	}

	private static Map<String, String> getAccountMap2(zxjt.intfc.entity.common.CommonAccount accoEntity) {
		Map<String, String> map = new HashMap<String, String>();

		Field[] fEntity = accoEntity.getClass().getDeclaredFields();
		for (Field f : fEntity) {
			f.setAccessible(true);
			try {
				if ("id".equals(f.getName()) || f.getName().contains(ParamConstant.GDDM)) {
					continue;
				}
				map.put(f.getName(), String.valueOf(f.get(accoEntity)));
			} catch (IllegalArgumentException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return map;
	}

	/**
	 * entity转成map
	 * 
	 * @param obj
	 * @return
	 */
	private static Map<String, String> entity2Map(Object obj) {
		Map<String, String> map = new HashMap<String, String>();

		Field[] fEntity = obj.getClass().getDeclaredFields();
		for (Field f : fEntity) {
			f.setAccessible(true);
			try {
				map.put(f.getName(), String.valueOf(f.get(obj)));
			} catch (IllegalArgumentException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return map;
	}

	/**
	 * 返回测试数据
	 * 
	 * @param lisTestEntity
	 * @param addrDao
	 * @param accoDao
	 * @param functionid
	 * @return
	 */
	public static List<Map<String, String>> getTestData(Object lisTestEntity, AddressRepository addrDao,
			AccountRepository accoDao, int functionid) {

		// 公共参数操作
		Map<String, String> commonData = GetConfigProperties.getConfigProToCommon();

		// url获取
		CommonAddress addrEntity = addrDao.findByFunctionid(functionid);

		// 账户信息获取
		CommonAccount accoEntity = accoDao.findByKhbz(commonData.get(ParamConstant.KHBZ));
		Map<String, String> accountMap = getAccountMap(accoEntity);

		List<Map<String, String>> lisTemp = new ArrayList<>();

		try {
			// 测试数据操作

			List<Object> lisEntity = (List<Object>) lisTestEntity;

			for (Object entity : lisEntity) {
				Map<String, String> testDataMap = new HashMap<String, String>();
				testDataMap.putAll(accountMap);
				Field[] fEntity = entity.getClass().getDeclaredFields();

				for (Field f : fEntity) {
					f.setAccessible(true);

					System.out.println(f.getName() + ":" + f.get(entity));

					// 处理股东代码，读取config文件的值进行入参拼接,股东代码无值的情况下，数据库的value为空即可，有值则要按照指定规则去填充value
					if (f.getName().equalsIgnoreCase(ParamConstant.GDDM) && !"".equals(String.valueOf(f.get(entity)))) {
						String methodName = "get" + toUpperCase4Index(String.valueOf(f.get(entity)));
						Method mGddm = accoEntity.getClass().getDeclaredMethod(methodName);
						String strGddm = (String) mGddm.invoke(accoEntity);
						testDataMap.put(f.getName(), strGddm);
						continue;
					}
					if (!"null".equals(String.valueOf(f.get(entity)))) {// null则代表数据库中不存在这个字段
						testDataMap.put(f.getName(), String.valueOf(f.get(entity)));
					}

				}

				String url = commonData.get(ParamConstant.SAFEURL) + addrEntity.getUrl();
				testDataMap.put(ParamConstant.URL, url);
				lisTemp.add(testDataMap);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return lisTemp;
	}

	/**
	 * 返回测试数据
	 * 
	 * @param lisTestEntity
	 * @param addrDao
	 * @param accoDao
	 * @param functionid
	 * @return
	 */
	public static List<Map<String, String>> getTestData2(Object lisTestEntity,
			zxjt.intfc.dao.common.AddressRepository addrDao, zxjt.intfc.dao.common.AccountRepository accoDao,
			int functionid) {

		// 公共参数操作
		Map<String, String> commonData = GetConfigProperties.getConfigProToCommon();

		// url获取
		zxjt.intfc.entity.common.CommonAddress addrEntity = addrDao.findByFunctionid(functionid);

		// 账户信息获取
		zxjt.intfc.entity.common.CommonAccount accoEntity = accoDao.findByKhbz(commonData.get(ParamConstant.KHBZ));
		Map<String, String> accountMap = getAccountMap2(accoEntity);

		List<Map<String, String>> lisTemp = new ArrayList<>();

		try {
			// 测试数据操作

			List<Object> lisEntity = (List<Object>) lisTestEntity;

			for (Object entity : lisEntity) {
				Map<String, String> testDataMap = new HashMap<String, String>();
				testDataMap.putAll(accountMap);
				Field[] fEntity = entity.getClass().getDeclaredFields();

				for (Field f : fEntity) {
					f.setAccessible(true);

					System.out.println(f.getName() + ":" + f.get(entity));

					// 处理股东代码，读取config文件的值进行入参拼接,股东代码无值的情况下，数据库的value为空即可，有值则要按照指定规则去填充value
					if (f.getName().equalsIgnoreCase(ParamConstant.GDDM) && !"".equals(String.valueOf(f.get(entity)))) {
						String methodName = "get" + toUpperCase4Index(String.valueOf(f.get(entity)));
						Method mGddm = accoEntity.getClass().getDeclaredMethod(methodName);
						String strGddm = (String) mGddm.invoke(accoEntity);
						testDataMap.put(f.getName(), strGddm);
						continue;
					}
					if (!"null".equals(String.valueOf(f.get(entity)))) {// null则代表数据库中不存在这个字段
						testDataMap.put(f.getName(), String.valueOf(f.get(entity)));
					}

				}

				String url = commonData.get(ParamConstant.SAFEURL) + addrEntity.getUrl();
				testDataMap.put(ParamConstant.URL, url);
				lisTemp.add(testDataMap);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return lisTemp;
	}

	/**
	 * 返回被依赖接口入参的map
	 * 
	 * @param testEntity
	 * @param addrDao
	 * @param accoDao
	 * @param functionid
	 * @return
	 */
	public static Map<String, String> getDepenTestData(Object testEntity, AddressRepository addrDao,
			AccountRepository accoDao, int functionid) {

		// 公共参数操作
		Map<String, String> commonData = GetConfigProperties.getConfigProToCommon();

		// url获取
		CommonAddress addrEntity = addrDao.findByFunctionid(functionid);

		// 账户信息获取
		CommonAccount accoEntity = accoDao.findByKhbz(commonData.get(ParamConstant.KHBZ));
		Map<String, String> accountMap = getAccountMap(accoEntity);

		Map<String, String> testDataMap = new HashMap<String, String>();
		try {
			// 测试数据操作
			Object entity = (Object) testEntity;

			testDataMap.putAll(accountMap);
			Field[] fEntity = entity.getClass().getDeclaredFields();

			for (Field f : fEntity) {
				f.setAccessible(true);

				System.out.println(f.getName() + ":" + f.get(entity));
				;
				testDataMap.put(f.getName(), String.valueOf(f.get(entity)));

			}

			String url = commonData.get(ParamConstant.SAFEURL) + addrEntity.getUrl();
			testDataMap.put(ParamConstant.URL, url);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return testDataMap;
	}

	public static Object[][] getTestObjArray(List<Map<String, String>> lisTemp) {
		Object[][] obj = new Object[lisTemp.size()][1];
		for (int j = 0; j < obj.length; j++) {

			obj[j][0] = lisTemp.get(j);
		}
		return obj;
	}

	public static Object[][] getDepenTestObjArray(String flg, List<Map<String, String>> lisTemp,
			Map<String, String>... mapDepen) {
		Object[][] obj = new Object[lisTemp.size()][2];
		switch (flg) {
		case ParamConstant.GPMM:
			for (int j = 0; j < obj.length; j++) {

				obj[j][0] = lisTemp.get(j);
				if ("0".equals(lisTemp.get(j).get(ParamConstant.WTLX))) {

					obj[j][1] = mapDepen[0];

				} else {
					obj[j][1] = mapDepen[1];
				}
			}
			// 将依赖接口的测试数据放到map中存起来
			break;
		default:
			for (int j = 0; j < obj.length; j++) {

				obj[j][0] = lisTemp.get(j);
				obj[j][1] = mapDepen[0];
			}
			break;
		}
		return obj;
	}

	/**
	 * 不需要帐号密码，url是http的
	 * 
	 * @param objlisEntity
	 * @return
	 */
	public static Object[][] getWWData(Object lisWWEntity, AddressRepository addrDao, AccountRepository accoDao,
			int functionid) {
		// 公共参数操作
		Map<String, String> commonData = GetConfigProperties.getConfigProToCommon();

		// url获取
		CommonAddress addrEntity = addrDao.findByFunctionid(functionid);

		List<Map<String, String>> lisTemp = new ArrayList<>();

		List<Object> lisEntity = (List<Object>) lisWWEntity;
		for (Object entity : lisEntity) {
			Map<String, String> testDataMap = new HashMap<String, String>();
			Field[] fEntity = entity.getClass().getDeclaredFields();
			for (Field f : fEntity) {
				f.setAccessible(true);
				try {
					System.out.println(f.getName() + ":" + f.get(entity));
					testDataMap.put(f.getName(), String.valueOf(f.get(entity)));
				} catch (IllegalArgumentException e) {

					e.printStackTrace();
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {

					e.printStackTrace();
					throw new RuntimeException(e);
				}

			}
			String url = commonData.get(ParamConstant.UNSAFEURL) + addrEntity.getUrl();
			testDataMap.put("url", url);
			lisTemp.add(testDataMap);

		}

		Object[][] obj = new Object[lisTemp.size()][1];
		for (int j = 0; j < obj.length; j++) {

			obj[j][0] = lisTemp.get(j);
		}
		return obj;
	}

	/**
	 * 不需要帐号密码,url是https的
	 * 
	 * @param objlisEntity
	 * @return
	 */
	public static Object[][] getSafeWWData(Object lisWWEntity, AddressRepository addrDao, AccountRepository accoDao,
			int functionid) {
		// 公共参数操作
		Map<String, String> commonData = GetConfigProperties.getConfigProToCommon();

		// url获取
		CommonAddress addrEntity = addrDao.findByFunctionid(functionid);

		List<Map<String, String>> lisTemp = new ArrayList<>();

		List<Object> lisEntity = (List<Object>) lisWWEntity;
		for (Object entity : lisEntity) {
			Map<String, String> testDataMap = new HashMap<String, String>();
			Field[] fEntity = entity.getClass().getDeclaredFields();
			for (Field f : fEntity) {
				f.setAccessible(true);
				try {
					System.out.println(f.getName() + ":" + f.get(entity));
					testDataMap.put(f.getName(), String.valueOf(f.get(entity)));
				} catch (IllegalArgumentException e) {

					e.printStackTrace();
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {

					e.printStackTrace();
					throw new RuntimeException(e);
				}

			}
			String url = commonData.get(ParamConstant.SAFEURL) + addrEntity.getUrl();
			testDataMap.put("url", url);
			lisTemp.add(testDataMap);

		}

		Object[][] obj = new Object[lisTemp.size()][1];
		for (int j = 0; j < obj.length; j++) {

			obj[j][0] = lisTemp.get(j);
		}
		return obj;
	}

	public static String getPrice(String pricetype, String response) {

		String wtjg = "";
		try {
			switch (pricetype) {
			case "{PRICE}":
			case "市价":
				wtjg = String.valueOf(JsonPath.read(response, "$.kmmxx[0].jrkpj", new Predicate[0]));
				break;
			case "{LOW}":
				String dtjg = (String) JsonPath.read(response, "$.kmmxx[0].dtjg", new Predicate[0]);
				if ("".equals(dtjg) || null == dtjg) {
					throw new RuntimeException("查询接口返回字段异常：dtjg字段为空值");
				}
				wtjg = String.format("%.2f", Double.valueOf(dtjg) - 0.1);
				break;
			case "{HIGH}":
				String ztjg = (String) JsonPath.read(response, "$.kmmxx[0].ztjg", new Predicate[0]);
				if ("".equals(ztjg) || null == ztjg) {
					throw new RuntimeException("查询接口返回字段异常：ztjg字段为空值");
				}
				wtjg = String.format("%.2f", Double.valueOf(ztjg) + 0.1);
				break;
			case "{latestDealPrice}":
				String jg = (String) JsonPath.read(response, "$.kmmxx[0].wtjg", new Predicate[0]);
				if ("".equals(jg) || null == jg) {
					throw new RuntimeException("查询接口返回字段异常：wtjg字段为空值");
				}
				wtjg = String.format("%.2f", Double.valueOf(jg));
				break;
			case "{DealConfirmPrice}":
				String DealConfirmPrice = (String) JsonPath.read(response, "$.htxx[0].wtjg", new Predicate[0]);
				if ("".equals(DealConfirmPrice) || null == DealConfirmPrice) {
					throw new RuntimeException("查询接口返回字段异常：htxx[0].wtjg字段为空值");
				}
				wtjg = String.format("%.2f", Double.valueOf(DealConfirmPrice));
				break;
			case "{NULL}":
				wtjg = "";
				break;
			default:
				wtjg = pricetype;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return wtjg;

	}

	/**
	 * 获取查询接口的最大可买数量，赋值给下单接口报文中
	 * 
	 * @param 获取的买卖类别
	 * @param 获取的数量的类型
	 * @param 从接口返回的数据的被查找的字符串
	 * @return 返回修改好的价格
	 */
	public static String getOverBSQty(String mmlb, String qtytype, String CXRespose) {
		String actualqty = "";
		String qtyflag = "";
		if ("B".equals(mmlb)) {
			qtyflag = "$.kmmxx[0].kmsl";
		}
		if ("S".equals(mmlb)) {
			qtyflag = "$.kmmxx[0].gfkys";
		}
		switch (qtytype) {
		case "{OverBSQty}":
			try {
				actualqty = String.valueOf(
						Integer.parseInt((String) JsonPath.read(CXRespose, qtyflag, new Predicate[0])) / 1000 * 1000
								+ 1000);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());// 123456
			}
			break;
		default:
			actualqty = qtytype;
		}
		return actualqty;
	}

	public static String getToday(String format) {

		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat(format);
		String today = sd.format(date);
		return today;
	}

	public static Date changeStringToDate(String strDate, String format) {

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		return date;
	}

	/**
	 * 获取查询日期信息
	 * 
	 * @param param
	 *            下单发送的json转换的map
	 * @return 返回修改好入参的下单报文map
	 */
	public static void getcxrqInfo(Map<String, String> param) {
		Calendar cal = Calendar.getInstance();
		Date dateNow = cal.getTime();
		if ((param.get(ParamConstant.QSRQ).contains(ParamConstant.TODAY))
				|| (param.get(ParamConstant.ZZRQ).contains(ParamConstant.TODAY))) {

		} else if ((param.get(ParamConstant.QSRQ).contains(ParamConstant.ONEMONTH))
				|| (param.get(ParamConstant.ZZRQ).contains(ParamConstant.ONEMONTH))) {
			cal.add(Calendar.DAY_OF_YEAR, -1);
			dateNow = cal.getTime();
			cal.add(Calendar.MONTH, -1);

		} else if ((param.get(ParamConstant.QSRQ).contains(ParamConstant.THREEMONTH))
				|| (param.get(ParamConstant.ZZRQ).contains(ParamConstant.THREEMONTH))) {
			cal.add(Calendar.MONTH, -3);
		} else {
			return;
		}
		Date dateKS = cal.getTime();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateKsrq = df.format(dateKS);
		String dateZzrq = df.format(dateNow);
		param.put(ParamConstant.QSRQ, dateKsrq);
		param.put(ParamConstant.ZZRQ, dateZzrq);
	}

	/**
	 * 返回数量值
	 * 
	 * @param mrdw
	 *            买入单位（如果查询结果中不存在该字段，则传每手股最小单位即可，股票100，基金1000）
	 * @param num
	 *            买卖上限加情况下的计算基础值
	 * @param parWtsl
	 *            数量类型
	 * @param plus
	 *            可买卖上限加的数值 ETF-10000 ；LOF-10000；开放式基金-1000
	 * @return 网下现金认购信息查询接口返回结果
	 */
	public static String getWtsl(String mrdw, String num, String parWtsl, int plus) {
		int iMrdw = Math.round(Float.valueOf(mrdw));
		int iWtsl = 0;

		// 不同场合下处理方式
		if ("1倍".equals(parWtsl)) {
			iWtsl = iMrdw;
		} else if ("可买卖上限加".equals(parWtsl)) {
			iWtsl = Math.round(Float.valueOf(num)) / iMrdw * iMrdw + plus;

		} else if ("不是整数倍".equals(parWtsl)) {
			iWtsl = iMrdw + 1;
		} else {
			String pattern = "([0-9]+|[0-9]+\\.[0-9]+)";
			Pattern p = Pattern.compile(pattern);
			Matcher matcher = p.matcher(parWtsl);
			if (matcher.matches()) {
				iWtsl = Math.round(Float.valueOf(parWtsl));
			} else {
				throw new RuntimeException("数据库中委托数量有误");
			}
		}
		return String.valueOf(iWtsl);
	}

	private static String toUpperCase4Index(String string) {
		char[] mWord = string.toCharArray();
		mWord[0] -= (mWord[0] > 96 && mWord[0] < 123) ? 32 : 0;
		return String.valueOf(mWord);
	}
}
