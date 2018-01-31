package zxjt.inte.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testdata")
public class A00Login {

	@Id
	private ObjectId id;
	private int functionid;
	private String row;
	private String rzfs;
	private String rznr;
	private String wldz;
	private String fjrsjxh;
	private String isExcute;
	private String type;
	private String expectMsg;
	private String testPoint;

	@PersistenceConstructor
	public A00Login(ObjectId id, int functionid,String row,String rzfs, String rznr, String wldz, String fjrsjxh, String isExcute,
			String type, String expectMsg, String testPoint) {
		super();
		this.id = id;
		this.functionid = functionid;
		this.row = row;
		this.rzfs = rzfs;
		this.rznr = rznr;
		this.wldz = wldz;
		this.fjrsjxh = fjrsjxh;
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

	public String getRzfs() {
		return rzfs;
	}

	public void setRzfs(String rzfs) {
		this.rzfs = rzfs;
	}

	public String getRznr() {
		return rznr;
	}

	public void setRznr(String rznr) {
		this.rznr = rznr;
	}

	public String getWldz() {
		return wldz;
	}

	public void setWldz(String wldz) {
		this.wldz = wldz;
	}

	public String getFjrsjxh() {
		return fjrsjxh;
	}

	public void setFjrsjxh(String fjrsjxh) {
		this.fjrsjxh = fjrsjxh;
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
