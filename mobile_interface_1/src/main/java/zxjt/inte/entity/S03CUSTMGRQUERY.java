package zxjt.inte.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testdata")
public class S03CUSTMGRQUERY {

	@Id
	private ObjectId id;
	private int functionid;
	private String row;
	private String custId;
	private String fundId;
	private String maxRow;
	private String netaddr;
	private String netaddr2;
	private String operway;
	private String page;
	private String startRow;
	private String sysName;
	private String user_id;

	private String isExcute;
	private String type;
	private String expectMsg;
	private String testPoint;

	@PersistenceConstructor
	public S03CUSTMGRQUERY(ObjectId id, int functionid, String row, String custId, String fundId, String maxRow,
			String netaddr, String netaddr2, String operway, String page, String startRow, String sysName,
			String user_id, String isExcute, String type, String expectMsg, String testPoint) {
		super();
		this.id = id;
		this.functionid = functionid;
		this.row = row;
		this.custId = custId;
		this.fundId = fundId;
		this.maxRow = maxRow;
		this.netaddr = netaddr;
		this.netaddr2 = netaddr2;
		this.operway = operway;
		this.page = page;
		this.startRow = startRow;
		this.sysName = sysName;
		this.user_id = user_id;
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

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getMaxRow() {
		return maxRow;
	}

	public void setMaxRow(String maxRow) {
		this.maxRow = maxRow;
	}

	public String getNetaddr() {
		return netaddr;
	}

	public void setNetaddr(String netaddr) {
		this.netaddr = netaddr;
	}

	public String getNetaddr2() {
		return netaddr2;
	}

	public void setNetaddr2(String netaddr2) {
		this.netaddr2 = netaddr2;
	}

	public String getOperway() {
		return operway;
	}

	public void setOperway(String operway) {
		this.operway = operway;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getStartRow() {
		return startRow;
	}

	public void setStartRow(String startRow) {
		this.startRow = startRow;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
