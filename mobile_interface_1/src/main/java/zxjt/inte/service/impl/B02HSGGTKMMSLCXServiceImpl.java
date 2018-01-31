package zxjt.inte.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.B02HSGGTKMMSLCXRepository;
import zxjt.inte.entity.B02HSGGTKMMSLCX;
import zxjt.inte.service.B02HSGGTKMMSLCXService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class B02HSGGTKMMSLCXServiceImpl implements B02HSGGTKMMSLCXService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Autowired
	private B02HSGGTKMMSLCXRepository hsggtDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {

		// 股票买卖数据操作
		List<B02HSGGTKMMSLCX> lis = hsggtDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.HSGGT_KMMSLCX_ID,
				"true");

		// 入参拼接
		List<Map<String, String>> lisTemp = CommonToolsUtil.getTestData(lis, addrDao, accoDao,
				ParamConstant.HSGGT_KMMSLCX_ID);

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
		kmmslcxTest(param);
	}

	/**
	 * 作为被依赖接口返回响应值
	 * 
	 * @param 入参
	 * @DependenceParam 依赖接口的入参
	 */
	public String dependentDest(Map<String, String> param) {
		String response = kmmslcxTest(param);
		return response;
	}

	private String kmmslcxTest(Map<String, String> param) {

		Map<String, String> map = CommonToolsUtil.getRParam(param);

		// 发请求
		System.out.println(param.toString());
		System.out.println(map.toString());
		log.info(param.toString());
		log.info(map.toString());
		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		System.out.println(response.toString());
		log.info(response.toString());

		// 拼接
		Map<String, String> valMap = new HashMap<>();
		valMap.put(ParamConstant.KMMXX_JYSDM,
				ParamConstant.REGEXBEGIN + param.get(ParamConstant.JYSDM) + ParamConstant.REGEXEND);
		valMap.put(ParamConstant.KMMXX_ZQDM,
				ParamConstant.REGEXBEGIN + param.get(ParamConstant.ZQDM) + ParamConstant.REGEXEND);
		if (ParamConstant.SGT.equals(param.get(ParamConstant.WTLX))) {
			valMap.put(ParamConstant.KMMXX_KMSL, ParamConstant.KMSL_S);
		} else {
			valMap.put(ParamConstant.KMMXX_KMSL, ParamConstant.KMSL_H);
		}
		// 校验
		JsonAssertUtil.checkResponse(param, valMap, ParamConstant.B02_SCHEMA, ParamConstant.PTYW, response);
		return response;
	}
}
