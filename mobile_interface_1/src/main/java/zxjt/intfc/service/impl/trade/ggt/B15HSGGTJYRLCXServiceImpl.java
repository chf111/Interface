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
import zxjt.intfc.dao.trade.ggt.B15HSGGTJYRLCXRepository;
import zxjt.intfc.entity.trade.ggt.B15HSGGTJYRLCX;
import zxjt.intfc.service.trade.ggt.B15HSGGTJYRLCXService;

@Service
public class B15HSGGTJYRLCXServiceImpl implements B15HSGGTJYRLCXService {

	@Autowired
	private B15HSGGTJYRLCXRepository hsggtDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {

		// 股票买卖数据操作
		List<B15HSGGTJYRLCX> lis = hsggtDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.HSGGT_JYRLCX_ID,"true");

		// 入参拼接
		List<Map<String, String>> lisTemp = CommonToolsUtil.getTestData(lis, addrDao, accoDao,ParamConstant.HSGGT_JYRLCX_ID);

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
		JsonAssertUtil.checkResponse(param, null, ParamConstant.B15_SCHEMA, ParamConstant.PTYW, response);
		Map<String,String> mapCheck = new HashMap<String,String>();
		mapCheck.put(ParamConstant.QSRQ, map.get("wlrq"));
		mapCheck.put(ParamConstant.ZZRQ, map.get(ParamConstant.ZZRQ));
		JsonAssertUtil.checkDateIsBetweenIn(response, ParamConstant.WLRQ, mapCheck);
	}
}
