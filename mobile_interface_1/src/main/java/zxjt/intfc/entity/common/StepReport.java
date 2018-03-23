package zxjt.intfc.entity.common;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "report")
public class StepReport {

	@Id
	private ObjectId id;
	private ObjectId testId;
	private String status;
	private String timeStamp;
	private String param;
	private String result;
	private String stackTrace;
	private String screenshot;
	private String reporttime;
	private String flg;

	@PersistenceConstructor
	public StepReport() {
		super();
	}
//	public StepReport(ObjectId id, ObjectId testId, String status, String timeStamp, String param, String result,
//			String stackTrace, String screenshot, String reporttime, String flg) {
//		super();
//		this.id = id;
//		this.testId = testId;
//		this.status = status;
//		this.timeStamp = timeStamp;
//		this.param = param;
//		this.result = result;
//		this.stackTrace = stackTrace;
//		this.screenshot = screenshot;
//		this.reporttime = reporttime;
//		this.flg = flg;
//	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public ObjectId getTestId() {
		return testId;
	}

	public void setTestId(ObjectId testId) {
		this.testId = testId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getScreenshot() {
		return screenshot;
	}

	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}

	public String getReporttime() {
		return reporttime;
	}

	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}

	public String getFlg() {
		return flg;
	}

	public void setFlg(String flg) {
		this.flg = flg;
	}

}
