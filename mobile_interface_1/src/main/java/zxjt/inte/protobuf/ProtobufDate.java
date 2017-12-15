package zxjt.inte.protobuf;

public class ProtobufDate {

	public static void available_date(Protobuf.stock_details_data stockDetailsData)
	{
		Protobuf.available_date available_date = stockDetailsData.getAd();
		System.out.println("date:"+available_date.getDate());
		System.out.println("day_of_week:"+available_date.getDayOfWeek());
		System.out.println("****************");
    	System.out.println("****************");
	}
}
