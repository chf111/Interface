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
import zxjt.intfc.dao.trade.ggt.B19GGTZJCXRepository;
import zxjt.intfc.entity.trade.ggt.B19GGTZJCX;
import zxjt.intfc.service.trade.ggt.B19GGTZJCXService;

@Service
public class B19GGTZJCXServiceImpl implements B19GGTZJCXService {

	@Autowired
	private B19GGTZJCXRepository hsggtDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {

		// 股票买卖数据操作
		List<B19GGTZJCX> lis = hsggtDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.GGT_ZJCX_ID,"true");

		// 入参拼接
		List<Map<String, String>> lisTemp = CommonToolsUtil.getTestData(lis, addrDao, accoDao,ParamConstant.GGT_ZJCX_ID);

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
		map.put("khh", map.get("khbz"));//khh动态获取，与当前khbz相同
		// 发请求
		LogUtils.logInfo(param.toString());
		LogUtils.logInfo(map.toString());

		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		LogUtils.logInfo(response.toString());
		
		Map<String, String> valMap = new HashMap<>();
		valMap.put("zjlb,[,yybdm", ParamConstant.REGEXBEGIN + map.get("yybdm") + ParamConstant.REGEXEND);
		valMap.put("zjlb,[,zjzh", ParamConstant.REGEXBEGIN + map.get("khbz") + ParamConstant.REGEXEND);
		
		// 校验
		JsonAssertUtil.checkResponse(param, valMap, ParamConstant.B19_SCHEMA, ParamConstant.PTYW, response);
	}
}
