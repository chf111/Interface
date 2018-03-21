package zxjt.intfc.service.impl.quote;

import java.util.HashMap;
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
import zxjt.intfc.dao.quote.W06YCXRepository;
import zxjt.intfc.entity.quote.W06YCX;
import zxjt.intfc.service.quote.W06YCXService;

@Service
public class W06YCXServiceImpl implements W06YCXService {
	
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
			LogUtils.logInfo(param.toString());
			LogUtils.logInfo(map.toString());

			// 发请求
			String response = HttpUtil_All.doGet(param.get(ParamConstant.URL));
			LogUtils.logInfo(response.toString());
			
			// 拼接
			Map<String, String> valMap = new HashMap<>();
			valMap.put("[,stock_code", "^000001$");

			// 校验
			JsonAssertUtil.checkResponse(param, valMap, ParamConstant.W06_SCHEMA, ParamConstant.WW, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}