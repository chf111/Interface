package zxjt.intfc.entity.trade.ggt;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testdata")
public class B00HSGGTCCCX {

	@Id
	private ObjectId id;
	private int functionid;
	private String row;
	private String jysdm;
	private String cxfx;
	private String qqhs;
	private String dwc;
	private String isExcute;
	private String type;
	private String expectMsg;
	private String testPoint;

	@PersistenceConstructor
	public B00HSGGTCCCX(ObjectId id, int functionid, String row, String jysdm, String cxfx, String qqhs, String dwc,
			String isExcute, String type, String expectMsg, String testPoint) {
		super();
		this.id = id;
		this.functionid = functionid;
		this.row = row;
		this.jysdm = jysdm;
		this.cxfx = cxfx;
		this.qqhs = qqhs;
		this.dwc = dwc;
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
