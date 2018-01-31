package zxjt.inte.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.W06YCXRepository;
import zxjt.inte.entity.W06YCX;
import zxjt.inte.service.W06YCXService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class W06YCXServiceImpl implements W06YCXService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private W06YCXRepository wwDao;
	
	@Autowired
	private  AddressRepository addrDao;
	
	@Autowired
	private  AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<W06YCX> lis = wwDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.YCX_ID,"true");
		
		Object[][] obj = CommonToolsUtil.getWWData(lis,addrDao,accoDao,ParamConstant.YCX_ID);

		return obj;
	}

	/**
	 * 发送请求并校验返回结果
	 * 
	 * @param 入参
	 * @DependenceParam 依赖接口的入参
	 */
	public void test(Map<String, String> param) {
		try {
			Map<String, String> map = CommonToolsUtil.getRParam(param);
			System.out.println(param.toString());
			System.out.println(map.toString());
			log.info(param.toString());
			log.info(map.toString());

			// 发请求
			String response = HttpUtil_All.doGet(param.get(ParamConstant.URL));
			System.out.println(response);
			log.info(response.toString());
			
			// 拼接
			Map<String, String> valMap = new HashMap<>();
			valMap.put(ParamConstant.STOCK_CODE, "^000001$");

			// 校验
			JsonAssertUtil.checkResponse(param, valMap, ParamConstant.W06_SCHEMA, ParamConstant.WW, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}