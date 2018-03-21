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
import zxjt.intfc.dao.trade.ggt.B02HSGGTKMMSLCXRepository;
import zxjt.intfc.entity.trade.ggt.B02HSGGTKMMSLCX;
import zxjt.intfc.service.trade.ggt.B02HSGGTKMMSLCXService;

@Service
public class B02HSGGTKMMSLCXServiceImpl implements B02HSGGTKMMSLCXService {

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
		LogUtils.logInfo(param.toString());
		LogUtils.logInfo(map.toString());
		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		LogUtils.logInfo(response.toString());

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
