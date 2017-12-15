package zxjt.inte.protobuf;

public class ProtobufDetail {
	
	public static void extend_details(Protobuf.stock_details_data stockDetailsData)
	{
		Protobuf.extend_details extend_details = stockDetailsData.getExtD();
		System.out.println("ma_price:"+extend_details.getMaPrice());
		System.out.println("wb:"+extend_details.getWb());
		System.out.println("wc:"+extend_details.getWc());
		System.out.println("jzc:"+extend_details.getJzc());
		System.out.println("sjl:"+extend_details.getSjl());
		System.out.println("sy:"+extend_details.getSy());
		System.out.println("quarter:"+extend_details.getQuarter());
		System.out.println("ltg:"+extend_details.getLtg());
		System.out.println("sylj:"+extend_details.getSylj());
		System.out.println("zgb:"+extend_details.getZgb());
		System.out.println("****************");
    	System.out.println("****************");
	}
}
