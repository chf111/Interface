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
import zxjt.intfc.dao.quote.W01DMLRepository;
import zxjt.intfc.entity.quote.W01DML;
import zxjt.intfc.service.quote.W01DMLService;

/**
 * 代码链查询
 * 
 * @author Administrator
 *
 */
@Service
public class W01DMLServiceImpl implements W01DMLService {
	@Resource
	private W01DMLRepository wwDao;
	
	@Autowired
	private  AddressRepository addrDao;
	
	@Autowired
	private  AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<W01DML> lis = wwDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.DML_ID,"true");
		
		Object[][] obj = CommonToolsUtil.getWWData(lis,addrDao,accoDao,ParamConstant.DML_ID);

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
			byte[] postdata = ProtobufReq.codeList_req(map);
			InputStream stream = ProtobufHttp.post(postdata, param.get(ParamConstant.URL));

			// 添加动态校验正则表达式
			Map<String, String> regexMap = JsonAssertUtil.getRegex(null, ParamConstant.WW,
					ParamConstant.W01_SCHEMA + ParamConstant.SCHEMA_ZL);
			ProtobufRep.codeList_rep(stream, regexMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
