package zxjt.inte.protobuf;

import java.util.Map;

public class ProtobufReq {

	/**
	 * 唯一的请求名称
	 * @param map 要拼接的入参
	 * @return 入参流
	 */
	public static byte[] multi_selectedStocks_req(Map<String,String> map) 
	{
		Protobuf.multi_selectedStocks_req.Builder multiSelectedStocksBuilder = Protobuf.multi_selectedStocks_req.newBuilder();
		multiSelectedStocksBuilder.addReqs(ProtobufBuilder.selectedStocks_req(map));
		Protobuf.multi_selectedStocks_req request = multiSelectedStocksBuilder.build();
		return request.toByteArray();
	}
}
