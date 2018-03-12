package zxjt.inte.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.S08HOTSEARCHRepository;
import zxjt.inte.entity.S08HOTSEARCH;
import zxjt.inte.service.S08HOTSEARCHService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class S08HOTSEARCHServiceImpl implements S08HOTSEARCHService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private S08HOTSEARCHRepository systemDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<S08HOTSEARCH> lis = systemDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.HOTSEARCH, "true");

		Object[][] obj = CommonToolsUtil.getWWData(lis, addrDao, accoDao, ParamConstant.HOTSEARCH);

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
			map.put("type", param.get("type_par"));
			map.remove("type_par");
			System.out.println(param.toString());
			System.out.println(map.toString());
			log.info(param.toString());
			log.info(map.toString());
			String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
			System.out.println(response.toString());
			log.info(response.toString());

			// 不同的正例入参，json返回的字符串格式不一致
			String schemaName = ParamConstant.S08_SCHEMA;
			if(param.get("testPoint").contains("需要校验count") 
					&& ParamConstant.ZL.equals(param.get(ParamConstant.TYPE)))
			{
				schemaName = ParamConstant.S08_COUNT_SCHEMA;
			}
			// 校验
			JsonAssertUtil.checkResponse(param, null, schemaName, ParamConstant.SYSTEM, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
