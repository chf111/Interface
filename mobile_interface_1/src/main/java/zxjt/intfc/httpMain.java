package zxjt.intfc;

import java.util.Arrays;
import java.util.List;

import zxjt.intfc.common.report.DBConnection;
import zxjt.intfc.common.testng.HTMLReporter;
import zxjt.intfc.common.testng.TestNg;

public class httpMain {

	public static void main(String[] args) throws Exception {

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