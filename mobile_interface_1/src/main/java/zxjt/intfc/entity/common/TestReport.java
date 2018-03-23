package zxjt.intfc.entity.common;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "report")
public class TestReport {

	@Id
	private ObjectId id;
	private String name;
	private String starttime;
	private String endtime;
	private String reporttime;
	private String flg;

	@PersistenceConstructor
	public TestReport() {
		super();
	}

	// public TestReport(ObjectId id, String name, String starttime, String endtime,
	// String reporttime, String flg) {
	// super();
	// this.id = id;
	// this.name = name;
	// this.starttime = starttime;
	// this.endtime = endtime;
	// this.reporttime = reporttime;
	// this.flg = flg;
	// }

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
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
