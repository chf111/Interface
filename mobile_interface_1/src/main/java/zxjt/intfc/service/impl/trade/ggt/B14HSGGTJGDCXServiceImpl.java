package zxjt.intfc.service.impl.trade.ggt;

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
import zxjt.intfc.dao.trade.ggt.B14HSGGTJGDCXRepository;
import zxjt.intfc.entity.trade.ggt.B14HSGGTJGDCX;
import zxjt.intfc.service.trade.ggt.B14HSGGTJGDCXService;

@Service
public class B14HSGGTJGDCXServiceImpl implements B14HSGGTJGDCXService {

	@Autowired
	private B14HSGGTJGDCXRepository hsggtDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {

		// 股票买卖数据操作
		List<B14HSGGTJGDCX> lis = hsggtDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.HSGGT_JGDCX_ID,"true");

		// 入参拼接
		List<Map<String, String>> lisTemp = CommonToolsUtil.getTestData(lis, addrDao, accoDao,ParamConstant.HSGGT_JGDCX_ID);

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
		JsonAssertUtil.checkResponse(param, null, ParamConstant.B14_SCHEMA, ParamConstant.PTYW, response);
		JsonAssertUtil.checkDateIsBetweenIn(response, ParamConstant.JSRQ, map);
	}
}
