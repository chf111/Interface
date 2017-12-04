package zxjt.inte.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.A01GPMMDao;
import zxjt.inte.entity.A01GPMM;
import zxjt.inte.entity.CommonInfo;
import zxjt.inte.service.A00LoginService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.GetConfigProperties;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class A00LoginServiceImpl implements A00LoginService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private A01GPMMDao gpmmDao;

	public Object[][] getParamsInfo() {

		// 公共参数操作
		List<CommonInfo> lisag = GetConfigProperties.getConfigProToCommon();
		Map<String, String> commonParam = CommonToolsUtil.getCommonParam(lisag);

		// 股票买卖数据操作
		List<A01GPMM> lis = gpmmDao.getParamsInfo(ParamConstant.PTJYLOGIN_ID);
		List<Map<String, String>> lisTemp = CommonToolsUtil.getDependencyParamsInfo(lis, commonParam);

		Object[][] obj = new Object[lisTemp.size()][1];
		for (int j = 0; j < obj.length; j++) {

			obj[j][0] = lisTemp.get(j);
		}
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
		map.remove("fjrsjxh");//TODO:等待字段的值确定下来

		System.out.println(map.toString());
		String response = HttpUtil_All.doPostSSL(param.get("url"), map);
		System.out.println(response.toString());
		log.info(response.toString());

		JsonAssertUtil.checkNull(response);
		Map<String, String> valMap = new HashMap<>();
		valMap.put("message", JsonAssertUtil.getMsgRex(param.get("expectMsg")));
		String strjsonSchema = "";
		try {
			if (ParamConstant.ZL.equalsIgnoreCase(param.get("type"))) {
				Map<String, String> regexMap = JsonAssertUtil.getRegex(valMap, ParamConstant.PTYW,
						ParamConstant.A00_SCHEMA_ZL);
				strjsonSchema = JsonAssertUtil.editSchemaInfo(ParamConstant.A00_SCHEMA_ZL, regexMap);
			} else if (ParamConstant.FL.equalsIgnoreCase(param.get("type"))) {
				Map<String, String> regexMap = JsonAssertUtil.getRegex(valMap, ParamConstant.PTYW,
						ParamConstant.A00_SCHEMA_FL);
				strjsonSchema = JsonAssertUtil.editSchemaInfo(ParamConstant.A00_SCHEMA_FL, regexMap);
			} else {
				throw new RuntimeException("测试数据类型缺失，请查证后再执行！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		// 验证 *自己的schema名称
		JsonAssertUtil.JsonAssert(response, strjsonSchema);
	}

}
