package zxjt.inte.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testdata")
public class B09HSGGTWTCD {

	@Id
	private ObjectId id;
	private int functionid;
	private String row;
	private String jysdm;
	private String gddm;
	private String wtxh;
	private String isExcute;
	private String type;
	private String expectMsg;
	private String testPoint;

	@PersistenceConstructor
	public B09HSGGTWTCD(ObjectId id, int functionid, String row, String jysdm, String gddm, String wtxh,
			String isExcute, String type, String expectMsg, String testPoint) {
		super();
		this.id = id;
		this.functionid = functionid;
		this.row = row;
		this.jysdm = jysdm;
		this.gddm = gddm;
		this.wtxh = wtxh;
		this.isExcute = isExcute;
		this.type = type;
		this.expectMsg = expectMsg;
		this.testPoint = testPoint;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public int getFunctionid() {
		return functionid;
	}

	public void setFunctionid(int functionid) {
		this.functionid = functionid;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getJysdm() {
		return jysdm;
	}

	public void setJysdm(String jysdm) {
		this.jysdm = jysdm;
	}

	public String getGddm() {
		return gddm;
	}

	public void setGddm(String gddm) {
		this.gddm = gddm;
	}

	public String getWtxh() {
		return wtxh;
	}

	public void setWtxh(String wtxh) {
		this.wtxh = wtxh;
	}

	public String getIsExcute() {
		return isExcute;
	}

	public void setIsExcute(String isExcute) {
		this.isExcute = isExcute;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExpectMsg() {
		return expectMsg;
	}

	public void setExpectMsg(String expectMsg) {
		this.expectMsg = expectMsg;
	}

	public String getTestPoint() {
		return testPoint;
	}

	public void setTestPoint(String testPoint) {
		this.testPoint = testPoint;
	}
}
