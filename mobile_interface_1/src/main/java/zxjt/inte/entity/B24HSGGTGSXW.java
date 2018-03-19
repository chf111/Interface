package zxjt.inte.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testdata")
public class B24HSGGTGSXW {

	@Id
	private ObjectId id;
	private int functionid;
	private String row;
	private String rzfs;
	private String rzxx;
	private String rznr;
	private String access_token;
	private String zqdm;
	private String gddm;
	private String jysdm;
	private String jgbm;
	private String tzlb;
	private String ggywlx;
	private String gsxwdm;
	private String ggsblx;
	private String sbsl;
	private String isExcute;
	private String type;
	private String expectMsg;
	private String testPoint;

	@PersistenceConstructor
	public B24HSGGTGSXW(ObjectId id, int functionid, String row, String rzfs, String rzxx, String rznr,
			String access_token, String zqdm, String gddm, String jysdm, String jgbm, String tzlb, String ggywlx,
			String gsxwdm, String ggsblx, String sbsl, String isExcute, String type, String expectMsg,
			String testPoint) {
		super();
		this.id = id;
		this.functionid = functionid;
		this.row = row;
		this.rzfs = rzfs;
		this.rzxx = rzxx;
		this.rznr = rznr;
		this.access_token = access_token;
		this.zqdm = zqdm;
		this.gddm = gddm;
		this.jysdm = jysdm;
		this.jgbm = jgbm;
		this.tzlb = tzlb;
		this.ggywlx = ggywlx;
		this.gsxwdm = gsxwdm;
		this.ggsblx = ggsblx;
		this.sbsl = sbsl;
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

	public String getJgbm() {
		return jgbm;
	}

	public void setJgbm(String jgbm) {
		this.jgbm = jgbm;
	}

	public String getTzlb() {
		return tzlb;
	}

	public void setTzlb(String tzlb) {
		this.tzlb = tzlb;
	}

	public String getGgywlx() {
		return ggywlx;
	}

	public void setGgywlx(String ggywlx) {
		this.ggywlx = ggywlx;
	}

	public String getGsxwdm() {
		return gsxwdm;
	}

	public void setGsxwdm(String gsxwdm) {
		this.gsxwdm = gsxwdm;
	}

	public String getGgsblx() {
		return ggsblx;
	}

	public void setGgsblx(String ggsblx) {
		this.ggsblx = ggsblx;
	}

	public String getSbsl() {
		return sbsl;
	}

	public void setSbsl(String sbsl) {
		this.sbsl = sbsl;
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
