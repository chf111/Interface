package zxjt.inte.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zxjt.inte.dao.A00LoginDao;
import zxjt.inte.entity.A00Login;
import zxjt.inte.service.A00LoginService;
import zxjt.inte.util.HttpUtil_All;

@Service
public class A00LoginServiceImpl implements A00LoginService {

	@Resource
	private A00LoginDao loginDao;

	public Object[][] getParamsInfo() {

		Object[][] obj = new Object[2][1];
		List<A00Login> lis = loginDao.getLoginInfo();

		for (int i = 0; i < lis.size(); i++) {
			Map<String, String> mapS = new HashMap<String, String>();
			mapS.put("khbz", lis.get(i).getKhbz());
			mapS.put("url", lis.get(i).getUrl());
			mapS.put("jymm", lis.get(i).getJymm());
			mapS.put("khbzlx", lis.get(i).getKhbzlx());
			mapS.put("lhxx", lis.get(i).getLhxx());
			mapS.put("rzfs", lis.get(i).getRzfs());
			mapS.put("sessionid", lis.get(i).getSessionid());
			mapS.put("token", lis.get(i).getToken());
			mapS.put("yybdm", lis.get(i).getYybdm());
			mapS.put("expectmsg", lis.get(i).getExpectmsg());
			mapS.put("testpoint", lis.get(i).getTestpoint());

			obj[i][0] = mapS;
		}
		return obj;
	}

	public void test(Map<String, String> param) {
		String response = HttpUtil_All.doPostSSL(param.get("url"), param);
		System.out.println(response.toString());
	}
}
