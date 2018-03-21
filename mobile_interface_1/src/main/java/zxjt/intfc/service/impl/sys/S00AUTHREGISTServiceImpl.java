package zxjt.intfc.service.impl.sys;

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
import zxjt.intfc.dao.sys.S00AUTHREGISTRepository;
import zxjt.intfc.entity.sys.S00AUTHREGIST;
import zxjt.intfc.service.sys.S00AUTHREGISTService;

@Service
public class S00AUTHREGISTServiceImpl implements S00AUTHREGISTService {
	
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
			LogUtils.logInfo(param.toString());
			LogUtils.logInfo(map.toString());

			String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
			LogUtils.logInfo(response.toString());

			JsonAssertUtil.checkResponse(param, null, ParamConstant.S00_SCHEMA, ParamConstant.SYSTEM, response);
			String sec_code = JsonPath.read(response, "$.sec_code", new Predicate[0]);
			SYSBean.putSysData("sec_code", sec_code);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
