package zxjt.inte.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProtobufRep {

	/**
	 * 唯一的响应体
	 * 
	 * @param stream
	 *            响应流
	 */
	public static void multi_selectedStocks_rep(InputStream stream) {
		try {
			Protobuf.multi_selectedStocks_rep response = Protobuf.multi_selectedStocks_rep.parseFrom(stream);
			selectedStocks_rep(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void selectedStocks_rep(Protobuf.multi_selectedStocks_rep response) {
		List<Protobuf.selectedStocks_rep> listres = response.getRepsList();
		for (Protobuf.selectedStocks_rep selectedStocksRep : listres) {
			multiStocks_rep(selectedStocksRep);
		}
	}

	public static void multiStocks_rep(Protobuf.selectedStocks_rep selectedStocksRep) {
		Protobuf.multiStocks_rep multiStocksRep = selectedStocksRep.getRep();
		ProtobufOption.rank_option(multiStocksRep);
		protobufData.stock_details_data(multiStocksRep);
	}
}
