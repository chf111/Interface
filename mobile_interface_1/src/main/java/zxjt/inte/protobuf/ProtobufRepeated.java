package zxjt.inte.protobuf;

public class ProtobufRepeated {
	
	public static void stock_tradeClassify_data_repeated(Protobuf.stock_details_data stockDetailsData)
	{
		Protobuf.stock_tradeClassify_data_repeated stock_tradeClassify_data_repeated = stockDetailsData.getTradeClassifyDataArr();
		protobufData.stock_tradeClassify_data(stock_tradeClassify_data_repeated);
		ProtobufPair.price_volume_pair(stock_tradeClassify_data_repeated);
	}

}
