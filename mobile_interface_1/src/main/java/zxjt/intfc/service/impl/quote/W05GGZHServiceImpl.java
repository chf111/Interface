package zxjt.intfc.service.impl.quote;

import java.io.InputStream;
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
import zxjt.intfc.dao.quote.W05GGZHRepository;
import zxjt.intfc.entity.quote.W05GGZH;
import zxjt.intfc.service.quote.W05GGZHService;

@Service
public class W05GGZHServiceImpl implements W05GGZHService {

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
			LogUtils.logInfo(param.toString());
			LogUtils.logInfo(map.toString());
			// 发请求
			byte[] postdata = ProtobufReq.multi_stock_united_req(map);
			InputStream stream = ProtobufHttp.post(postdata, param.get("url"));
			
			Map<String, String> regexMap =JsonAssertUtil.getRegex(null, ParamConstant.WW, ParamConstant.W05_SCHEMA+ParamConstant.SCHEMA_ZL);
			ProtobufRep.multi_stock_united_rep(stream,regexMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
