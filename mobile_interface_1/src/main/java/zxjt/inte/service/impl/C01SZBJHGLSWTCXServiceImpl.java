package zxjt.inte.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.C01SZBJHGLSWTCXRepository;
import zxjt.inte.entity.C01SZBJHGLSWTCX;
import zxjt.inte.service.C01SZBJHGLSWTCXService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class C01SZBJHGLSWTCXServiceImpl implements C01SZBJHGLSWTCXService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);

	@Autowired
	private C01SZBJHGLSWTCXRepository hsggtDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {

		// // 股票买卖数据操作
		List<C01SZBJHGLSWTCX> lis = hsggtDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.SZBJHG_LSWTCX_ID,
				"true");

		// 入参拼接
		List<Map<String, String>> lisTemp = CommonToolsUtil.getTestData(lis, addrDao, accoDao,
				ParamConstant.SZBJHG_LSWTCX_ID);

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

		// 发请求
		System.out.println(param.toString());
		System.out.println(map.toString());
		log.info(param.toString());
		log.info(map.toString());
		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		System.out.println(response.toString());
		log.info(response.toString());

		// 校验
		Map<String, String> valMap = new HashMap<>();
		if (ParamConstant.FL.equalsIgnoreCase(param.get(ParamConstant.TYPE))) {
			valMap.put(ParamConstant.CLJG_MESSAGE, JsonAssertUtil.getMsgRex(param.get(ParamConstant.EXPECTMSG)));
		}
		JsonAssertUtil.checkResponse(param, valMap, ParamConstant.C01_SCHEMA, ParamConstant.PTYW, response);
		if (ParamConstant.ZL.equalsIgnoreCase(param.get(ParamConstant.TYPE))) {
			JsonAssertUtil.checkDateIsBetweenIn(response, ParamConstant.WTRQ, param);
		}
	}
}
