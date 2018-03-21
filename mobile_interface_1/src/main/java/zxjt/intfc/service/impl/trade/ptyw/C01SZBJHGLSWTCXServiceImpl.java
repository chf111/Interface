package zxjt.intfc.service.impl.trade.ptyw;

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
import zxjt.intfc.dao.trade.ptyw.C01SZBJHGLSWTCXRepository;
import zxjt.intfc.entity.trade.ptyw.C01SZBJHGLSWTCX;
import zxjt.intfc.service.trade.ptyw.C01SZBJHGLSWTCXService;

@Service
public class C01SZBJHGLSWTCXServiceImpl implements C01SZBJHGLSWTCXService {

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
		LogUtils.logInfo(param.toString());
		LogUtils.logInfo(map.toString());
		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		LogUtils.logInfo(response.toString());

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
