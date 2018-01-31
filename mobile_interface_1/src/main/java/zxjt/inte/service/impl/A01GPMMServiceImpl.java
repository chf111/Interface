package zxjt.inte.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.A01GPMMRepository;
import zxjt.inte.dao.A02KMMSLCXRepository;
import zxjt.inte.dao.A03SJKMMSLCXRepository;
import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.entity.A01GPMM;
import zxjt.inte.entity.A02KMMSLCX;
import zxjt.inte.entity.A03SJKMMSLCX;
import zxjt.inte.service.A01GPMMService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class A01GPMMServiceImpl implements A01GPMMService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	
	@Autowired
	private A01GPMMRepository gpmmDao;
	@Autowired
	private A02KMMSLCXRepository xjkmmDao;
	@Autowired
	private A03SJKMMSLCXRepository sjkmmDao;
	@Autowired
	private AddressRepository addrDao;
	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {

		// 股票买卖数据操作
		List<A01GPMM> lis = gpmmDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.GPMM_ID, "true");

		// 限价可买卖信息查询数据操作
		A02KMMSLCX kmmslEntity = xjkmmDao.findOneByFunctionid(ParamConstant.KMMXXCX_ID);

		// 市价可买卖信息查询数据操作
		A03SJKMMSLCX sjkmmslEntity = sjkmmDao.findOneByFunctionid(ParamConstant.SJKMMXXCX_ID);

		List<Map<String, String>> lisTemp = CommonToolsUtil.getTestData(lis, addrDao, accoDao, ParamConstant.GPMM_ID);
		Map<String, String> mapxjkmm = CommonToolsUtil.getDepenTestData(kmmslEntity, addrDao, accoDao,
				ParamConstant.KMMXXCX_ID);
		Map<String, String> mapsjkmm = CommonToolsUtil.getDepenTestData(sjkmmslEntity, addrDao, accoDao,
				ParamConstant.SJKMMXXCX_ID);
		Object[][] obj = CommonToolsUtil.getDepenTestObjArray(ParamConstant.GPMM, lisTemp, mapxjkmm, mapsjkmm);

		return obj;
	}

	/**
	 * 发送请求并校验返回结果
	 * 
	 * @param 入参
	 * @DependenceParam 依赖接口的入参
	 */
	public void test(Map<String, String> param, Map<String, String> DependenceParam) {

		Map<String, String> map = CommonToolsUtil.getRParam(param);

		DependenceParam.put(ParamConstant.JYSDM, map.get(ParamConstant.JYSDM));
		DependenceParam.put(ParamConstant.GDDM, map.get(ParamConstant.GDDM));
		DependenceParam.put(ParamConstant.ZQDM, map.get(ParamConstant.ZQDM));

		// 处理依赖接口发送请求、取得参数等操作
		if ("0".equals(map.get(ParamConstant.WTLX))) {
			DependenceParam.put(ParamConstant.MMLB, map.get(ParamConstant.MMLB));
			DependenceParam.put(ParamConstant.WTLX, map.get(ParamConstant.WTLX));
		} else {
			DependenceParam.put(ParamConstant.WTLX, map.get(ParamConstant.WTLX));
		}

		// 发请求
		System.out.println(DependenceParam.toString());
		log.info(DependenceParam.toString());
		Map<String, String> Depmap = CommonToolsUtil.getRParam(DependenceParam);
		System.out.println(Depmap.toString());
		log.info(Depmap.toString());
		String cxResponse = HttpUtil_All.doPostSSL(DependenceParam.get(ParamConstant.URL), Depmap);

		System.out.println(cxResponse.toString());
		log.info(cxResponse.toString());

		// 根据买卖类别判断校验内容
		Map<String, String> mapRegex = new HashMap<String, String>();
		if (ParamConstant.BUY.equals(map.get(ParamConstant.MMLB))) {
			mapRegex.put(ParamConstant.KMMXX_KMSL, ParamConstant.KMSL_S);
		}else if (ParamConstant.SELL.equals(map.get(ParamConstant.MMLB))) {
			mapRegex.put(ParamConstant.KMMXX_GFKYS, ParamConstant.KMSL_S);
		}else
		{
			throw new RuntimeException(ParamConstant.ERR01);
		}

		// 根据类型校验响应
		if ("0".equals(map.get(ParamConstant.WTLX))) {
			JsonAssertUtil.checkResponse(DependenceParam, mapRegex, ParamConstant.A02_SCHEMA, ParamConstant.PTYW,
					cxResponse);
		} else {
			JsonAssertUtil.checkResponse(DependenceParam, mapRegex, ParamConstant.A03_SCHEMA, ParamConstant.PTYW,
					cxResponse);
		}

		// 从查询接口获取下单需要的数据
		String price = CommonToolsUtil.getPrice(map.get(ParamConstant.WTJG), cxResponse);
		String wtsl = CommonToolsUtil.getOverBSQty(map.get(ParamConstant.MMLB), map.get(ParamConstant.WTSL), cxResponse);
		String jysdm = JsonAssertUtil.getValue(cxResponse, "$.kmmxx[0].jysdm");
		String gddm = JsonAssertUtil.getValue(cxResponse, "$.kmmxx[0].gddm");

		// 处理接口的入参赋值、发送请求、返回值校验操作
		map.put(ParamConstant.WTJG, price);
		map.put(ParamConstant.WTSL, wtsl);
		map.put(ParamConstant.JYSDM, jysdm);
		map.put(ParamConstant.GDDM, gddm);

		// 发请求
		System.out.println(param.toString());
		System.out.println(map.toString());
		log.info(param.toString());
		log.info(map.toString());
		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		System.out.println(response.toString());
		log.info(response.toString());

		// 添加动态校验正则表达式
		Map<String, String> valMap = new HashMap<>();
		valMap.put(ParamConstant.MESSAGE, JsonAssertUtil.getMsgRex(param.get(ParamConstant.EXPECTMSG)));

		// 校验响应字符串
		JsonAssertUtil.checkResponse(param, valMap, ParamConstant.A01_SCHEMA, ParamConstant.PTYW, response);

	}

}
