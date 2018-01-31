package zxjt.inte.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.AccountRepository;
import zxjt.inte.dao.AddressRepository;
import zxjt.inte.dao.B09HSGGTWTCDRepository;
import zxjt.inte.entity.B09HSGGTWTCD;
import zxjt.inte.service.B09HSGGTWTCDService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;
import zxjt.inte.util.WTXHBean;

@Service
public class B09HSGGTWTCDServiceImpl implements B09HSGGTWTCDService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Autowired
	private B09HSGGTWTCDRepository hsggtDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {

		// 股票买卖数据操作
		List<B09HSGGTWTCD> lis = hsggtDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.HSGGT_WTCD_ID, "true");

		// 入参拼接
		List<Map<String, String>> lisTemp = CommonToolsUtil.getTestData(lis, addrDao, accoDao,
				ParamConstant.HSGGT_WTCD_ID);

		// 根据委托下单时保存的序号，将相关数据拼到入参中
		List<Map<String, String>> lisParam = new ArrayList<>();

		for (int j = 0; j < lisTemp.size(); j++) {
			Boolean flg=false;
			Map<String, String> lisMap = lisTemp.get(j);
			for (Object o : WTXHBean.ConkeySet()) {
				Map<String, String> paramMap = new HashMap<String, String>();
				paramMap.putAll(lisMap);
				String[] key = ((String) o).split("_");
				String jysdm = key[key.length - 1];
				if (ParamConstant.GGTMM_KEY.equals(key[0])
						&& paramMap.get(ParamConstant.JYSDM).equals(jysdm)) {

					Map<String, String> wtxhMap = WTXHBean.getMap((String) o);
					paramMap.put(ParamConstant.GDDM, wtxhMap.get(ParamConstant.GDDM));
					paramMap.put(ParamConstant.WTXH, wtxhMap.get(ParamConstant.WTXH));
					lisParam.add(paramMap);
					flg = true;
				}
			}
			// 如果当前交易市场不存在可撤单数据，则抛异常告诉测试人员此市场尚未测试到，需要再次准备数据进行撤单测试
			if(!flg)
			{
				lisMap.put(ParamConstant.EXPECTMSG, ParamConstant.ERR02+lisMap.get(ParamConstant.JYSDM)+ParamConstant.ERR03);
				lisParam.add(lisMap);
			}
		}

		Object[][] obj = new Object[lisParam.size()][1];
		for (int i = 0; i < obj.length; i++) {
			obj[i][0] = lisParam.get(i);
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

		// 判断当前数据是否为提示交易市场不存在撤单数据的报错数据
		if(param.get(ParamConstant.EXPECTMSG).contains(ParamConstant.ERR02))
		{
			throw new RuntimeException(param.get(ParamConstant.EXPECTMSG));
		}
		
		Map<String, String> map = CommonToolsUtil.getRParam(param);

		// 发请求
		System.out.println(param.toString());
		System.out.println(map.toString());
		log.info(param.toString());
		log.info(map.toString());

		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		System.out.println(response.toString());
		log.info(response.toString());

		// 校验
		JsonAssertUtil.checkResponse(param, null, ParamConstant.B09_SCHEMA, ParamConstant.PTYW, response);
	}
}
