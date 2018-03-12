package zxjt.inte.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.S03CUSTMGRQUERYRepository;
import zxjt.inte.entity.S03CUSTMGRQUERY;
import zxjt.inte.service.S03CUSTMGRQUERYService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class S03CUSTMGRQUERYServiceImpl implements S03CUSTMGRQUERYService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private S03CUSTMGRQUERYRepository systemDao;
	
	@Autowired
	private  AddressRepository addrDao;
	
	@Autowired
	private  AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<S03CUSTMGRQUERY> lis = systemDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.CUSTMGR_QUERY,"true");
		
		Object[][] obj = CommonToolsUtil.getWWData(lis,addrDao,accoDao,ParamConstant.CUSTMGR_QUERY);

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
			JsonAssertUtil.checkResponse(param, null, ParamConstant.S03_SCHEMA, ParamConstant.SYSTEM, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
