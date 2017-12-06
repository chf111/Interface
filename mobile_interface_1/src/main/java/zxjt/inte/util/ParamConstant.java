package zxjt.inte.util;
/**
 * 常量
 * @author Administrator
 *
 */
public interface ParamConstant {

	
	/** ************************************************************             
	 *  ***********************正反例标识  **************************
	 *  **********************************************************/
	public  static final String ZL = "zl";
	public  static final String FL = "fl";
	
	
	/** ************************************************************             
	 *  ***********************大业务分类  **************************
	 *  **********************************************************/
	public  static final String PTYW = "PTYW";
	public  static final String RZRQ = "RZRQ";
	
	
	/** ************************************************************             
	 *  ****************json schema文件的名称  **************************
	 *  **********************************************************/
	public  static final String SCHEMA_ZL = "_schema";
	public  static final String SCHEMA_FL = "fail_schema";
	public  static final String A00_SCHEMA = "普通交易_普通业务_客户校验";
	public  static final String A01_SCHEMA = "普通交易_普通业务_委托下单";
	public  static final String A01_1_SCHEMA = "普通交易_普通业务_可买卖数量查询";
	public  static final String A01_2_SCHEMA = "普通交易_普通业务_市价可买卖数量查询";

		
	
	/** ************************************************************             
	 *  ***********************url对应的ID号  **************************
	 *  **********************************************************/
	public static final int GPMM_ID = 4885;
	public static final int KMMXXCX_ID = 4906;
	public static final int SJKMMXXCX_ID = 5102;
	public static final int PTJYLOGIN_ID = 4899;
	
	
	/** ************************************************************             
	 *  ***********************其他用到的自定义参数  **************************
	 *  **********************************************************/
	public  static final String MESSAGE = "message";
	public static final String 	VALIDATEPARAM = "validateParam";
	public static final String MEHTOD = "method";
	public static final String LOGGER = "zxjtInterface";
}
