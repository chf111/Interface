package zxjt.inte.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.CommonWWDao;
import zxjt.inte.entity.CommonInfo;
import zxjt.inte.entity.CommonWW;
import zxjt.inte.protobuf.ProtobufHttp;
import zxjt.inte.protobuf.ProtobufRep;
import zxjt.inte.protobuf.ProtobufReq;
import zxjt.inte.service.W00HQZXGHQService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.GetConfigProperties;
import zxjt.inte.util.ParamConstant;

@Service
public class W00HQZXGHQServiceImpl implements W00HQZXGHQService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private CommonWWDao wwDao;

	 public Object[][] getParamsInfo() {

		// 公共参数操作
		List<CommonInfo> lisag = GetConfigProperties.getConfigProToCommon();
		Map<String, String> commonParam = CommonToolsUtil.getCommonParam(lisag);

		// 股票买卖数据操作
		List<CommonWW> lis = wwDao.getParamsInfo(ParamConstant.HQZXGHQ_ID);
		List<Map<String, String>> lisTemp = CommonToolsUtil.getWWParamsInfo(lis, commonParam);

		
		 Object[][] obj = new Object[lisTemp.size()][1];
		 for (int j = 0; j < obj.length; j++) {
		
		 obj[j][0] = lisTemp.get(j);
		 }
		 return obj;
	}


	/**
	 * 发送请求并校验返回结果
	 * 
	 * @param 入参
	 * @DependenceParam 依赖接口的入参
	 */
	public void test(Map<String, String> param) {

		Map<String, String> map = CommonToolsUtil.getRParam(param);
		System.out.println(param.toString());
		System.out.println(map.toString());
		log.info(param.toString());
		log.info(map.toString());
		
		// 发请求
		byte[] postdata = ProtobufReq.multi_selectedStocks_req(map);
		InputStream stream =ProtobufHttp.post(postdata, param.get("url"));
		ProtobufRep.multi_selectedStocks_rep( stream);
	}
}
