package zxjt.intfc.service.impl.sys;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.intfc.common.constant.ParamConstant;
import zxjt.intfc.common.util.CommonToolsUtil;
import zxjt.intfc.common.util.HttpUtil_All;
import zxjt.intfc.common.util.JsonAssertUtil;
import zxjt.intfc.common.util.LogUtils;
import zxjt.intfc.dao.common.AccountRepository;
import zxjt.intfc.dao.common.AddressRepository;
import zxjt.intfc.dao.sys.S08HOTSEARCHRepository;
import zxjt.intfc.entity.sys.S08HOTSEARCH;
import zxjt.intfc.service.sys.S08HOTSEARCHService;

@Service
public class S08HOTSEARCHServiceImpl implements S08HOTSEARCHService {

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
			LogUtils.logInfo(param.toString());
			LogUtils.logInfo(map.toString());
			
			String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
			LogUtils.logInfo(response.toString());

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
