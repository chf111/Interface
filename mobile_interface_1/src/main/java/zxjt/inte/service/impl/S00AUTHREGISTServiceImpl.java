package zxjt.inte.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.S00AUTHREGISTRepository;
import zxjt.inte.entity.S00AUTHREGIST;
import zxjt.inte.service.S00AUTHREGISTService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;
import zxjt.inte.util.SYSBean;

@Service
public class S00AUTHREGISTServiceImpl implements S00AUTHREGISTService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private S00AUTHREGISTRepository systemDao;
	
	@Autowired
	private  AddressRepository addrDao;
	
	@Autowired
	private  AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<S00AUTHREGIST> lis = systemDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.AUTH_REGIST,"true");
		
		Object[][] obj = CommonToolsUtil.getSafeWWData(lis,addrDao,accoDao,ParamConstant.AUTH_REGIST);

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

			String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
			System.out.println(response.toString());
			log.info(response.toString());

			// 接下来的任务是把年前system中录出来的接口脚本先给写出来
			// 手机号注册过了，再运行就会提示已注册，所以就数据库那两个来回切着用，就可以解决这个问题了
//			JsonAssertUtil.checkResponse(param, null, ParamConstant.S00_SCHEMA, ParamConstant.SYS, response);
			JsonAssertUtil.checkResponse(param, null, ParamConstant.S00_SCHEMA, ParamConstant.SYSTEM, response);
			String sec_code = JsonPath.read(response, "$.sec_code", new Predicate[0]);
			SYSBean.putSysData("sec_code", sec_code);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
