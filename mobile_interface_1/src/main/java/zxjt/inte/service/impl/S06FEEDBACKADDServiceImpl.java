package zxjt.inte.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.S06FEEDBACKADDRepository;
import zxjt.inte.entity.S06FEEDBACKADD;
import zxjt.inte.service.S06FEEDBACKADDService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.FieldPairBean;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;
import zxjt.inte.util.FilePairBean;

@Service
public class S06FEEDBACKADDServiceImpl implements S06FEEDBACKADDService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private S06FEEDBACKADDRepository systemDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<S06FEEDBACKADD> lis = systemDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.FEEDBACK_ADD, "true");

		Object[][] obj = CommonToolsUtil.getWWData(lis, addrDao, accoDao, ParamConstant.FEEDBACK_ADD);

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
			ArrayList<FieldPairBean> fp = new ArrayList<FieldPairBean>();
			for (String key : map.keySet()) {
				fp.add(new FieldPairBean(key, map.get(key)));// 其他参数
			}

			// 设定要上传的文件
			ArrayList<FilePairBean> fip = new ArrayList<FilePairBean>();
//			fip.add(new UploadFileItem("image", System.getProperty("user.dir") + "/src/test/resources/123.jpg"));
			
			String response = HttpUtil_All.sendFormPostRequest(param.get(ParamConstant.URL), fp, fip); 
			System.out.println(response.toString());
			log.info(response.toString());

			// 校验
			JsonAssertUtil.checkResponse(param, null, ParamConstant.S06_SCHEMA, ParamConstant.SYSTEM, response);
//			JsonAssertUtil.checkResponse(param, null, ParamConstant.S06_SCHEMA, ParamConstant.SYS, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
