package zxjt.inte.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testdata")
public class B15HSGGTJYRLCX {

	@Id
	private ObjectId id;
	private int functionid;
	private String row;
	private String rzfs;
	private String rzxx;
	private String rznr;
	private String access_token;
	private String qqhs;
	private String dwc;
	private String wlrq;
	private String zzrq;
	private String jysdm;
	private String isExcute;
	private String type;
	private String expectMsg;
	private String testPoint;

	@PersistenceConstructor
	public B15HSGGTJYRLCX(ObjectId id, int functionid, String row, String rzfs, String rzxx, String rznr,
			String access_token, String qqhs, String dwc, String wlrq, String zzrq, String jysdm, String isExcute,
			String type, String expectMsg, String testPoint) {
		super();
		this.id = id;
		this.functionid = functionid;
		this.row = row;
		this.rzfs = rzfs;
		this.rzxx = rzxx;
		this.rznr = rznr;
		this.access_token = access_token;
		this.qqhs = qqhs;
		this.dwc = dwc;
		this.wlrq = wlrq;
		this.zzrq = zzrq;
		this.jysdm = jysdm;
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

	public String getRzxx() {
		return rzxx;
	}

	public void setRzxx(String rzxx) {
		this.rzxx = rzxx;
	}

	public String getRznr() {
		return rznr;
	}

	public void setRznr(String rznr) {
		this.rznr = rznr;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getQqhs() {
		return qqhs;
	}

	public void setQqhs(String qqhs) {
		this.qqhs = qqhs;
	}

	public String getDwc() {
		return dwc;
	}

	public void setDwc(String dwc) {
		this.dwc = dwc;
	}

	public String getWlrq() {
		return wlrq;
	}

	public void setWlrq(String wlrq) {
		this.wlrq = wlrq;
	}

	public String getZzrq() {
		return zzrq;
	}

	public void setZzrq(String zzrq) {
		this.zzrq = zzrq;
	}

	public String getJysdm() {
		return jysdm;
	}

	public void setJysdm(String jysdm) {
		this.jysdm = jysdm;
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
