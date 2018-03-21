package zxjt.intfc.service.impl.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

import zxjt.intfc.common.bean.SYSBean;
import zxjt.intfc.common.constant.ParamConstant;
import zxjt.intfc.common.util.CommonToolsUtil;
import zxjt.intfc.common.util.HttpUtil_All;
import zxjt.intfc.common.util.JsonAssertUtil;
import zxjt.intfc.common.util.LogUtils;
import zxjt.intfc.dao.common.AccountRepository;
import zxjt.intfc.dao.common.AddressRepository;
import zxjt.intfc.dao.sys.S14RDGENRepository;
import zxjt.intfc.entity.sys.S14RDGEN;
import zxjt.intfc.service.sys.S14RDGENService;

@Service
public class S14RDGENServiceImpl implements S14RDGENService {

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
			LogUtils.logInfo(param.toString());
			LogUtils.logInfo(map.toString());
			String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
			LogUtils.logInfo(response.toString());

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
