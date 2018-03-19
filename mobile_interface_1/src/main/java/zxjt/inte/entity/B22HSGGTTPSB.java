package zxjt.inte.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testdata")
public class B22HSGGTTPSB {

	@Id
	private ObjectId id;
	private int functionid;
	private String row;
	private String rzfs;
	private String rzxx;
	private String rznr;
	private String access_token;
	private String zqdm;
	private String jysdm;
	private String gddm;
	private String ggbh;
	private String yabh;
	private String zcps;
	private String fdps;
	private String qqps;
	private String jgbm;
	private String sgtywlx;
	private String sgtsblx;
	private String isExcute;
	private String type;
	private String expectMsg;
	private String testPoint;

	@PersistenceConstructor
	public B22HSGGTTPSB(ObjectId id, int functionid, String row, String rzfs, String rzxx, String rznr,
			String access_token, String zqdm, String jysdm, String gddm, String ggbh, String yabh, String zcps,
			String fdps, String qqps, String jgbm, String sgtywlx, String sgtsblx, String isExcute, String type,
			String expectMsg, String testPoint) {
		super();
		this.id = id;
		this.functionid = functionid;
		this.row = row;
		this.rzfs = rzfs;
		this.rzxx = rzxx;
		this.rznr = rznr;
		this.access_token = access_token;
		this.zqdm = zqdm;
		this.jysdm = jysdm;
		this.gddm = gddm;
		this.ggbh = ggbh;
		this.yabh = yabh;
		this.zcps = zcps;
		this.fdps = fdps;
		this.qqps = qqps;
		this.jgbm = jgbm;
		this.sgtywlx = sgtywlx;
		this.sgtsblx = sgtsblx;
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

	public String getGgbh() {
		return ggbh;
	}

	public void setGgbh(String ggbh) {
		this.ggbh = ggbh;
	}

	public String getYabh() {
		return yabh;
	}

	public void setYabh(String yabh) {
		this.yabh = yabh;
	}

	public String getZcps() {
		return zcps;
	}

	public void setZcps(String zcps) {
		this.zcps = zcps;
	}

	public String getFdps() {
		return fdps;
	}

	public void setFdps(String fdps) {
		this.fdps = fdps;
	}

	public String getQqps() {
		return qqps;
	}

	public void setQqps(String qqps) {
		this.qqps = qqps;
	}

	public String getJgbm() {
		return jgbm;
	}

	public void setJgbm(String jgbm) {
		this.jgbm = jgbm;
	}

	public String getSgtywlx() {
		return sgtywlx;
	}

	public void setSgtywlx(String sgtywlx) {
		this.sgtywlx = sgtywlx;
	}

	public String getSgtsblx() {
		return sgtsblx;
	}

	public void setSgtsblx(String sgtsblx) {
		this.sgtsblx = sgtsblx;
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
