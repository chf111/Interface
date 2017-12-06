package zxjt.inte.http;

import java.util.Arrays;
import java.util.List;

import zxjt.inte.report.DBConnection;
import zxjt.inte.testng.listener.HTMLReporter;
import zxjt.inte.util.TestNg;

public class httpMain {

	public static void main(String[] args) throws Exception {

		//1、修改report文件夹name
		//2、修改kmsl校验
		//3、整合公共的dao、db等
		if (args.length <= 0) {
			throw new RuntimeException("请输入需要执行的模块");
		}

		String testCase = String.valueOf(args[0]);
		String[] strTst = testCase.split(",");
		List<String> list = Arrays.asList(strTst);

		TestNg testNew = new TestNg(false);
		testNew.setParam(list);
		testNew.run();
		HTMLReporter.generate();
		DBConnection.close();
	}
}