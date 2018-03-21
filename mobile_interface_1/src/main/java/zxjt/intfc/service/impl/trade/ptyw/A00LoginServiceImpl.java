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
import zxjt.intfc.dao.trade.ptyw.A00LoginRepository;
import zxjt.intfc.entity.trade.ptyw.A00Login;
import zxjt.intfc.service.trade.ptyw.A00LoginService;

@Service
public class A00LoginServiceImpl implements A00LoginService {

	@Autowired
	private A00LoginRepository loginDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {

		// // 股票买卖数据操作
		List<A00Login> lis = loginDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.PTJYLOGIN_ID, "true");

		// 入参拼接
		List<Map<String, String>> lisTemp = CommonToolsUtil.getTestData2(lis, addrDao, accoDao,
				ParamConstant.PTJYLOGIN_ID);

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

		// 拼接
		Map<String, String> valMap = new HashMap<>();
		if (ParamConstant.ZL.equalsIgnoreCase(param.get(ParamConstant.TYPE))) {

			valMap.put(ParamConstant.CLJG_MESSAGE, JsonAssertUtil.getMsgRex(param.get(ParamConstant.EXPECTMSG)));
			valMap.put("dlxx,[,zjzh",ParamConstant.REGEXBEGIN +param.get("khbz")+ ParamConstant.REGEXEND);
			valMap.put("dlxx,[,yybdm",ParamConstant.REGEXBEGIN +param.get("yybdm")+ ParamConstant.REGEXEND);
			valMap.put("dlxx,[,xtrq",ParamConstant.REGEXBEGIN + CommonToolsUtil.getToday("yyyyMMdd") + ParamConstant.REGEXEND);
			valMap.put("dlxx,[,wtrq",ParamConstant.REGEXBEGIN + CommonToolsUtil.getToday("yyyyMMdd") + ParamConstant.REGEXEND);
		} else {
			String codeAndMsg = param.get(ParamConstant.EXPECTMSG);
			String[] strArr = codeAndMsg.split(",");
			valMap.put(ParamConstant.CLJG_MESSAGE, JsonAssertUtil.getMsgRex(strArr[0]));
			
			// 如果能分解，证明code值是变化的，数据库中以逗号分隔开，格式为“msg,code”
			if (strArr.length == 2) {
				valMap.put(ParamConstant.CLJG_CODE, JsonAssertUtil.getMsgRex(strArr[1]));
			}
		}

		// 校验
		JsonAssertUtil.checkResponse(param, valMap, ParamConstant.A00_SCHEMA, ParamConstant.PTYW, response);
	}
}
