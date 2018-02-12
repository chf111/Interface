package zxjt.inte.util;

/**
 * 常量
 * 
 * @author Administrator
 *
 */
public interface ParamConstant {

	/**
	 * ************************************************************
	 * ***********************正反例标识 **************************
	 **********************************************************/
	public static final String ZL = "zl";
	public static final String FL = "fl";

	/**
	 * ************************************************************
	 * ***********************大业务分类 **************************
	 **********************************************************/
	public static final String PTYW = "PTYW";
	public static final String RZRQ = "RZRQ";
	public static final String WW = "WW";

	/**
	 * ************************************************************
	 * ****************json schema文件的名称 **************************
	 **********************************************************/
	public static final String SCHEMA_ZL = "_schema";
	public static final String SCHEMA_FL = "fail_schema";
	public static final String A00_SCHEMA = "普通交易_普通业务_客户校验";
	public static final String A01_SCHEMA = "普通交易_普通业务_委托下单";
	public static final String A02_SCHEMA = "普通交易_普通业务_可买卖数量查询";
	public static final String A03_SCHEMA = "普通交易_普通业务_市价可买卖数量查询";
	public static final String W06_SCHEMA = "代码云查询";
	public static final String W00_SCHEMA = "自选股行情查询";
	public static final String W01_SCHEMA = "代码链查询";
	public static final String W02_SCHEMA = "板块排行";
	public static final String W03_SCHEMA = "股票排行";
	public static final String W04_SCHEMA = "板块排行索引";
	public static final String W05_SCHEMA = "个股综合";
	public static final String B00_SCHEMA = "沪深港股通_普通业务_持仓查询";
	public static final String B01_SCHEMA = "沪深港股通_普通业务_交易状态信息查询";
	public static final String B02_SCHEMA = "沪深港股通_普通业务_可买卖数量查询";
	public static final String B03_SCHEMA = "沪深港股通_普通业务_资金查询";
	public static final String B04_SCHEMA = "沪深港股通_普通业务_当日委托查询";
	public static final String B05_SCHEMA = "沪深港股通_普通业务_当日成交查询";
	public static final String B06_SCHEMA = "沪深港股通_普通业务_历史委托查询";
	public static final String B07_SCHEMA = "沪深港股通_普通业务_历史成交查询";
	public static final String B08_SCHEMA = "沪深港股通_普通业务_委托下单";
	public static final String B09_SCHEMA = "沪深港股通_普通业务_委托撤单";

	/**
	 * ************************************************************
	 * ***********************url对应的ID号 **************************
	 **********************************************************/
	public static final int PTJYLOGIN_ID = 2;
	public static final int GPMM_ID = 1;
	public static final int KMMXXCX_ID = 4;
	public static final int SJKMMXXCX_ID = 5;
	
	public static final int HSGGT_CCCX_ID = 6;
	public static final int HSGGT_JYZTXXCX_ID = 7;
	public static final int HSGGT_KMMSLCX_ID = 8;
	public static final int HSGGT_ZJCX_ID = 9;
	public static final int HSGGT_DRWTCX_ID = 10;
	public static final int HSGGT_DRCJCX_ID = 11;
	public static final int HSGGT_LSWTCX_ID = 12;
	public static final int HSGGT_LSCJCX_ID = 13;
	public static final int HSGGT_WTXD_ID = 14;
	public static final int HSGGT_WTCD_ID = 15;
	
	public static final int HQZXGHQ_ID = 3;
	public static final int DML_ID = 16;
	public static final int BKPH_ID = 17;
	public static final int GPPH_ID = 18;
	public static final int BKPHINDEX_ID = 19;
	public static final int GGZH_ID = 20;
	public static final int YCX_ID = 21;
	
	
	public static final int LEVEL2_AUTH = 22;

	/**
	 * ************************************************************
	 * ***********************其他用到的自定义参数 **************************
	 **********************************************************/
	public static final String MESSAGE = "message";
	public static final String VALIDATEPARAM = "validateParam";
	public static final String MEHTOD = "method";
	public static final String LOGGER = "zxjtInterface";
	public static final String URL = "url";
	public static final String ONEMONTH = "一个月内";
	public static final String THREEMONTH = "三个月内";
	public static final String SERVICE = "service";
	
	

	/**
	 * ************************************************************
	 * ***********************自选股查询/股票排行的参数**************************
	 **********************************************************/
	public static final String PSZCODES = "pszCodes";
	public static final String MARKETLIST = "marketList";
	public static final String WTYPE = "wType";
	public static final String BSORT = "bSort";
	public static final String BDIRECT = "bDirect";
	public static final String WFROM = "wFrom";
	public static final String WCOUNT = "wCount";
	public static final String FIELDSBITMAP = "fieldsBitMap";
	public static final String WTOTALCOUNT = "wTotalCount";
	public static final String BLOCKCLASSNAME = "blockClassName";

	public static final String MARKETID = "marketID";
	public static final String STOCK_CODE = "stock_code";
	public static final String STOCK_NAME = "stock_name";
	public static final String NZRSP = "nZrsp";
	public static final String NJRKP = "nJrkp";
	public static final String NZJCJ = "nZjcj";
	public static final String NZD = "nZd";
	public static final String NZDF = "nZdf";
	public static final String BSUSPENDED = "bSuspended";
	public static final String NRQSJ = "nRqSj";
	public static final String NLIMUP = "nLimUp";
	public static final String NLIMDOWN = "nLimDown";
	public static final String BLOCKID = "blockID";
	public static final String BLOCKNAME = "blockName";
	public static final String IS_GGT_OBJECT = "is_ggt_object";

	 public static final String NZGCJ ="nZgcj";
	 public static final String NZDCJ ="nZdcj";
	 public static final String NCJSS ="nCjss";
	 public static final String NZF ="nZf";
	 public static final String NCJJE ="nCjje";
	 public static final String NLB ="nLb";
	 public static final String N5MIN ="n5Min";
	 public static final String NHSL ="nHsl";
	 public static final String NSYL ="nSyl";
	 public static final String DATAARR_WTYPE ="dataArr_wType";
	 
	 
	// public static final int nBjg1 =nBjg1;
	// public static final int nSjg1 =nSjg1;
	// public static final int nBsl1 =nBsl1;
	// public static final int nSsl1 =nSsl1;
	//
	
	
	//
	
	
	// public static final String new_name =new_name;
	// public static final int wStockStatus =wStockStatus;
	// public static final int wZjs =wZjs;
	// public static final int wDjs =wDjs;
	// public static final int wPjs =wPjs;
	// public static final int nLTP =nLTP;
	// public static final int nZSZ =nZSZ;
	//
	// public static final int ExercisePrice =ExercisePrice;
	// public static final int TotalLongPosition =TotalLongPosition;
	// public static final int cangCha =cangCha;
	// public static final int ContractMultiplierUn=;
	// public static final int SurplusDays =;
	// public static final String option_flag =;

	// public static final int wCYDZS =;

	// public static final int blockZDF =;
	// public static final int week_num =;
	// public static final String repurchase_name =;
	// public static final int APY =;
	// public static final int earnings =;

	/**
	 * ************************************************************
	 * ***********************不同业务的urlkey值**************************
	 **********************************************************/
	public static final String SAFEURL = "httpsurl";
	public static final String UNSAFEURL = "httpurl";

	/**
	 * ************************************************************
	 * ***********************代码链/全市场代码表查询用到的入参**************************
	 **********************************************************/
	public static final String VERSION = "version";
	public static final String UUIDVERSION = "uuidVersion";
	public static final String MARKET_ID = "market_id";
	public static final String CODE_TYPE = "code_type";
	public static final String CODELIST_ADD_REPEATED_CODE = "codeList_add_repeated_code";
	public static final String PINYIN = "pinyin";
	public static final String PSZMARK = "pszMark";
	public static final String NAME = "name";
	public static final String CODELIST_DEL_REPEATED_CODE = "codeList_del_repeated_code";

	/**
	 * ************************************************************
	 * ***********************板块排行查询用到的入参**************************
	 **********************************************************/
	public static final String FZDF = "fZdf";
	public static final String SCODE = "sCode";
	public static final String PSZBKNAME = "pszBkName";
	public static final String SSTOCKCODE = "sStockCode";
	public static final String PSZSTOCKNAME = "pszStockName";
	public static final String FIRST_ZDF = "first_zdf";
	public static final String FIRST_PRICE = "first_price";
	
	
	/**
	 * ************************************************************
	 * ***********************股票排行查询用到的入参**************************
	 **********************************************************/
	public static final String WMARKETID = "wMarketID";
	public static final String SBKCODE = "sBKCode";

	/**
	 * ************************************************************
	 * ***********************个股综合用到的入参**************************
	 **********************************************************/
	// public static final String WMARKETID= "wMarketID";(与股票排行参数一致)
	public static final String SPSZCODE = "sPszCode";
	// public static final String WTYPE= "wType";(与rankoption参数一致)
	// public static final String FIELDSBITMAP= "fieldsBitMap";(与rankoption参数一致)
	public static final String WKXTYPE = "wKXType";
	public static final String DWKXDATE = "dwKXDate";
	public static final String DWKXTIME = "dwKXTime";
	public static final String WKXCOUNT = "wKXCount";
	public static final String WFQTYPE = "wFQType";
	public static final String REQNEWKLINES = "reqNewKlines";
	public static final String DWFSDATE = "dwFSDate";
	public static final String DWFSTIME = "dwFSTime";
	public static final String COUNT = "count";
	
	 public static final String BLOCKZDF ="blockZDF";
	 public static final String MA_PRICE ="ma_price";
	 public static final String WB ="wb";
	 public static final String WC ="wc";
	 public static final String JZC ="jzc";
	 public static final String SJL ="sjl";
	 public static final String SY ="sy";
	 public static final String QUARTER ="quarter";
	 public static final String LTG ="ltg";
	 public static final String SYLJ ="sylj";
	 public static final String ZGB ="zgb";
	 public static final String NMAXVOL ="nMaxVol";
	 public static final String NTIME ="nTime";
	 public static final String TIMEDIVISION_NZJCJ ="timeDivision_nZjcj";
	 public static final String TIMEDIVISION_NZDF ="timeDivision_nZdf";
	 public static final String NCJJJ ="nCjjj";
	 public static final String NDATE ="nDate";
	 public static final String NBUYP ="nBuyp";
	 public static final String NSELP ="nSelp";
	 public static final String DWTIME ="dwTime";
	 public static final String BCJLB ="bCjlb";
	 public static final String TRADEDETAIL_NZJCJ ="tradeDetail_nZjcj";
	 public static final String TRADEDETAIL_NCJSS ="tradeDetail_nCjss";

	/**
	 * ************************************************************
	 * ***********************正则表达式的参数**************************
	 **********************************************************/
	public static final String REGEXBEGIN = "^";
	public static final String REGEXEND = "$";
	
	/**
	 * ************************************************************
	 * ***********************沪深港股通的参数**************************
	 **********************************************************/
	public static final String SGT = "9";
	public static final String HGT = "6";
	public static final String BUY = "B";
	public static final String SELL = "S";
	
	public static final String JYSDM = "jysdm";
	public static final String ZQDM = "zqdm";
	public static final String WTLX = "wtlx";
	public static final String YYBDM = "yybdm";
	public static final String QSRQ = "qsrq";
	public static final String ZZRQ = "zzrq";
	public static final String WTRQ = "wtrq";
	public static final String CJRQ = "cjrq";
	public static final String GDDM = "gddm";
	public static final String WTJG = "wtjg";
	public static final String MMLB = "mmlb";
	public static final String WTSX = "wtsx";
	public static final String WTSL = "wtsl";
	public static final String EXPECTMSG = "expectMsg";
	public static final String WTXH = "wtxh";
	public static final String TYPE = "type";
	public static final String KHBZ = "khbz";
	public static final String GGTMM_KEY = "港股通买卖";
	
	
	public static final String KMMXX_JYSDM = "kmmxx_jysdm";
	public static final String KMMXX_ZQDM = "kmmxx_zqdm";
	public static final String KMMXX_KMSL = "kmmxx_kmsl";
	public static final String CXLB_GXRQ = "cxlb_gxrq";
	public static final String ZJLB_YYBDM = "zjlb_yybdm";
	public static final String CXLB_WTRQ = "cxlb_wtrq";
	public static final String KMMXX_GFKYS = "kmmxx_gfkys";
	
	public static final String KMSL_S = "^$|^[0-9]+$";
	public static final String KMSL_H = "^[0-9]+$";

	/**
	 * ************************************************************
	 * ***带有依赖接口的接口分类，命名规则为当前源代码命名中大写首字母部分**************************
	 **********************************************************/
	public static final String GPMM = "gpmm";
	public static final String HSGGT = "hsggt";
	
	/**
	 * ************************************************************
	 * *******************message**************************
	 **********************************************************/
	public static final String ERR01 = "买卖类别只能是B或S，请检查测试数据！";
	public static final String ERR02 = "该交易市场“";
	public static final String ERR03 = "”下无可撤单数据，请重新准备测试数据进行测试！";
	public static final String ERR04 = "接口返回响应字段“";
	public static final String ERR05 = "”的值“";
	public static final String ERR06 = "”不符合正则表达式“";
	public static final String ERR07 = "”!";
	public static final String ERR08 = "测试数据类型缺失，请查证后再执行！";
	public static final String ERR09 = "查询结果中该条数据：“";
	public static final String ERR10 = "”的日期不属于本次查询范围内";
	public static final String ERR11 = "接口返回0条数据!";
	public static final String ERR12 = "接口返回值为null!";
	public static final String ERR13 = "接口响应字符串中，节点：";
	public static final String ERR14 = " 的内容为空";
	public static final String ERR15 = "接口响应字段所属类型超出设计范围，请修正代码后再执行！";
}
