package zxjt.intfc.service.impl.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.intfc.common.bean.FieldPairBean;
import zxjt.intfc.common.bean.FilePairBean;
import zxjt.intfc.common.constant.ParamConstant;
import zxjt.intfc.common.util.CommonToolsUtil;
import zxjt.intfc.common.util.HttpUtil_All;
import zxjt.intfc.common.util.JsonAssertUtil;
import zxjt.intfc.common.util.LogUtils;
import zxjt.intfc.dao.common.AccountRepository;
import zxjt.intfc.dao.common.AddressRepository;
import zxjt.intfc.dao.sys.S06FEEDBACKADDRepository;
import zxjt.intfc.entity.sys.S06FEEDBACKADD;
import zxjt.intfc.service.sys.S06FEEDBACKADDService;

@Service
public class S06FEEDBACKADDServiceImpl implements S06FEEDBACKADDService {

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
			LogUtils.logInfo(param.toString());
			LogUtils.logInfo(map.toString());
			ArrayList<FieldPairBean> fp = new ArrayList<FieldPairBean>();
			for (String key : map.keySet()) {
				fp.add(new FieldPairBean(key, map.get(key)));// 其他参数
			}

			// 设定要上传的文件
			ArrayList<FilePairBean> fip = new ArrayList<FilePairBean>();
//			fip.add(new UploadFileItem("image", System.getProperty("user.dir") + "/src/test/resources/123.jpg"));
			
			String response = HttpUtil_All.sendFormPostRequest(param.get(ParamConstant.URL), fp, fip); 
			LogUtils.logInfo(response.toString());

			// 校验
			JsonAssertUtil.checkResponse(param, null, ParamConstant.S06_SCHEMA, ParamConstant.SYSTEM, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
