package zxjt.intfc.common.protobuf;

import zxjt.intfc.common.util.LogUtils;

public class ProtobufGroup {

	public static void gz_type_group(Protobuf.stock_details_data stockDetailsData)
	{
		Protobuf.gz_type_group gz_type_group = stockDetailsData.getGzTypes();
		LogUtils.logInfo("gqzr_type:"+gz_type_group.getGqzrType());
		LogUtils.logInfo("lwts_type:"+gz_type_group.getLwtsType());
		LogUtils.logInfo("gzfc_type:"+gz_type_group.getGzfcType());
		LogUtils.logInfo("yxg_type:"+gz_type_group.getYxgType());
		LogUtils.logInfo("****************");
		LogUtils.logInfo("****************");
	}

}
