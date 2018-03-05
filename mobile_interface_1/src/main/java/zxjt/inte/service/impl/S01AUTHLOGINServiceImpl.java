package zxjt.inte.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.S01AUTHLOGINRepository;
import zxjt.inte.entity.S01AUTHLOGIN;
import zxjt.inte.service.S01AUTHLOGINService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;
import zxjt.inte.util.SYSBean;

@Service
public class S01AUTHLOGINServiceImpl implements S01AUTHLOGINService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private S01AUTHLOGINRepository systemDao;
	
	@Autowired
	private  AddressRepository addrDao;
	
	@Autowired
	private  AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<S01AUTHLOGIN> lis = systemDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.AUTH_LOGIN,"true");
		
		Object[][] obj = CommonToolsUtil.getSafeWWData(lis,addrDao,accoDao,ParamConstant.AUTH_LOGIN);

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
			String sec_code = SYSBean.getSysData("sec_code");
			map.put("sec_code", sec_code);
			System.out.println(param.toString());
			System.out.println(map.toString());
			log.info(param.toString());
			log.info(map.toString());

			String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map,ParamConstant.NEED_GET_REP_HEADER_INFO);
			System.out.println(response.toString());
			log.info(response.toString());

			// 校验
			JsonAssertUtil.checkResponse(param, null, ParamConstant.S01_SCHEMA, ParamConstant.SYSTEM, response);
//			JsonAssertUtil.checkResponse(param, null, ParamConstant.S01_SCHEMA, ParamConstant.SYS, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
