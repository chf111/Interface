package zxjt.intfc.service.impl.trade.ggt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.intfc.common.constant.ParamConstant;
import zxjt.intfc.common.util.CommonToolsUtil;
import zxjt.intfc.common.util.HttpUtil_All;
import zxjt.intfc.common.util.JsonAssertUtil;
import zxjt.intfc.common.util.LogUtils;
import zxjt.intfc.dao.common.AccountRepository;
import zxjt.intfc.dao.common.AddressRepository;
import zxjt.intfc.dao.trade.ggt.B21HSGGTZQZHFJSCXRepository;
import zxjt.intfc.entity.trade.ggt.B21HSGGTZQZHFJSCX;
import zxjt.intfc.service.trade.ggt.B21HSGGTZQZHFJSCXService;

@Service
public class B21HSGGTZQZHFJSCXServiceImpl implements B21HSGGTZQZHFJSCXService {

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
		LogUtils.logInfo(param.toString());
		LogUtils.logInfo(map.toString());

		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		LogUtils.logInfo(response.toString());

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
