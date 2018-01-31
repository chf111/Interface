package zxjt.inte.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.W02BKPHRepository;
import zxjt.inte.entity.W02BKPH;
import zxjt.inte.protobuf.ProtobufHttp;
import zxjt.inte.protobuf.ProtobufRep;
import zxjt.inte.protobuf.ProtobufReq;
import zxjt.inte.service.W02BKPHService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class W02BKPHServiceImpl implements W02BKPHService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private W02BKPHRepository wwDao;
	
	@Autowired
	private  AddressRepository addrDao;
	
	@Autowired
	private  AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<W02BKPH> lis = wwDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.BKPH_ID,"true");
		
		Object[][] obj = CommonToolsUtil.getWWData(lis,addrDao,accoDao,ParamConstant.BKPH_ID);

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
			byte[] postdata = ProtobufReq.multi_blockRank_req(map);
			InputStream stream = ProtobufHttp.post(postdata, param.get("url"));
			
			//添加动态校验正则表达式
			Map<String, String> valMap = new HashMap<>();
			valMap.put(ParamConstant.WTYPE, ParamConstant.REGEXBEGIN+param.get(ParamConstant.WTYPE)+ParamConstant.REGEXEND);
			valMap.put(ParamConstant.BSORT, ParamConstant.REGEXBEGIN+param.get(ParamConstant.BSORT)+ParamConstant.REGEXEND);
			valMap.put(ParamConstant.BDIRECT, ParamConstant.REGEXBEGIN+param.get(ParamConstant.BDIRECT)+ParamConstant.REGEXEND);
			valMap.put(ParamConstant.WFROM, ParamConstant.REGEXBEGIN+param.get(ParamConstant.WFROM)+ParamConstant.REGEXEND);
			valMap.put(ParamConstant.WCOUNT, ParamConstant.REGEXBEGIN+param.get(ParamConstant.WCOUNT)+ParamConstant.REGEXEND);
			valMap.put(ParamConstant.FIELDSBITMAP, ParamConstant.REGEXBEGIN+param.get(ParamConstant.FIELDSBITMAP)+ParamConstant.REGEXEND);
			
			Map<String, String> regexMap =JsonAssertUtil.getRegex(valMap, ParamConstant.WW, ParamConstant.W02_SCHEMA+ParamConstant.SCHEMA_ZL);
			ProtobufRep.multi_blockRank_rep(stream,regexMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
