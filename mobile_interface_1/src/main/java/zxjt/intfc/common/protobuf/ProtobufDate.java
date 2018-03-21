package zxjt.intfc.common.protobuf;

import zxjt.intfc.common.util.LogUtils;

public class ProtobufDate {

	public static void available_date(Protobuf.stock_details_data stockDetailsData)
	{
		Protobuf.available_date available_date = stockDetailsData.getAd();
		LogUtils.logInfo("date:"+available_date.getDate());
		LogUtils.logInfo("day_of_week:"+available_date.getDayOfWeek());
		LogUtils.logInfo("****************");
		LogUtils.logInfo("****************");
	}
}
