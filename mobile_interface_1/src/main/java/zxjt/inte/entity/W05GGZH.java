package zxjt.inte.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testdata")
public class W05GGZH {

	@Id
	private ObjectId id;
	private int functionid;
	private String row;
	private String wMarketID;
	private String sPszCode;
	private String wType;
	private String fieldsBitMap;
	
	private String wKXType;
	private String dwKXDate;
	private String dwKXTime;
	private String wKXCount;
	private String wFQType;
	private String dwFSDate;
	private String dwFSTime;
	private String count;
	private String isExcute;
	private String type;
	private String expectMsg;
	private String testPoint;

	@PersistenceConstructor
	public W05GGZH(ObjectId id, int functionid, String row, String wMarketID, String sPszCode, String wType,
			String fieldsBitMap, String wKXType, String dwKXDate, String dwKXTime, String wKXCount, String wFQType,
			String dwFSDate, String dwFSTime, String count, String isExcute, String type, String expectMsg,
			String testPoint) {
		super();
		this.id = id;
		this.functionid = functionid;
		this.row = row;
		this.wMarketID = wMarketID;
		this.sPszCode = sPszCode;
		this.wType = wType;
		this.fieldsBitMap = fieldsBitMap;
		this.wKXType = wKXType;
		this.dwKXDate = dwKXDate;
		this.dwKXTime = dwKXTime;
		this.wKXCount = wKXCount;
		this.wFQType = wFQType;
		this.dwFSDate = dwFSDate;
		this.dwFSTime = dwFSTime;
		this.count = count;
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

	public String getwMarketID() {
		return wMarketID;
	}

	public void setwMarketID(String wMarketID) {
		this.wMarketID = wMarketID;
	}

	public String getsPszCode() {
		return sPszCode;
	}

	public void setsPszCode(String sPszCode) {
		this.sPszCode = sPszCode;
	}

	public String getwType() {
		return wType;
	}

	public void setwType(String wType) {
		this.wType = wType;
	}

	public String getFieldsBitMap() {
		return fieldsBitMap;
	}

	public void setFieldsBitMap(String fieldsBitMap) {
		this.fieldsBitMap = fieldsBitMap;
	}

	public String getDwFSDate() {
		return dwFSDate;
	}

	public void setDwFSDate(String dwFSDate) {
		this.dwFSDate = dwFSDate;
	}
	public String getwKXType() {
		return wKXType;
	}

	public void setwKXType(String wKXType) {
		this.wKXType = wKXType;
	}

	public String getDwKXDate() {
		return dwKXDate;
	}

	public void setDwKXDate(String dwKXDate) {
		this.dwKXDate = dwKXDate;
	}

	public String getDwKXTime() {
		return dwKXTime;
	}

	public void setDwKXTime(String dwKXTime) {
		this.dwKXTime = dwKXTime;
	}

	public String getwKXCount() {
		return wKXCount;
	}

	public void setwKXCount(String wKXCount) {
		this.wKXCount = wKXCount;
	}

	public String getwFQType() {
		return wFQType;
	}

	public void setwFQType(String wFQType) {
		this.wFQType = wFQType;
	}

	public String getDwFSTime() {
		return dwFSTime;
	}

	public void setDwFSTime(String dwFSTime) {
		this.dwFSTime = dwFSTime;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
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
