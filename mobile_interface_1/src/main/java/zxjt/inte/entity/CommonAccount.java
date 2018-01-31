package zxjt.inte.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class CommonAccount {

	@Id
	private ObjectId id;
	private String khbz;
	private String jymm;
	private String khbzlx;
	private String lhxx;
	private String sessionid;
	private String token;
	private String yybdm;
	private String gddm_ha;
	private String gddm_sb;
	private String gddm_hb;
	private String gddm_sa;
	private String gddm_gza;

	@PersistenceConstructor
	public CommonAccount(ObjectId id, String khbz, String jymm, String khbzlx, String lhxx, String sessionid,
			String token, String yybdm, String gddm_ha, String gddm_sb, String gddm_hb, String gddm_sa,
			String gddm_gza) {
		super();
		this.id = id;
		this.khbz = khbz;
		this.jymm = jymm;
		this.khbzlx = khbzlx;
		this.lhxx = lhxx;
		this.sessionid = sessionid;
		this.token = token;
		this.yybdm = yybdm;
		this.gddm_ha = gddm_ha;
		this.gddm_sb = gddm_sb;
		this.gddm_hb = gddm_hb;
		this.gddm_sa = gddm_sa;
		this.gddm_gza = gddm_gza;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getKhbz() {
		return khbz;
	}

	public void setKhbz(String khbz) {
		this.khbz = khbz;
	}

	public String getJymm() {
		return jymm;
	}

	public void setJymm(String jymm) {
		this.jymm = jymm;
	}

	public String getKhbzlx() {
		return khbzlx;
	}

	public void setKhbzlx(String khbzlx) {
		this.khbzlx = khbzlx;
	}

	public String getLhxx() {
		return lhxx;
	}

	public void setLhxx(String lhxx) {
		this.lhxx = lhxx;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getYybdm() {
		return yybdm;
	}

	public void setYybdm(String yybdm) {
		this.yybdm = yybdm;
	}

	public String getGddm_ha() {
		return gddm_ha;
	}

	public void setGddm_ha(String gddm_ha) {
		this.gddm_ha = gddm_ha;
	}

	public String getGddm_sb() {
		return gddm_sb;
	}

	public void setGddm_sb(String gddm_sb) {
		this.gddm_sb = gddm_sb;
	}

	public String getGddm_hb() {
		return gddm_hb;
	}

	public void setGddm_hb(String gddm_hb) {
		this.gddm_hb = gddm_hb;
	}

	public String getGddm_sa() {
		return gddm_sa;
	}

	public void setGddm_sa(String gddm_sa) {
		this.gddm_sa = gddm_sa;
	}

	public String getGddm_gza() {
		return gddm_gza;
	}

	public void setGddm_gza(String gddm_gza) {
		this.gddm_gza = gddm_gza;
	}

}
