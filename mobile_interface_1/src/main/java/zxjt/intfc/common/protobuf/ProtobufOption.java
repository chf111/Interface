package zxjt.intfc.common.protobuf;

import java.util.Map;

import zxjt.intfc.common.constant.ParamConstant;
import zxjt.intfc.common.util.JsonAssertUtil;
import zxjt.intfc.common.util.LogUtils;

public class ProtobufOption {


	public static void rank_option(Protobuf.multiStocks_rep multiStocksRep, Map<String, String> regexMap) {
		Protobuf.rank_option rankOption = multiStocksRep.getOptions();
		LogUtils.logInfo("wType: " + rankOption.getWType());
		JsonAssertUtil.assertRegex(ParamConstant.WTYPE, String.valueOf(rankOption.getWType()),
				regexMap.get(ParamConstant.WTYPE));
		LogUtils.logInfo("bSort:" + rankOption.getBSort());
		JsonAssertUtil.assertRegex(ParamConstant.BSORT, String.valueOf(rankOption.getBSort()),
				regexMap.get(ParamConstant.BSORT));
		LogUtils.logInfo("bDirect:" + rankOption.getBDirect());
		JsonAssertUtil.assertRegex(ParamConstant.BDIRECT, String.valueOf(rankOption.getBDirect()),
				regexMap.get(ParamConstant.BDIRECT));
		LogUtils.logInfo("wFrom:" + rankOption.getWFrom());
		JsonAssertUtil.assertRegex(ParamConstant.WFROM, String.valueOf(rankOption.getWFrom()),
				regexMap.get(ParamConstant.WFROM));
		LogUtils.logInfo("wCount:" + rankOption.getWCount());
		JsonAssertUtil.assertRegex(ParamConstant.WCOUNT, String.valueOf(rankOption.getWCount()),
				regexMap.get(ParamConstant.WCOUNT));
		LogUtils.logInfo("fields_bitMap:" + rankOption.getFieldsBitMap());
		JsonAssertUtil.assertRegex(ParamConstant.FIELDSBITMAP, String.valueOf(rankOption.getFieldsBitMap()),
				regexMap.get(ParamConstant.FIELDSBITMAP));
		if (regexMap.keySet().contains(ParamConstant.WTOTALCOUNT)) {
			LogUtils.logInfo("wTotalCount:" + rankOption.getWTotalCount());
			JsonAssertUtil.assertRegex(ParamConstant.WTOTALCOUNT, String.valueOf(rankOption.getWTotalCount()),
					regexMap.get(ParamConstant.WTOTALCOUNT));
		}
		if (regexMap.keySet().contains(ParamConstant.BLOCKCLASSNAME)) {
			LogUtils.logInfo("blockClassName:" + rankOption.getBlockClassName());
			JsonAssertUtil.assertRegex(ParamConstant.BLOCKCLASSNAME, rankOption.getBlockClassName(),
					regexMap.get(ParamConstant.BLOCKCLASSNAME));
		}
		LogUtils.logInfo("****************");
		LogUtils.logInfo("****************");
	}

	public static void rank_option(Protobuf.blockRank_rep blockRankRep, Map<String, String> regexMap) {
		Protobuf.rank_option rankOption = blockRankRep.getOptions();
		LogUtils.logInfo("wType: " + rankOption.getWType());
		JsonAssertUtil.assertRegex(ParamConstant.WTYPE, String.valueOf(rankOption.getWType()),
				regexMap.get(ParamConstant.WTYPE));
		LogUtils.logInfo("bSort:" + rankOption.getBSort());
		JsonAssertUtil.assertRegex(ParamConstant.BSORT, String.valueOf(rankOption.getBSort()),
				regexMap.get(ParamConstant.BSORT));
		LogUtils.logInfo("bDirect:" + rankOption.getBDirect());
		JsonAssertUtil.assertRegex(ParamConstant.BDIRECT, String.valueOf(rankOption.getBDirect()),
				regexMap.get(ParamConstant.BDIRECT));
		LogUtils.logInfo("wFrom:" + rankOption.getWFrom());
		JsonAssertUtil.assertRegex(ParamConstant.WFROM, String.valueOf(rankOption.getWFrom()),
				regexMap.get(ParamConstant.WFROM));
		LogUtils.logInfo("wCount:" + rankOption.getWCount());
		JsonAssertUtil.assertRegex(ParamConstant.WCOUNT, String.valueOf(rankOption.getWCount()),
				regexMap.get(ParamConstant.WCOUNT));
		LogUtils.logInfo("fields_bitMap:" + rankOption.getFieldsBitMap());
		JsonAssertUtil.assertRegex(ParamConstant.FIELDSBITMAP, String.valueOf(rankOption.getFieldsBitMap()),
				regexMap.get(ParamConstant.FIELDSBITMAP));
		if (regexMap.keySet().contains(ParamConstant.WTOTALCOUNT)) {
			LogUtils.logInfo("wTotalCount:" + rankOption.getWTotalCount());
			JsonAssertUtil.assertRegex(ParamConstant.WTOTALCOUNT, String.valueOf(rankOption.getWTotalCount()),
					regexMap.get(ParamConstant.WTOTALCOUNT));
		}
		if (regexMap.keySet().contains(ParamConstant.BLOCKCLASSNAME)) {
			LogUtils.logInfo("blockClassName:" + rankOption.getBlockClassName());
			JsonAssertUtil.assertRegex(ParamConstant.BLOCKCLASSNAME, rankOption.getBlockClassName(),
					regexMap.get(ParamConstant.BLOCKCLASSNAME));
		}
		LogUtils.logInfo("****************");
		LogUtils.logInfo("****************");
	}
}