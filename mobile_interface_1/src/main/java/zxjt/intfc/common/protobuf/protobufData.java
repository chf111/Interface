package zxjt.intfc.common.protobuf;

import java.util.List;
import java.util.Map;

import zxjt.intfc.common.constant.ParamConstant;
import zxjt.intfc.common.util.JsonAssertUtil;
import zxjt.intfc.common.util.LogUtils;

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

	public static void hgt_cv_data(Protobuf.stock_details_data stockDetailsData) {
		Protobuf.hgt_cv_data hgt_cv_data = stockDetailsData.getHcd();
		System.out.println("startTime:" + hgt_cv_data.getStartTime());
		System.out.println("endTime:" + hgt_cv_data.getEndTime());
		System.out.println("vcm_refPrice:" + hgt_cv_data.getVcmRefPrice());
		System.out.println("vcm_lowPrice:" + hgt_cv_data.getVcmLowPrice());
		System.out.println("vcm_upPrice:" + hgt_cv_data.getVcmUpPrice());
		System.out.println("cas_refPrice:" + hgt_cv_data.getCasRefPrice());
		System.out.println("cas_lowPrice:" + hgt_cv_data.getCasLowPrice());
		System.out.println("cas_upPrice:" + hgt_cv_data.getCasUpPrice());
		System.out.println("direction:" + hgt_cv_data.getDirection());
		System.out.println("qty:" + hgt_cv_data.getQty());
		System.out.println("****************");
		System.out.println("****************");
	}

	public static void stock_details_data(Protobuf.multiStocks_rep multiStocksRep, Map<String, String> regexMap) {
		List<Protobuf.stock_details_data> listStockData = multiStocksRep.getDataArrList();
		for (Protobuf.stock_details_data stockDetailsData : listStockData) {
			if (regexMap.keySet().contains(ParamConstant.STOCK_CODE)) {
				LogUtils.logInfo("stock_code:" + stockDetailsData.getStockCode());// 证券代码（默认下发）
				JsonAssertUtil.assertRegex(ParamConstant.STOCK_CODE, stockDetailsData.getStockCode(),
						regexMap.get(ParamConstant.STOCK_CODE));
			}
			if (regexMap.keySet().contains(ParamConstant.STOCK_NAME)) {
				LogUtils.logInfo("stock_name:" + stockDetailsData.getStockName());// 证券名称（默认下发）
				JsonAssertUtil.assertRegex(ParamConstant.STOCK_NAME, stockDetailsData.getStockName(),
						regexMap.get(ParamConstant.STOCK_NAME));
			}
			if (regexMap.keySet().contains(ParamConstant.MARKETID)) {
				LogUtils.logInfo("marketID:" + stockDetailsData.getMarketID());// 市场代码（默认下发）
				JsonAssertUtil.assertRegex(ParamConstant.MARKETID, String.valueOf(stockDetailsData.getMarketID()),
						regexMap.get(ParamConstant.MARKETID));
			}
			if (regexMap.keySet().contains(ParamConstant.PSZMARK)) {
				LogUtils.logInfo("pszMark:" + stockDetailsData.getPszMark());// 特殊股票表示：港股:HK, 沪港通:HGT, 融资融券:R（默认下发）
				JsonAssertUtil.assertRegex(ParamConstant.PSZMARK, stockDetailsData.getPszMark(),
						regexMap.get(ParamConstant.PSZMARK));
			}

			if (regexMap.keySet().contains(ParamConstant.NZRSP)) {
				LogUtils.logInfo("nZrsp:" + stockDetailsData.getNZrsp());
				JsonAssertUtil.assertRegex(ParamConstant.NZRSP, String.valueOf(stockDetailsData.getNZrsp()),
						regexMap.get(ParamConstant.NZRSP));
			}
			if (regexMap.keySet().contains(ParamConstant.DATAARR_WTYPE)) {
				LogUtils.logInfo("dataArr_wType:" + stockDetailsData.getWType());
				JsonAssertUtil.assertRegex(ParamConstant.DATAARR_WTYPE, String.valueOf(stockDetailsData.getWType()),
						regexMap.get(ParamConstant.DATAARR_WTYPE));
			}

			if (regexMap.keySet().contains(ParamConstant.NJRKP)) {
				LogUtils.logInfo("nJrkp:" + stockDetailsData.getNJrkp());
				JsonAssertUtil.assertRegex(ParamConstant.NJRKP, String.valueOf(stockDetailsData.getNJrkp()),
						regexMap.get(ParamConstant.NJRKP));
			}
			if (regexMap.keySet().contains(ParamConstant.NZJCJ)) {
				LogUtils.logInfo("nZjcj:" + stockDetailsData.getNZjcj());
				JsonAssertUtil.assertRegex(ParamConstant.NZJCJ, String.valueOf(stockDetailsData.getNZjcj()),
						regexMap.get(ParamConstant.NZJCJ));
			}
			if (regexMap.keySet().contains(ParamConstant.NZD)) {
				LogUtils.logInfo("nZd:" + stockDetailsData.getNZd());
				JsonAssertUtil.assertRegex(ParamConstant.NZD, String.valueOf(stockDetailsData.getNZd()),
						regexMap.get(ParamConstant.NZD));
			}
			if (regexMap.keySet().contains(ParamConstant.NZDF)) {
				LogUtils.logInfo("nZdf:" + stockDetailsData.getNZdf());
				JsonAssertUtil.assertRegex(ParamConstant.NZDF, String.valueOf(stockDetailsData.getNZdf()),
						regexMap.get(ParamConstant.NZDF));
			}
			if (regexMap.keySet().contains(ParamConstant.BSUSPENDED)) {
				LogUtils.logInfo("bSuspended:" + stockDetailsData.getBSuspended());
				JsonAssertUtil.assertRegex(ParamConstant.BSUSPENDED, String.valueOf(stockDetailsData.getBSuspended()),
						regexMap.get(ParamConstant.BSUSPENDED));
			}
			if (regexMap.keySet().contains(ParamConstant.NRQSJ)) {
				LogUtils.logInfo("nRqSj:" + stockDetailsData.getNRqSj());
				JsonAssertUtil.assertRegex(ParamConstant.NRQSJ, String.valueOf(stockDetailsData.getNRqSj()),
						regexMap.get(ParamConstant.NRQSJ));
			}
			if (regexMap.keySet().contains(ParamConstant.NLIMUP)) {
				LogUtils.logInfo("nLimUp:" + stockDetailsData.getNLimUp());
				JsonAssertUtil.assertRegex(ParamConstant.NLIMUP, String.valueOf(stockDetailsData.getNLimUp()),
						regexMap.get(ParamConstant.NLIMUP));
			}
			if (regexMap.keySet().contains(ParamConstant.NLIMDOWN)) {
				LogUtils.logInfo("nLimDown:" + stockDetailsData.getNLimDown());
				JsonAssertUtil.assertRegex(ParamConstant.NLIMDOWN, String.valueOf(stockDetailsData.getNLimDown()),
						regexMap.get(ParamConstant.NLIMDOWN));
			}
			if (regexMap.keySet().contains(ParamConstant.BLOCKID)) {
				LogUtils.logInfo("blockID:" + stockDetailsData.getBlockID());
				JsonAssertUtil.assertRegex(ParamConstant.BLOCKID, String.valueOf(stockDetailsData.getBlockID()),
						regexMap.get(ParamConstant.BLOCKID));
			}
			if (regexMap.keySet().contains(ParamConstant.BLOCKNAME)) {
				LogUtils.logInfo("blockName:" + stockDetailsData.getBlockName());
				JsonAssertUtil.assertRegex(ParamConstant.BLOCKNAME, stockDetailsData.getBlockName(),
						regexMap.get(ParamConstant.BLOCKNAME));
			}
			if (regexMap.keySet().contains(ParamConstant.IS_GGT_OBJECT)) {
				LogUtils.logInfo("is_ggt_object:" + stockDetailsData.getIsGgtObject());
				JsonAssertUtil.assertRegex(ParamConstant.IS_GGT_OBJECT,
						String.valueOf(stockDetailsData.getIsGgtObject()), regexMap.get(ParamConstant.IS_GGT_OBJECT));
			}
			if (regexMap.keySet().contains(ParamConstant.NZGCJ)) {
				LogUtils.logInfo("nZgcj:" + stockDetailsData.getNZgcj());
				JsonAssertUtil.assertRegex(ParamConstant.NZGCJ, String.valueOf(stockDetailsData.getNZgcj()),
						regexMap.get(ParamConstant.NZGCJ));
			}
			if (regexMap.keySet().contains(ParamConstant.NZDCJ)) {
				LogUtils.logInfo("nZdcj:" + stockDetailsData.getNZdcj());
				JsonAssertUtil.assertRegex(ParamConstant.NZDCJ, String.valueOf(stockDetailsData.getNZdcj()),
						regexMap.get(ParamConstant.NZDCJ));
			}
			if (regexMap.keySet().contains(ParamConstant.NCJSS)) {
				LogUtils.logInfo("nCjss:" + stockDetailsData.getNCjss());
				JsonAssertUtil.assertRegex(ParamConstant.NCJSS, String.valueOf(stockDetailsData.getNCjss()),
						regexMap.get(ParamConstant.NCJSS));
			}
			if (regexMap.keySet().contains(ParamConstant.NZF)) {
				LogUtils.logInfo("nZf:" + stockDetailsData.getNZf());
				JsonAssertUtil.assertRegex(ParamConstant.NZF, String.valueOf(stockDetailsData.getNZf()),
						regexMap.get(ParamConstant.NZF));
			}
			if (regexMap.keySet().contains(ParamConstant.NCJJE)) {
				LogUtils.logInfo("nCjje:" + stockDetailsData.getNCjje());
				JsonAssertUtil.assertRegex(ParamConstant.NCJJE, String.valueOf(stockDetailsData.getNCjje()),
						regexMap.get(ParamConstant.NCJJE));
			}
			if (regexMap.keySet().contains(ParamConstant.NLB)) {
				LogUtils.logInfo("nLb:" + stockDetailsData.getNLb());
				JsonAssertUtil.assertRegex(ParamConstant.NLB, String.valueOf(stockDetailsData.getNLb()),
						regexMap.get(ParamConstant.NLB));
			}
			if (regexMap.keySet().contains(ParamConstant.N5MIN)) {
				LogUtils.logInfo("n5Min:" + stockDetailsData.getN5Min());
				JsonAssertUtil.assertRegex(ParamConstant.N5MIN, String.valueOf(stockDetailsData.getN5Min()),
						regexMap.get(ParamConstant.N5MIN));
			}
			if (regexMap.keySet().contains(ParamConstant.NHSL)) {
				LogUtils.logInfo("nHsl:" + stockDetailsData.getNHsl());
				JsonAssertUtil.assertRegex(ParamConstant.NHSL, String.valueOf(stockDetailsData.getNHsl()),
						regexMap.get(ParamConstant.NHSL));
			}
			if (regexMap.keySet().contains(ParamConstant.NSYL)) {
				LogUtils.logInfo("nSyl:" + stockDetailsData.getNSyl());
				JsonAssertUtil.assertRegex(ParamConstant.NSYL, String.valueOf(stockDetailsData.getNSyl()),
						regexMap.get(ParamConstant.NSYL));
			}

			LogUtils.logInfo("****************");
			LogUtils.logInfo("****************");

			/** 以下是目前暂未用到的，预留需要时添加 */
			// LogUtils.logInfo("nZgcj:" + stockDetailsData.getNZgcj());
			// LogUtils.logInfo("nBjg1:" + stockDetailsData.getNBjg1());
			// LogUtils.logInfo("nSjg1:" + stockDetailsData.getNSjg1());
			// LogUtils.logInfo("nBsl1:" + stockDetailsData.getNBsl1());
			// LogUtils.logInfo("nSsl1:" + stockDetailsData.getNSsl1());
			// LogUtils.logInfo("new_name:" + stockDetailsData.getNewName());
			// LogUtils.logInfo("wStockStatus:" + stockDetailsData.getWStockStatus());
			// LogUtils.logInfo("wZjs:" + stockDetailsData.getWZjs());
			// LogUtils.logInfo("wDjs:" + stockDetailsData.getWDjs());
			// LogUtils.logInfo("wPjs:" + stockDetailsData.getWPjs());
			// LogUtils.logInfo("nLTP:" + stockDetailsData.getNLTP());
			// LogUtils.logInfo("nZSZ:" + stockDetailsData.getNZSZ());
			// LogUtils.logInfo("ExercisePrice:" + stockDetailsData.getExercisePrice());
			// LogUtils.logInfo("TotalLongPosition:" + stockDetailsData.getTotalLongPosition());
			// LogUtils.logInfo("cangCha:" + stockDetailsData.getCangCha());
			// LogUtils.logInfo("ContractMultiplierUnit:" +
			// stockDetailsData.getContractMultiplierUnit());
			// LogUtils.logInfo("SurplusDays:" + stockDetailsData.getSurplusDays());
			// LogUtils.logInfo("option_flag:" + stockDetailsData.getOptionFlag());
			// LogUtils.logInfo("wCYDZS:" + stockDetailsData.getWCYDZS());
			// LogUtils.logInfo("stock_tradeClassify_data_repeated tradeClassify_data_arr::::::");
			// ProtobufRepeated.stock_tradeClassify_data_repeated(stockDetailsData);
			// LogUtils.logInfo("blockZDF:" + stockDetailsData.getBlockZDF());
			// LogUtils.logInfo("hgt_cv_data hcd:::::::");
			// protobufData.hgt_cv_data(stockDetailsData);
			// LogUtils.logInfo("gz_type_group gz_types::::::");
			// ProtobufGroup.gz_type_group(stockDetailsData);
			// LogUtils.logInfo("week_num:" + stockDetailsData.getWeekNum());
			// LogUtils.logInfo("repurchase_name:" + stockDetailsData.getRepurchaseName());
			// LogUtils.logInfo("APY:" + stockDetailsData.getAPY());
			// LogUtils.logInfo("earnings:" + stockDetailsData.getEarnings());
			// LogUtils.logInfo("available_date ad:::::");
			// ProtobufDate.available_date(stockDetailsData);
			// LogUtils.logInfo("extend_details ext_d ::::");
			// ProtobufDetail.extend_details(stockDetailsData);
		}
	}

	public static void stock_details_data(Protobuf.stock_united_rep stockUnitedRep, Map<String, String> regexMap) {
		Protobuf.stock_details_data stockDetailsData = stockUnitedRep.getDetailsData();

		if (regexMap.keySet().contains(ParamConstant.STOCK_CODE)) {
			LogUtils.logInfo("stock_code:" + stockDetailsData.getStockCode());// 证券代码（默认下发）
			JsonAssertUtil.assertRegex(ParamConstant.STOCK_CODE, stockDetailsData.getStockCode(),
					regexMap.get(ParamConstant.STOCK_CODE));
		}
		if (regexMap.keySet().contains(ParamConstant.STOCK_NAME)) {
			LogUtils.logInfo("stock_name:" + stockDetailsData.getStockName());// 证券名称（默认下发）
			JsonAssertUtil.assertRegex(ParamConstant.STOCK_NAME, stockDetailsData.getStockName(),
					regexMap.get(ParamConstant.STOCK_NAME));
		}
		if (regexMap.keySet().contains(ParamConstant.MARKETID)) {
			LogUtils.logInfo("marketID:" + stockDetailsData.getMarketID());// 市场代码（默认下发）
			JsonAssertUtil.assertRegex(ParamConstant.MARKETID, String.valueOf(stockDetailsData.getMarketID()),
					regexMap.get(ParamConstant.MARKETID));
		}
		if (regexMap.keySet().contains(ParamConstant.PSZMARK)) {
			LogUtils.logInfo("pszMark:" + stockDetailsData.getPszMark());// 特殊股票表示：港股:HK, 沪港通:HGT, 融资融券:R（默认下发）
			JsonAssertUtil.assertRegex(ParamConstant.PSZMARK, stockDetailsData.getPszMark(),
					regexMap.get(ParamConstant.PSZMARK));
		}
		if (regexMap.keySet().contains(ParamConstant.WTYPE)) {
			LogUtils.logInfo("wType:" + stockDetailsData.getWType());
			JsonAssertUtil.assertRegex(ParamConstant.WTYPE, String.valueOf(stockDetailsData.getWType()),
					regexMap.get(ParamConstant.WTYPE));
		}
		if (regexMap.keySet().contains(ParamConstant.NZJCJ)) {
			LogUtils.logInfo("nZjcj:" + stockDetailsData.getNZjcj());
			JsonAssertUtil.assertRegex(ParamConstant.NZJCJ, String.valueOf(stockDetailsData.getNZjcj()),
					regexMap.get(ParamConstant.NZJCJ));
		}
		if (regexMap.keySet().contains(ParamConstant.NZDF)) {
			LogUtils.logInfo("nZdf:" + stockDetailsData.getNZdf());
			JsonAssertUtil.assertRegex(ParamConstant.NZDF, String.valueOf(stockDetailsData.getNZdf()),
					regexMap.get(ParamConstant.NZDF));
		}
		if (regexMap.keySet().contains(ParamConstant.BSUSPENDED)) {
			LogUtils.logInfo("bSuspended:" + stockDetailsData.getBSuspended());
			JsonAssertUtil.assertRegex(ParamConstant.BSUSPENDED, String.valueOf(stockDetailsData.getBSuspended()),
					regexMap.get(ParamConstant.BSUSPENDED));
		}
		if (regexMap.keySet().contains(ParamConstant.NRQSJ)) {
			LogUtils.logInfo("nRqSj:" + stockDetailsData.getNRqSj());
			JsonAssertUtil.assertRegex(ParamConstant.NRQSJ, String.valueOf(stockDetailsData.getNRqSj()),
					regexMap.get(ParamConstant.NRQSJ));
		}
		if (regexMap.keySet().contains(ParamConstant.BLOCKID)) {
			LogUtils.logInfo("blockID:" + stockDetailsData.getBlockID());
			JsonAssertUtil.assertRegex(ParamConstant.BLOCKID, String.valueOf(stockDetailsData.getBlockID()),
					regexMap.get(ParamConstant.BLOCKID));
		}
		if (regexMap.keySet().contains(ParamConstant.BLOCKNAME)) {
			LogUtils.logInfo("blockName:" + stockDetailsData.getBlockName());
			JsonAssertUtil.assertRegex(ParamConstant.BLOCKNAME, stockDetailsData.getBlockName(),
					regexMap.get(ParamConstant.BLOCKNAME));
		}
		if (regexMap.keySet().contains(ParamConstant.IS_GGT_OBJECT)) {
			LogUtils.logInfo("is_ggt_object:" + stockDetailsData.getIsGgtObject());
			JsonAssertUtil.assertRegex(ParamConstant.IS_GGT_OBJECT, String.valueOf(stockDetailsData.getIsGgtObject()),
					regexMap.get(ParamConstant.IS_GGT_OBJECT));
		}
		if (regexMap.keySet().contains(ParamConstant.BLOCKZDF)) {
			LogUtils.logInfo("blockZDF:" + stockDetailsData.getBlockZDF());
			JsonAssertUtil.assertRegex(ParamConstant.BLOCKZDF, String.valueOf(stockDetailsData.getBlockZDF()),
					regexMap.get(ParamConstant.BLOCKZDF));
		}
		LogUtils.logInfo("extend_details ext_d ::::");
		ProtobufDetail.extend_details(stockDetailsData, regexMap);

		LogUtils.logInfo("****************");
		LogUtils.logInfo("****************");
		/** 以下是目前暂未用到的，预留需要时添加 */
		// LogUtils.logInfo("nZrsp:" + stockDetailsData.getNZrsp());
		// LogUtils.logInfo("nJrkp:" + stockDetailsData.getNJrkp());
		// LogUtils.logInfo("nZgcj:" + stockDetailsData.getNZgcj());
		// LogUtils.logInfo("nZdcj:" + stockDetailsData.getNZdcj());
		// LogUtils.logInfo("nCjss:" + stockDetailsData.getNCjss());
		// LogUtils.logInfo("nZf:" + stockDetailsData.getNZf());
		// LogUtils.logInfo("nCjje:" + stockDetailsData.getNCjje());
		// LogUtils.logInfo("nBjg1:" + stockDetailsData.getNBjg1());
		// LogUtils.logInfo("nSjg1:" + stockDetailsData.getNSjg1());
		// LogUtils.logInfo("nBsl1:" + stockDetailsData.getNBsl1());
		// LogUtils.logInfo("nSsl1:" + stockDetailsData.getNSsl1());
		// LogUtils.logInfo("nZd:" + stockDetailsData.getNZd());
		// LogUtils.logInfo("nLb:" + stockDetailsData.getNLb());
		// LogUtils.logInfo("n5Min:" + stockDetailsData.getN5Min());
		// LogUtils.logInfo("nHsl:" + stockDetailsData.getNHsl());
		// LogUtils.logInfo("nSyl:" + stockDetailsData.getNSyl());
		// LogUtils.logInfo("new_name:" + stockDetailsData.getNewName());
		// LogUtils.logInfo("wStockStatus:" + stockDetailsData.getWStockStatus());
		// LogUtils.logInfo("wZjs:" + stockDetailsData.getWZjs());
		// LogUtils.logInfo("wDjs:" + stockDetailsData.getWDjs());
		// LogUtils.logInfo("wPjs:" + stockDetailsData.getWPjs());
		// LogUtils.logInfo("nLTP:" + stockDetailsData.getNLTP());
		// LogUtils.logInfo("nZSZ:" + stockDetailsData.getNZSZ());
		// LogUtils.logInfo("ExercisePrice:" + stockDetailsData.getExercisePrice());
		// LogUtils.logInfo("TotalLongPosition:" + stockDetailsData.getTotalLongPosition());
		// LogUtils.logInfo("cangCha:" + stockDetailsData.getCangCha());
		// LogUtils.logInfo("ContractMultiplierUnit:" +
		// stockDetailsData.getContractMultiplierUnit());
		// LogUtils.logInfo("SurplusDays:" + stockDetailsData.getSurplusDays());
		// LogUtils.logInfo("option_flag:" + stockDetailsData.getOptionFlag());
		// LogUtils.logInfo("nLimUp:" + stockDetailsData.getNLimUp());
		// LogUtils.logInfo("nLimDown:" + stockDetailsData.getNLimDown());
		// LogUtils.logInfo("wCYDZS:" + stockDetailsData.getWCYDZS());
		// LogUtils.logInfo("stock_tradeClassify_data_repeated tradeClassify_data_arr::::::");
		// ProtobufRepeated.stock_tradeClassify_data_repeated(stockDetailsData);
		// LogUtils.logInfo("hgt_cv_data hcd:::::::");
		// protobufData.hgt_cv_data(stockDetailsData);
		// LogUtils.logInfo("gz_type_group gz_types::::::");
		// ProtobufGroup.gz_type_group(stockDetailsData);
		// LogUtils.logInfo("week_num:" + stockDetailsData.getWeekNum());
		// LogUtils.logInfo("repurchase_name:" + stockDetailsData.getRepurchaseName());
		// LogUtils.logInfo("APY:" + stockDetailsData.getAPY());
		// LogUtils.logInfo("earnings:" + stockDetailsData.getEarnings());
		// LogUtils.logInfo("available_date ad:::::");
		// ProtobufDate.available_date(stockDetailsData);
	}

	public static void stock_kline_data(Protobuf.stock_kline_rep stockKlineRep) {
		List<Protobuf.stock_kline_data> stockKlineDataList = stockKlineRep.getKlineDataArrList();
		for (Protobuf.stock_kline_data stockKlineData : stockKlineDataList) {
			System.out.println("nDate:" + stockKlineData.getNDate());
			System.out.println("nTime:" + stockKlineData.getNTime());
			System.out.println("nYClose:" + stockKlineData.getNYClose());
			System.out.println("nOpen:" + stockKlineData.getNOpen());
			System.out.println("nZgcj:" + stockKlineData.getNZgcj());
			System.out.println("nZdcj:" + stockKlineData.getNZdcj());
			System.out.println("nClose:" + stockKlineData.getNClose());
			System.out.println("nZdf:" + stockKlineData.getNZdf());
			System.out.println("nCjje:" + stockKlineData.getNCjje());
			System.out.println("nCjss:" + stockKlineData.getNCjss());
			System.out.println("nCcl:" + stockKlineData.getNCcl());
			System.out.println("nZd:" + stockKlineData.getNZd());

			List<Integer> nMAList = stockKlineData.getNMAList();
			for (int i : nMAList) {
				System.out.println("nMA:" + i);
			}
			System.out.println("nTech:" + stockKlineData.getNTechList());
			System.out.println("nHsl:" + stockKlineData.getNHsl());
			System.out.println("nZf:" + stockKlineData.getNZf());

			System.out.println("****************");
			System.out.println("****************");
		}
	}

	public static void stock_timeDivision_data(Protobuf.stock_timeDivision_rep stockTimeDivisionRep,
			Map<String, String> regexMap) {
		List<Protobuf.stock_timeDivision_data> stockTimeDivisionDataList = stockTimeDivisionRep.getDataArrList();
		for (Protobuf.stock_timeDivision_data stockTimeDivisionData : stockTimeDivisionDataList) {
			if (regexMap.keySet().contains(ParamConstant.NTIME)) {
				LogUtils.logInfo("nTime:" + stockTimeDivisionData.getNTime());
				JsonAssertUtil.assertRegex(ParamConstant.NTIME, String.valueOf(stockTimeDivisionData.getNTime()),
						regexMap.get(ParamConstant.NTIME));
			}
			if (regexMap.keySet().contains(ParamConstant.TIMEDIVISION_NZJCJ)) {
				LogUtils.logInfo("timeDivision_nZjcj:" + stockTimeDivisionData.getNZjcj());
				JsonAssertUtil.assertRegex(ParamConstant.TIMEDIVISION_NZJCJ,
						String.valueOf(stockTimeDivisionData.getNZjcj()),
						regexMap.get(ParamConstant.TIMEDIVISION_NZJCJ));
			}
			if (regexMap.keySet().contains(ParamConstant.TIMEDIVISION_NZDF)) {
				LogUtils.logInfo("timeDivision_nZdf:" + stockTimeDivisionData.getNZdf());
				JsonAssertUtil.assertRegex(ParamConstant.TIMEDIVISION_NZDF,
						String.valueOf(stockTimeDivisionData.getNZdf()), regexMap.get(ParamConstant.TIMEDIVISION_NZDF));
			}
			if (regexMap.keySet().contains(ParamConstant.NCJSS)) {
				LogUtils.logInfo("nCjss:" + stockTimeDivisionData.getNCjss());
				JsonAssertUtil.assertRegex(ParamConstant.NCJSS, String.valueOf(stockTimeDivisionData.getNCjss()),
						regexMap.get(ParamConstant.NCJSS));
			}

			if (regexMap.keySet().contains(ParamConstant.NCJJE)) {
				LogUtils.logInfo("nCjje:" + stockTimeDivisionData.getNCjje());
				JsonAssertUtil.assertRegex(ParamConstant.NCJJE, String.valueOf(stockTimeDivisionData.getNCjje()),
						regexMap.get(ParamConstant.NCJJE));
			}
			if (regexMap.keySet().contains(ParamConstant.NCJJJ)) {
				LogUtils.logInfo("nCjjj:" + stockTimeDivisionData.getNCjjj());
				JsonAssertUtil.assertRegex(ParamConstant.NCJJJ, String.valueOf(stockTimeDivisionData.getNCjjj()),
						regexMap.get(ParamConstant.NCJJJ));
			}
			if (regexMap.keySet().contains(ParamConstant.NDATE)) {
				LogUtils.logInfo("nDate:" + stockTimeDivisionData.getNDate());
				JsonAssertUtil.assertRegex(ParamConstant.NDATE, String.valueOf(stockTimeDivisionData.getNDate()),
						regexMap.get(ParamConstant.NDATE));
			}
			if (regexMap.keySet().contains(ParamConstant.NZD)) {
				LogUtils.logInfo("nZd:" + stockTimeDivisionData.getNZd());
				JsonAssertUtil.assertRegex(ParamConstant.NZD, String.valueOf(stockTimeDivisionData.getNZd()),
						regexMap.get(ParamConstant.NZD));
			}
			LogUtils.logInfo("****************");
			LogUtils.logInfo("****************");
			/** 以下是目前暂未用到的，预留需要时添加 */
			// if (regexMap.keySet().contains(ParamConstant.NPOS)) {
			// LogUtils.logInfo("nPos:" + stockTimeDivisionData.getNPos());
			// JsonAssertUtil.assertRegex(ParamConstant.NPOS,
			// String.valueOf(stockTimeDivisionData.getNPos()),
			// regexMap.get(ParamConstant.NPOS));
			// }
		}
	}

	public static void stock_tradeDetail_data(Protobuf.stock_tradeDetail_rep stockTradeDetailRep,
			Map<String, String> regexMap) {
		List<Protobuf.stock_tradeDetail_data> stockTradeDetailDataList = stockTradeDetailRep.getDataArrList();
		for (Protobuf.stock_tradeDetail_data stockTradeDetailData : stockTradeDetailDataList) {
			if (regexMap.keySet().contains(ParamConstant.DWTIME)) {
				LogUtils.logInfo("dwTime:" + stockTradeDetailData.getDwTime());
				JsonAssertUtil.assertRegex(ParamConstant.DWTIME, String.valueOf(stockTradeDetailData.getDwTime()),
						regexMap.get(ParamConstant.DWTIME));
			}
			if (regexMap.keySet().contains(ParamConstant.BCJLB)) {
				LogUtils.logInfo("bCjlb:" + stockTradeDetailData.getBCjlb());
				JsonAssertUtil.assertRegex(ParamConstant.BCJLB, stockTradeDetailData.getBCjlb(),
						regexMap.get(ParamConstant.BCJLB));
			}
			if (regexMap.keySet().contains(ParamConstant.TRADEDETAIL_NZJCJ)) {
				LogUtils.logInfo("tradeDetail_nZjcj:" + stockTradeDetailData.getNZjcj());
				JsonAssertUtil.assertRegex(ParamConstant.TRADEDETAIL_NZJCJ,
						String.valueOf(stockTradeDetailData.getNZjcj()), regexMap.get(ParamConstant.TRADEDETAIL_NZJCJ));
			}
			if (regexMap.keySet().contains(ParamConstant.TRADEDETAIL_NCJSS)) {
				LogUtils.logInfo("tradeDetail_nCjss:" + stockTradeDetailData.getNCjss());
				JsonAssertUtil.assertRegex(ParamConstant.TRADEDETAIL_NCJSS,
						String.valueOf(stockTradeDetailData.getNCjss()), regexMap.get(ParamConstant.TRADEDETAIL_NCJSS));
			}
			LogUtils.logInfo("****************");
			LogUtils.logInfo("****************");
			/** 以下是目前暂未用到的，预留需要时添加 */
			// LogUtils.logInfo("nCjje:" + stockTradeDetailData.getNCjje());
		}
	}
}