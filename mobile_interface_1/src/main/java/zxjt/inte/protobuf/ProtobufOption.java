package zxjt.inte.protobuf;

public class ProtobufOption {
	public static void rank_option(Protobuf.multiStocks_rep  multiStocksRep)
	{
		Protobuf.rank_option  rankOption =multiStocksRep.getOptions();
    	System.out.println("wType: "+rankOption.getWType());
    	System.out.println("bSort:" + rankOption.getBSort());
    	System.out.println("bDirect:" + rankOption.getBDirect());
    	System.out.println("wFrom:" + rankOption.getWFrom());
    	System.out.println("wCount:" + rankOption.getWCount());
    	System.out.println("fields_bitMap:"+ rankOption.getFieldsBitMap());
    	System.out.println("wTotalCount:"+ rankOption.getWTotalCount());
    	
    	System.out.println("****************");
    	System.out.println("****************");
	}
}
