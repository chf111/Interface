package zxjt.intfc.service.impl.quote;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.intfc.common.constant.ParamConstant;
import zxjt.intfc.common.protobuf.ProtobufHttp;
import zxjt.intfc.common.protobuf.ProtobufRep;
import zxjt.intfc.common.protobuf.ProtobufReq;
import zxjt.intfc.common.util.CommonToolsUtil;
import zxjt.intfc.common.util.JsonAssertUtil;
import zxjt.intfc.common.util.LogUtils;
import zxjt.intfc.dao.common.AccountRepository;
import zxjt.intfc.dao.common.AddressRepository;
import zxjt.intfc.dao.quote.W02BKPHRepository;
import zxjt.intfc.entity.quote.W02BKPH;
import zxjt.intfc.service.quote.W02BKPHService;

@Service
public class W02BKPHServiceImpl implements W02BKPHService {

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
			LogUtils.logInfo(param.toString());
			LogUtils.logInfo(map.toString());

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
