package zxjt.inte.service.impl;

import java.util.HashMap;
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
import zxjt.inte.dao.S14RDGENRepository;
import zxjt.inte.entity.S14RDGEN;
import zxjt.inte.service.S14RDGENService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;
import zxjt.inte.util.SYSBean;

@Service
public class S14RDGENServiceImpl implements S14RDGENService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private S14RDGENRepository systemDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<S14RDGEN> lis = systemDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.RANDCODE_GEN, "true");

		Object[][] obj = CommonToolsUtil.getWWData(lis, addrDao, accoDao, ParamConstant.RANDCODE_GEN);

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

			// 校验
			JsonAssertUtil.checkResponse(param, null, ParamConstant.S14_SCHEMA, ParamConstant.SYSTEM, response);
			
			// s15依赖于s14，处理s15要用到的参数
			String rand_code = JsonPath.read(response, "$.rand_code", new Predicate[0]);
			String tocken = JsonPath.read(response, "$.tocken", new Predicate[0]);
			String phone_number = map.get("phone_number");
			Map<String,String> s15 = new HashMap<String,String>();
			s15.put("phone_number", phone_number);
			s15.put("rand_code", rand_code);
			s15.put("tocken", tocken);
			SYSBean.putMap("s15"+"_"+param.get("row"), s15);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
