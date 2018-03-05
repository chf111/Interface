package zxjt.inte.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.S05FAVORUPDATERepository;
import zxjt.inte.entity.S05FAVORUPDATE;
import zxjt.inte.service.S05FAVORUPDATEService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class S05FAVORUPDATEServiceImpl implements S05FAVORUPDATEService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private S05FAVORUPDATERepository systemDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<S05FAVORUPDATE> lis = systemDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.FAVOR_UPDATE, "true");

		Object[][] obj = CommonToolsUtil.getWWData(lis, addrDao, accoDao, ParamConstant.FAVOR_UPDATE);

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
			
			String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map,
					ParamConstant.NEED_PUT_REQ_HEADER_INFO);
			System.out.println(response.toString());
			log.info(response.toString());

			// 校验
			JsonAssertUtil.checkResponse(param, null, ParamConstant.S05_SCHEMA, ParamConstant.SYSTEM, response);
//			JsonAssertUtil.checkResponse(param, null, ParamConstant.S05_SCHEMA, ParamConstant.SYS, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
