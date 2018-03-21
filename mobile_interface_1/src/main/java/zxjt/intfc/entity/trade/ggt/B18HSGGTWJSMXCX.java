package zxjt.intfc.entity.trade.ggt;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testdata")
public class B18HSGGTWJSMXCX {

	@Id
	private ObjectId id;
	private int functionid;
	private String row;
	private String rzfs;
	private String rzxx;
	private String rznr;
	private String access_token;
	private String cxfx;
	private String qqhs;
	private String dwc;
	private String zqdm;
	private String gddm;
	private String jysdm;
	private String isExcute;
	private String type;
	private String expectMsg;
	private String testPoint;

	@PersistenceConstructor
	public B18HSGGTWJSMXCX(ObjectId id, int functionid, String row, String rzfs, String rzxx, String rznr,
			String access_token, String cxfx, String qqhs, String dwc, String zqdm, String gddm, String jysdm,
			String isExcute, String type, String expectMsg, String testPoint) {
		super();
		this.id = id;
		this.functionid = functionid;
		this.row = row;
		this.rzfs = rzfs;
		this.rzxx = rzxx;
		this.rznr = rznr;
		this.access_token = access_token;
		this.cxfx = cxfx;
		this.qqhs = qqhs;
		this.dwc = dwc;
		this.zqdm = zqdm;
		this.gddm = gddm;
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

	public String getCxfx() {
		return cxfx;
	}

	public void setCxfx(String cxfx) {
		this.cxfx = cxfx;
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

	public String getZqdm() {
		return zqdm;
	}

	public void setZqdm(String zqdm) {
		this.zqdm = zqdm;
	}

	public String getGddm() {
		return gddm;
	}

	public void setGddm(String gddm) {
		this.gddm = gddm;
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
