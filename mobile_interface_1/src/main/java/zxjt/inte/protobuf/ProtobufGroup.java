package zxjt.inte.protobuf;

public class ProtobufGroup {
	
	public static void gz_type_group(Protobuf.stock_details_data stockDetailsData)
	{
		Protobuf.gz_type_group gz_type_group = stockDetailsData.getGzTypes();
		System.out.println("gqzr_type:"+gz_type_group.getGqzrType());
		System.out.println("lwts_type:"+gz_type_group.getLwtsType());
		System.out.println("gzfc_type:"+gz_type_group.getGzfcType());
		System.out.println("yxg_type:"+gz_type_group.getYxgType());
		System.out.println("****************");
    	System.out.println("****************");
	}

}
