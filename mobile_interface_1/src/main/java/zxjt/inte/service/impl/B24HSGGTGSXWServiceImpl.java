package zxjt.inte.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.B24HSGGTGSXWRepository;
import zxjt.inte.entity.B24HSGGTGSXW;
import zxjt.inte.service.B24HSGGTGSXWService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class B24HSGGTGSXWServiceImpl implements B24HSGGTGSXWService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Autowired
	private B24HSGGTGSXWRepository hsggtDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {

		// 股票买卖数据操作
		List<B24HSGGTGSXW> lis = hsggtDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.HSGGT_GSXW_ID,
				"true");

		// 入参拼接
		List<Map<String, String>> lisTemp = CommonToolsUtil.getTestData(lis, addrDao, accoDao,
				ParamConstant.HSGGT_GSXW_ID);

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
		map.put("jgbm", map.get("yybdm"));

		// 发请求
		System.out.println(param.toString());
		System.out.println(map.toString());

		log.info(param.toString());
		log.info(map.toString());

		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		System.out.println(response.toString());
		log.info(response.toString());
		
		// 校验
		JsonAssertUtil.checkResponse(param, null, ParamConstant.B24_SCHEMA, ParamConstant.PTYW, response);

	}
}