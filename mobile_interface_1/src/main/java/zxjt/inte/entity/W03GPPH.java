package zxjt.inte.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testdata")
public class W03GPPH {

	@Id
	private ObjectId id;
	private int functionid;
	private String row;
	private String wType;
	private String bSort;
	private String bDirect;
	private String wFrom;
	private String wCount;
	private String fieldsBitMap;
	private String wMarketID;
	private String sBKCode;
	private String isExcute;
	private String type;
	private String expectMsg;
	private String testPoint;

	@PersistenceConstructor
	public W03GPPH(ObjectId id, int functionid, String row, String wType, String bSort, String bDirect, String wFrom,
			String wCount, String fieldsBitMap, String wMarketID, String sBKCode, String isExcute, String type,
			String expectMsg, String testPoint) {
		super();
		this.id = id;
		this.functionid = functionid;
		this.row = row;
		this.wType = wType;
		this.bSort = bSort;
		this.bDirect = bDirect;
		this.wFrom = wFrom;
		this.wCount = wCount;
		this.fieldsBitMap = fieldsBitMap;
		this.wMarketID = wMarketID;
		this.sBKCode = sBKCode;
		this.isExcute = isExcute;
		this.type = type;
		this.expectMsg = expectMsg;
		this.testPoint = testPoint;
	}

	public String getwMarketID() {
		return wMarketID;
	}

	public void setwMarketID(String wMarketID) {
		this.wMarketID = wMarketID;
	}

	public String getsBKCode() {
		return sBKCode;
	}

	public void setsBKCode(String sBKCode) {
		this.sBKCode = sBKCode;
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

	public String getwType() {
		return wType;
	}

	public void setwType(String wType) {
		this.wType = wType;
	}

	public String getbSort() {
		return bSort;
	}

	public void setbSort(String bSort) {
		this.bSort = bSort;
	}

	public String getbDirect() {
		return bDirect;
	}

	public void setbDirect(String bDirect) {
		this.bDirect = bDirect;
	}

	public String getwFrom() {
		return wFrom;
	}

	public void setwFrom(String wFrom) {
		this.wFrom = wFrom;
	}

	public String getwCount() {
		return wCount;
	}

	public void setwCount(String wCount) {
		this.wCount = wCount;
	}

	public String getFieldsBitMap() {
		return fieldsBitMap;
	}

	public void setFieldsBitMap(String fieldsBitMap) {
		this.fieldsBitMap = fieldsBitMap;
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
