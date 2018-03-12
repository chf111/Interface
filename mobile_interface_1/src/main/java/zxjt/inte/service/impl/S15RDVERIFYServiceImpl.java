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
import zxjt.inte.dao.S15RDVERIFYRepository;
import zxjt.inte.entity.S15RDVERIFY;
import zxjt.inte.service.S15RDVERIFYService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;
import zxjt.inte.util.SYSBean;

@Service
public class S15RDVERIFYServiceImpl implements S15RDVERIFYService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private S15RDVERIFYRepository systemDao;

	@Autowired
	private AddressRepository addrDao;

	@Autowired
	private AccountRepository accoDao;

	public Object[][] getParamsInfo() {
		// 股票买卖数据操作
		List<S15RDVERIFY> lis = systemDao.findByFunctionidAndIsExcuteIgnoreCase(ParamConstant.RANDCODE_VERIFY, "true");

		List<S15RDVERIFY> lis1 = new ArrayList<S15RDVERIFY>();
		int i=1;
		for(Object key:SYSBean.ConkeySet())
		{
			String s15key = (String) key;
			if(s15key.contains("s15"))
			{
				Map<String,String> s15map = SYSBean.getMap((String) key);
				S15RDVERIFY s15entity = new S15RDVERIFY();
				s15entity.setPhone_number(s15map.get("phone_number"));
				s15entity.setRand_code(s15map.get("rand_code"));
				s15entity.setTocken(s15map.get("tocken"));
				s15entity.setRow(String.valueOf(i));
				s15entity.setType("zl");
				lis1.add(s15entity);
				i++;
			}
		}
		Object[][] obj =null;
		if(lis1.size()>0)
		{
			obj = CommonToolsUtil.getWWData(lis1, addrDao, accoDao, ParamConstant.RANDCODE_VERIFY);
		}else
		{
			obj = CommonToolsUtil.getWWData(lis, addrDao, accoDao, ParamConstant.RANDCODE_VERIFY);
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
		try {
			Map<String, String> map = CommonToolsUtil.getRParam(param);
			System.out.println(param.toString());
			System.out.println(map.toString());
			log.info(param.toString());
			log.info(map.toString());
			String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
			System.out.println(response.toString());
			log.info(response.toString());

			// 校验
			JsonAssertUtil.checkResponse(param, null, ParamConstant.S15_SCHEMA, ParamConstant.SYSTEM, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
