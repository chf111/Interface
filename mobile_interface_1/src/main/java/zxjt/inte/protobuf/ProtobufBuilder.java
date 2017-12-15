package zxjt.inte.protobuf;

import java.util.Map;

import zxjt.inte.util.ParamConstant;

public class ProtobufBuilder {

	public static Protobuf.selectedStocks_req.Builder selectedStocks_req(Map<String,String> map) 
	{
		
		Protobuf.selectedStocks_req.Builder selectedStocksBuilder= Protobuf.selectedStocks_req.newBuilder();
		selectedStocksBuilder.setPszCodes(map.get(ParamConstant.PSZCODES));//代码链
		selectedStocksBuilder.setMarketList(map.get(ParamConstant.MARKETLIST));//市场链
		selectedStocksBuilder.setOptions(rank_option(map));//结构体
		return selectedStocksBuilder;
	}
	
	public static Protobuf.rank_option.Builder rank_option(Map<String,String> map)
	{
		Protobuf.rank_option.Builder rankOptionBuilder = Protobuf.rank_option.newBuilder();
		rankOptionBuilder.setWType(Integer.valueOf(map.get(ParamConstant.WTYPE)));//排序类型//板块排行时表示板块类别ID，传0时由服务器配置决定所下发的版块排行
		rankOptionBuilder.setBSort(Integer.valueOf(map.get(ParamConstant.BSORT)));//排序字段
		rankOptionBuilder.setBDirect(Boolean.valueOf(map.get(ParamConstant.BDIRECT)));//0升序，1降序
		rankOptionBuilder.setWFrom(Integer.valueOf(map.get(ParamConstant.WFROM)));//起始位置
		rankOptionBuilder.setWCount(Integer.valueOf(map.get(ParamConstant.WCOUNT)));//请求数量
		rankOptionBuilder.setFieldsBitMap(Long.valueOf(map.get(ParamConstant.FIELDSBITMAP)));//需要字段的位图
		return rankOptionBuilder;
	}
}
