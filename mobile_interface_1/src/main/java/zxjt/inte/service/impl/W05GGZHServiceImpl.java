package zxjt.inte.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.W05GGZHRepository;
import zxjt.inte.entity.W05GGZH;
import zxjt.inte.protobuf.ProtobufHttp;
import zxjt.inte.protobuf.ProtobufRep;
import zxjt.inte.protobuf.ProtobufReq;
import zxjt.inte.service.W05GGZHService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class W05GGZHServiceImpl implements W05GGZHService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private W05GGZHRepository wwDao;
	
	@Autowired
	private  AddressRepository addrDao;
	
	@Autowired
	private  AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<W05GGZH> lis = wwDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.GGZH_ID,"true");
		
		Object[][] obj = CommonToolsUtil.getWWData(lis,addrDao,accoDao,ParamConstant.GGZH_ID);

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

			// 发请求
			byte[] postdata = ProtobufReq.multi_stock_united_req(map, false, true, true);
			InputStream stream = ProtobufHttp.post(postdata, param.get("url"));
			
			Map<String, String> regexMap =JsonAssertUtil.getRegex(null, ParamConstant.WW, ParamConstant.W05_SCHEMA+ParamConstant.SCHEMA_ZL);
			ProtobufRep.multi_stock_united_rep(stream,regexMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
