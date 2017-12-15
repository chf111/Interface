package zxjt.inte.protobuf;

import java.util.List;

public class protobufData {

	public static void stock_tradeClassify_data(
			Protobuf.stock_tradeClassify_data_repeated stock_tradeClassify_data_repeated) {
		List<Protobuf.stock_tradeClassify_data> stock_tradeClassify_data = stock_tradeClassify_data_repeated
				.getTradeClassifyDataList();
		for (Protobuf.stock_tradeClassify_data data : stock_tradeClassify_data) {
			System.out.println("nBjg:" + data.getNBjg());
			System.out.println("nBsl:" + data.getNBsl());
			System.out.println("nSjg:" + data.getNSjg());
			System.out.println("nSsl:" + data.getNSsl());
			
			System.out.println("****************");
        	System.out.println("****************");
		}
	}
	
	public static void hgt_cv_data(Protobuf.stock_details_data stockDetailsData)
	{
		Protobuf.hgt_cv_data hgt_cv_data = stockDetailsData.getHcd();
		System.out.println("startTime:"+hgt_cv_data.getStartTime());
		System.out.println("endTime:"+hgt_cv_data.getEndTime());
		System.out.println("vcm_refPrice:"+hgt_cv_data.getVcmRefPrice());
		System.out.println("vcm_lowPrice:"+hgt_cv_data.getVcmLowPrice());
		System.out.println("vcm_upPrice:"+hgt_cv_data.getVcmUpPrice());
		System.out.println("cas_refPrice:"+hgt_cv_data.getCasRefPrice());
		System.out.println("cas_lowPrice:"+hgt_cv_data.getCasLowPrice());
		System.out.println("cas_upPrice:"+hgt_cv_data.getCasUpPrice());
		System.out.println("direction:"+hgt_cv_data.getDirection());
		System.out.println("qty:"+hgt_cv_data.getQty());
		System.out.println("****************");
    	System.out.println("****************");
	}
	
	public static void stock_details_data(Protobuf.multiStocks_rep  multiStocksRep) 
	{
		List<Protobuf.stock_details_data> listStockData=multiStocksRep.getDataArrList();
		for(Protobuf.stock_details_data stockDetailsData : listStockData)
    	{
    		System.out.println("marketID:"+stockDetailsData.getMarketID());//市场代码（默认下发）
    		System.out.println("stock_code:"+stockDetailsData.getStockCode());//证券代码（默认下发）
    		System.out.println("stock_name:" + stockDetailsData.getStockName()+ "byte:" +stockDetailsData.getStockNameBytes());//证券名称（默认下发）
    		System.out.println("pszMark:" + stockDetailsData.getPszMark());//特殊股票表示：港股:HK, 沪港通:HGT, 融资融券:R（默认下发）
    		System.out.println("wType:" + stockDetailsData.getWType());
    		System.out.println("nZrsp:" + stockDetailsData.getNZrsp());
    		System.out.println("nJrkp:" + stockDetailsData.getNJrkp());
    		System.out.println("nZgcj:" + stockDetailsData.getNZgcj());
    		System.out.println("nZdcj:" + stockDetailsData.getNZdcj());
    		System.out.println("nZjcj:" + stockDetailsData.getNZjcj());
    		System.out.println("nCjss:" + stockDetailsData.getNCjss());
    		System.out.println("nZf:" + stockDetailsData.getNZf());
    		System.out.println("nCjje:" + stockDetailsData.getNCjje());
    		System.out.println("nBjg1:" + stockDetailsData.getNBjg1());
    		System.out.println("nSjg1:" + stockDetailsData.getNSjg1());
    		System.out.println("nBsl1:" + stockDetailsData.getNBsl1());
    		System.out.println("nSsl1:" + stockDetailsData.getNSsl1());
    		System.out.println("nZd:" + stockDetailsData.getNZd());
    		System.out.println("nZdf:" + stockDetailsData.getNZdf());
    		System.out.println("nLb:" + stockDetailsData.getNLb());
    		System.out.println("n5Min:" + stockDetailsData.getN5Min());
    		System.out.println("bSuspended:" + stockDetailsData.getBSuspended());
    		System.out.println("nHsl:" + stockDetailsData.getNHsl());
    		System.out.println("nSyl:" + stockDetailsData.getNSyl());
    		System.out.println("new_name:" + stockDetailsData.getNewName());
    		System.out.println("wStockStatus:" + stockDetailsData.getWStockStatus());
    		System.out.println("wZjs:" + stockDetailsData.getWZjs());
    		System.out.println("wDjs:" + stockDetailsData.getWDjs());
    		System.out.println("wPjs:" + stockDetailsData.getWPjs());
    		System.out.println("nLTP:" + stockDetailsData.getNLTP());
    		System.out.println("nZSZ:" + stockDetailsData.getNZSZ());
    		System.out.println("nRqSj:" + stockDetailsData.getNRqSj());
    		System.out.println("ExercisePrice:" + stockDetailsData.getExercisePrice());
    		System.out.println("TotalLongPosition:" + stockDetailsData.getTotalLongPosition());
    		System.out.println("cangCha:" + stockDetailsData.getCangCha());
    		System.out.println("ContractMultiplierUnit:" + stockDetailsData.getContractMultiplierUnit());
    		System.out.println("SurplusDays:" + stockDetailsData.getSurplusDays());
    		System.out.println("option_flag:" + stockDetailsData.getOptionFlag() );
    		System.out.println("nLimUp:" + stockDetailsData.getNLimUp());
    		System.out.println("nLimDown:" + stockDetailsData.getNLimDown());
    		System.out.println("wCYDZS:" + stockDetailsData.getWCYDZS());
    		System.out.println("stock_tradeClassify_data_repeated tradeClassify_data_arr::::::" );
    		ProtobufRepeated.stock_tradeClassify_data_repeated(stockDetailsData);
    		System.out.println("blockID:" + stockDetailsData.getBlockID());
    		System.out.println("blockName:" + stockDetailsData.getBlockName());
    		System.out.println("blockZDF:" + stockDetailsData.getBlockZDF());
    		System.out.println("hgt_cv_data hcd:::::::");
    		protobufData.hgt_cv_data(stockDetailsData);
    		System.out.println("gz_type_group gz_types::::::" );
    		ProtobufGroup.gz_type_group(stockDetailsData);
    		System.out.println("week_num:" + stockDetailsData.getWeekNum());
    		System.out.println("repurchase_name:" + stockDetailsData.getRepurchaseName());
    		System.out.println("APY:" + stockDetailsData.getAPY());
    		System.out.println("earnings:" + stockDetailsData.getEarnings());
    		System.out.println("is_ggt_object:" + stockDetailsData.getIsGgtObject());
    		System.out.println("available_date ad:::::");
    		ProtobufDate.available_date(stockDetailsData);
    		System.out.println("extend_details ext_d ::::");
    		ProtobufDetail.extend_details(stockDetailsData);
 
    		System.out.println("****************");
        	System.out.println("****************");
    	}
	}
}
