package zxjt.intfc.common.testng;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.LogFactory;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import zxjt.intfc.common.bean.BeforeClassUse;
import zxjt.intfc.common.bean.SYSBean;
import zxjt.intfc.common.constant.ParamConstant;
import zxjt.intfc.common.util.CommonToolsUtil;
import zxjt.intfc.common.util.FolderTypes;
import zxjt.intfc.common.util.GetFolderPath;
import zxjt.intfc.entity.common.StepReport;
import zxjt.intfc.entity.common.TestReport;
import zxjt.intfc.service.common.ReportService;

public abstract class HTMLReporter {
	private static final String TITLE_RESULT = "执行结果";
	private static final String TITLE_CONFIRM = "参数信息";
	private static final String TITLE_EX = "异常信息";
	private static int exNum;
	{

	}

	public static void generate() {
		LogFactory.getLog(HTMLReporter.class).info("generate html report");

		String desCssFilePath = GetFolderPath.getFolderPath(FolderTypes.REPORT) + "extent.css";
		String desJsFilePath = GetFolderPath.getFolderPath(FolderTypes.REPORT) + "extent.js";
		File desCssFile = new File(desCssFilePath);
		File desJsFile = new File(desJsFilePath);
		if (!desCssFile.exists()) {
			try {
				FileUtils.copyInputStreamToFile(HTMLReporter.class.getResourceAsStream("/report-style/extent.css"),
						desCssFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!desJsFile.exists()) {
			try {
				FileUtils.copyInputStreamToFile(HTMLReporter.class.getResourceAsStream("/report-style/extent.js"),
						desJsFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ExtentReports extent = initExtent();

		ExtentTest exTest;
		Test model;
		String html;

		String reportTime = SYSBean.getSysData(ParamConstant.REPORT_DATE);
		ReportService reps = (ReportService) BeforeClassUse.getReportInfo();
		List<TestReport> lstp = reps.getTestInfoByReporttimeAndFlg(reportTime, "test");

		for (TestReport test : lstp) {
			exTest = extent.createTest(test.getName());
			model = exTest.getModel();
			model.setStartTime(CommonToolsUtil.changeStringToDate(test.getStarttime(), "yyyyMMdd HH:mm:ss:S"));

			List<StepReport> lisr = reps.getStepInfoByReporttimeAndFlg(test.getId(), reportTime, "step");
			for (int i = 0; i < lisr.size(); ++i) {
				StepReport sr1 = lisr.get(i);
				html = getStepDescription(sr1);
				switch (Integer.valueOf(sr1.getStatus())) {
				case ITestResult.SUCCESS:
					exTest.pass(html);
					break;
				case ITestResult.FAILURE:
					exTest.fail(html);
					break;
				case ITestResult.SKIP:
					exTest.skip(html);
					break;
				default:
					System.err.println("未知状态，结果未写入报告: " + sr1.getStatus());
					break;
				}
				model.getLogContext().get(i)
						.setTimestamp(CommonToolsUtil.changeStringToDate(sr1.getTimeStamp(), "yyyyMMdd HH:mm:ss:S"));
			}
			model.setEndTime(CommonToolsUtil.changeStringToDate(test.getEndtime(), "yyyyMMdd HH:mm:ss:S"));
		}
		extent.flush();
	}

	private static ExtentReports initExtent() {
		String folder = GetFolderPath.getFolderPath(FolderTypes.REPORT);
		File file = new File(folder);
		if (!file.exists()) {
			file.mkdirs();
		}

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(folder + "/report.html");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("自动化测试报告");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("自动化测试报告");
		htmlReporter.config().setCSS(CssHelper.getCSS());

		ExtentReports extent = new ExtentReports();
		extent.setReportUsesManualConfiguration(true);
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Arch", System.getProperty("os.arch"));
		extent.setSystemInfo("JDK", System.getProperty("java.version"));

		return extent;
	}

	private static String getStepDescription(StepReport step) {
		StringBuilder paramBuilder = wrapWithHTML(step.getParam(), HTMLReporter.TITLE_CONFIRM);
		StringBuilder resultBuilder;
		if (Integer.valueOf(step.getStatus()) == ITestResult.SUCCESS) {
			resultBuilder = wrapWithHTML(step.getResult(), HTMLReporter.TITLE_RESULT);
		} else {
			resultBuilder = wrapFailInfoWithHTML(TITLE_EX, step);
		}

		return wrapTable(paramBuilder, resultBuilder);
	}

	private static StringBuilder wrapWithHTML(String str, String title) {
		if (str == null)
			return null;
		StringBuilder sb = new StringBuilder("<b>");
		sb.append(title).append("</b><pre>").append(str).append("</pre>");
		return sb;
	}

	private static StringBuilder wrapFailInfoWithHTML(String title, StepReport step) {
		String tr = step.getResult();
		if (tr == null)
			return null;

		StringBuilder sb = new StringBuilder("<b>");
		sb.append(title).append("</b>");

		int num = ++exNum;
		// <a href="#" data-featherlight="#ex1" class="box-trigger">堆栈信息</a>
		sb.append("<a href=\"#\" data-featherlight=\"#ex").append(num).append("\" class=\"box-trigger\">堆栈信息</a>");
		// <div class="msgbox" id="ex1">
		sb.append("<div class=\"msgbox\" id=\"ex").append(num).append("\">");
		sb.append("<h6>堆栈信息</h6><pre>").append(step.getStackTrace()).append("</pre></div>");

		// <a href="#" data-featherlight="screenshot/1.png"
		// class="box-trigger">截图</a>
		String screenshot = step.getScreenshot();
		if (screenshot != null) {
			sb.append("<a href=\"#\" data-featherlight=\"").append(screenshot)
					.append("\" class=\"box-trigger\">截图</a>");
		}

		sb.append("<pre>").append(tr).append("</pre>");
		return sb;
	}

	private static String wrapTable(StringBuilder confirm, StringBuilder result) {
		StringBuilder ret = new StringBuilder();
		ret.append("<table><tr><td class=\"td-top td-width\">");
		ret.append(confirm);
		ret.append("</td>");
		if (result != null) {
			ret.append("<td class=\"td-top\">");
			ret.append(result);
			ret.append("</td>");
		}
		ret.append("</tr></table>");
		return ret.toString();
	}
}
