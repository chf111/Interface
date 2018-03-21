package zxjt.intfc.entity.common;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
public class CommonAddress {

	@Id
	private ObjectId id;
	private int functionid;
	private String url;
	private String desc;

	@PersistenceConstructor
	public CommonAddress(ObjectId id, int functionid, String url, String desc) {
		super();
		this.id = id;
		this.functionid = functionid;
		this.url = url;
		this.desc = desc;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
