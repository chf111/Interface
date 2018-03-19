package zxjt.inte.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.B21HSGGTZQZHFJSCXRepository;
import zxjt.inte.entity.B21HSGGTZQZHFJSCX;
import zxjt.inte.service.B21HSGGTZQZHFJSCXService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class B21HSGGTZQZHFJSCXServiceImpl implements B21HSGGTZQZHFJSCXService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Autowired
	private B21HSGGTZQZHFJSCXRepository hsggtDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {

		// 股票买卖数据操作
		List<B21HSGGTZQZHFJSCX> lis = hsggtDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.HSGGT_ZQZHFJSCX_ID,
				"true");

		// 入参拼接
		List<Map<String, String>> lisTemp = CommonToolsUtil.getTestData(lis, addrDao, accoDao,
				ParamConstant.HSGGT_ZQZHFJSCX_ID);

		Object[][] obj = CommonToolsUtil.getTestObjArray(lisTemp);
		return obj;
	}

	/**
	 * 发送请求并校验返回结果
	 * 
	 * @param 入参
	 * @DependenceParam 依赖接口的入参
	 */
	public void test(Map<String, String> param) {

		Map<String, String> map = CommonToolsUtil.getRParam(param);
		CommonToolsUtil.getcxrqInfo(map);
		// 发请求
		System.out.println(param.toString());
		System.out.println(map.toString());

		log.info(param.toString());
		log.info(map.toString());

		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		System.out.println(response.toString());
		log.info(response.toString());

		Map<String, String> valMap = new HashMap<>();
		valMap.put("cxlb,[,zjzh", ParamConstant.REGEXBEGIN + map.get("khbz") + ParamConstant.REGEXEND);
		// 校验
		try {
			JsonAssertUtil.checkResponse(param, valMap, ParamConstant.B21_SCHEMA, ParamConstant.PTYW, response);
			// rep:qsrq between req:qsrq and req:zzrq
			JsonAssertUtil.checkDateIsBetweenIn(response, ParamConstant.QSRQ, map);
			// rep:jsrq = rep:qsrq+1
			JsonAssertUtil.checkDvalueOfDates(response, "jsrq", "qsrq", 1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
