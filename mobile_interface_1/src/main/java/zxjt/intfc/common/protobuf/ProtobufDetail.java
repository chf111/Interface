package zxjt.intfc.common.protobuf;

import java.util.Map;

import zxjt.intfc.common.constant.ParamConstant;
import zxjt.intfc.common.util.JsonAssertUtil;
import zxjt.intfc.common.util.LogUtils;

public class ProtobufDetail {
	public static void extend_details(Protobuf.stock_details_data stockDetailsData, Map<String, String> regexMap)
	{
		Protobuf.extend_details extend_details = stockDetailsData.getExtD();
		if (regexMap.keySet().contains(ParamConstant.MA_PRICE)) {
			LogUtils.logInfo("ma_price:"+extend_details.getMaPrice());
			JsonAssertUtil.assertRegex(ParamConstant.MA_PRICE, String.valueOf(extend_details.getMaPrice()),
					regexMap.get(ParamConstant.MA_PRICE));
		}
		if (regexMap.keySet().contains(ParamConstant.WB)) {
			LogUtils.logInfo("wb:"+extend_details.getWb());
			JsonAssertUtil.assertRegex(ParamConstant.WB, String.valueOf(extend_details.getWb()),
					regexMap.get(ParamConstant.WB));
		}
		if (regexMap.keySet().contains(ParamConstant.WC)) {
			LogUtils.logInfo("wc:"+extend_details.getWc());
			JsonAssertUtil.assertRegex(ParamConstant.WC, String.valueOf(extend_details.getWc()),
					regexMap.get(ParamConstant.WC));
		}
		if (regexMap.keySet().contains(ParamConstant.JZC)) {
			LogUtils.logInfo("jzc:"+extend_details.getJzc());
			JsonAssertUtil.assertRegex(ParamConstant.JZC, String.valueOf(extend_details.getJzc()),
					regexMap.get(ParamConstant.JZC));
		}
		if (regexMap.keySet().contains(ParamConstant.SJL)) {
			LogUtils.logInfo("sjl:"+extend_details.getSjl());
			JsonAssertUtil.assertRegex(ParamConstant.SJL, String.valueOf(extend_details.getSjl()),
					regexMap.get(ParamConstant.SJL));
		}
		if (regexMap.keySet().contains(ParamConstant.SY)) {
			LogUtils.logInfo("sy:"+extend_details.getSy());
			JsonAssertUtil.assertRegex(ParamConstant.SY, String.valueOf(extend_details.getSy()),
					regexMap.get(ParamConstant.SY));
		}
		if (regexMap.keySet().contains(ParamConstant.QUARTER)) {
			LogUtils.logInfo("quarter:"+extend_details.getQuarter());
			JsonAssertUtil.assertRegex(ParamConstant.QUARTER, String.valueOf(extend_details.getQuarter()),
					regexMap.get(ParamConstant.QUARTER));
		}
		if (regexMap.keySet().contains(ParamConstant.LTG)) {
			LogUtils.logInfo("ltg:"+extend_details.getLtg());
			JsonAssertUtil.assertRegex(ParamConstant.LTG, String.valueOf(extend_details.getLtg()),
					regexMap.get(ParamConstant.LTG));
		}
		if (regexMap.keySet().contains(ParamConstant.SYLJ)) {
			LogUtils.logInfo("sylj:"+extend_details.getSylj());
			JsonAssertUtil.assertRegex(ParamConstant.SYLJ, String.valueOf(extend_details.getSylj()),
					regexMap.get(ParamConstant.SYLJ));
		}
		if (regexMap.keySet().contains(ParamConstant.ZGB)) {
			LogUtils.logInfo("zgb:"+extend_details.getZgb());
			JsonAssertUtil.assertRegex(ParamConstant.ZGB, String.valueOf(extend_details.getZgb()),
					regexMap.get(ParamConstant.ZGB));
		}
		LogUtils.logInfo("****************");
    	LogUtils.logInfo("****************");
	}
}