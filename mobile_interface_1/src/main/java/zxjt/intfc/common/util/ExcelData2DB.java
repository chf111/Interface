package zxjt.intfc.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.everit.json.schema.Schema;
//import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class ExcelData2DB {

	/**
	 * 将excel的值导入到DB中
	 * 
	 * @param file
	 *            本地excel存储路径
	 */
	public static void readFile(File file) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into t_row_ptyw_info(ID,cid,rid,cvalue) values(?,?,?,?)";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/light?useUnicode=true&characterEncoding=utf8", "web", "123123");
			ps = con.prepareStatement(sql);

			// ps.setString(1, student.getNo());
			// ps.setString(2, student.getName());
			// ps.setString(3, student.getAge());
			// ps.setString(4, String.valueOf(student.getScore()));
			// boolean flag = ps.execute();
			Map<String, Integer> map = new HashMap<>();
			map.put("jysdm", 1);
			map.put("gddm", 2);
			map.put("mmlb", 3);
			map.put("zqdm", 4);
			map.put("wtsl", 5);
			map.put("wtjg", 6);
			map.put("wtlx", 7);
			map.put("isExcute", 8);
			map.put("type", 9);
			map.put("expectMsg", 10);
			map.put("testPoint", 11);

			InputStream is = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFCell cell = null;
			// for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets();
			// sheetIndex++) {
			// XSSFSheet st = wb.getSheetAt(sheetIndex);
			int rowid = 925;
			XSSFSheet st = wb.getSheet("普通交易_普通业务_委托下单_ALL");
			for (int rowIndex = 1; rowIndex <= st.getLastRowNum(); rowIndex++) {

				XSSFRow row = st.getRow(rowIndex);
				int column = row.getPhysicalNumberOfCells();
				if (column != map.size()) {
					throw new RuntimeException("excel表格的列长度与数据库存储的列长度不一致！");
				}
				for (int j = 0; j < column; j++) {
					cell = row.getCell(j);
					cell.setCellType(XSSFCell.CELL_TYPE_STRING);
					String cellValue = st.getRow(0).getCell(j).getStringCellValue();
					ps.setInt(1, 4885);
					int cid = map.get(cellValue);
					ps.setInt(2, cid);
					ps.setInt(3, rowid);
					ps.setString(4, cell.getStringCellValue());
					ps.addBatch();
					count += 1;
				}

				if (count > 1000) {
					ps.executeBatch();
					count = 0;
				}
				rowid += 1;
			}
			// }
			ps.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将excel的值导入到DB中
	 * 
	 * @param file
	 *            本地excel存储路径
	 */
	public static void readFile(File file, Boolean b) {

		// 连接服务器端的地址和端口号
		ServerAddress serverAddress;
		try {
			serverAddress = new ServerAddress("localhost", 27017);

			// project数据库的用户名为:proj 密码：proj
			char[] password = "zxjtPass".toCharArray();
			// 创建 用户名和密码认证
			MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("zxjtUser", "zxjt", password);
			List<MongoCredential> mongoCredentialList = new ArrayList<MongoCredential>();
			mongoCredentialList.add(mongoCredential);

			// 连接MongoDB的一个数据库，需要用户名、密码、数据库、服务器端的IP和端口号
			MongoClient mongoClient = new MongoClient(serverAddress, mongoCredentialList);
			DB mongoDatabase = mongoClient.getDB("zxjt");
			DBCollection collection = mongoDatabase.getCollection("testdata");
			List<DBObject> dbObjects = new ArrayList<DBObject>();

			// DBCursor dc = collection.find();
			// while(dc.hasNext())
			// {
			// System.out.println(dc.next());
			// }

			// dc.close();
			// mongoClient.close();
			System.out.println("connect successfully!");

			InputStream is = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFCell cell = null;
			XSSFSheet st = wb.getSheet("沪深港股通_普通业务_委托下单");
			// XSSFSheet st = wb.getSheet("普通交易_普通业务_委托下单_ALL");
			// for (int rowIndex = 1; rowIndex <= 2; rowIndex++) {
			for (int rowIndex = 1; rowIndex <= st.getLastRowNum(); rowIndex++) {

				XSSFRow row = st.getRow(rowIndex);

				DBObject dbObject = new BasicDBObject();
				/**
				 * 股票买卖 dbObject.put("functionid", 1); dbObject.put("row", rowIndex);
				 * dbObject.put("jysdm", st.getRow(rowIndex).getCell(3).getStringCellValue());
				 * dbObject.put("gddm", st.getRow(rowIndex).getCell(2).getStringCellValue());
				 * dbObject.put("mmlb", st.getRow(rowIndex).getCell(4).getStringCellValue());
				 * dbObject.put("zqdm", st.getRow(rowIndex).getCell(8).getStringCellValue());
				 * dbObject.put("wtsl", st.getRow(rowIndex).getCell(7).getStringCellValue());
				 * dbObject.put("wtjg", st.getRow(rowIndex).getCell(5).getStringCellValue());
				 * dbObject.put("wtlx", st.getRow(rowIndex).getCell(6).getStringCellValue());
				 * dbObject.put("isExcute",
				 * st.getRow(rowIndex).getCell(0).getStringCellValue()); dbObject.put("type",
				 * st.getRow(rowIndex).getCell(1).getStringCellValue());
				 * dbObject.put("expectMsg",
				 * st.getRow(rowIndex).getCell(9).getStringCellValue());
				 * dbObject.put("testPoint",
				 * st.getRow(rowIndex).getCell(10).getStringCellValue());
				 */

				dbObject.put("functionid", 14);
				dbObject.put("row", rowIndex);
				dbObject.put("jysdm", st.getRow(rowIndex).getCell(0).getStringCellValue());
				dbObject.put("gddm", st.getRow(rowIndex).getCell(1).getStringCellValue());
				dbObject.put("mmlb", st.getRow(rowIndex).getCell(2).getStringCellValue());
				dbObject.put("zqdm", st.getRow(rowIndex).getCell(3).getStringCellValue());
				dbObject.put("wtsl", st.getRow(rowIndex).getCell(4).getStringCellValue());
				dbObject.put("wtjg", st.getRow(rowIndex).getCell(5).getStringCellValue());
				dbObject.put("wtlx", st.getRow(rowIndex).getCell(6).getStringCellValue());
				dbObject.put("isExcute", st.getRow(rowIndex).getCell(7).getStringCellValue());
				dbObject.put("type", st.getRow(rowIndex).getCell(8).getStringCellValue());
				dbObject.put("expectMsg", st.getRow(rowIndex).getCell(9).getStringCellValue());
				dbObject.put("testPoint", st.getRow(rowIndex).getCell(10).getStringCellValue());
				dbObjects.add(dbObject);
			}
			collection.insert(dbObjects);
			mongoClient.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	// private final static Logger logger =
	// LoggerFactory.getLogger(ExcelData2DB.class);
	public static void main(String[] args) {

		/**
		JSONObject Schema = new JSONObject(
				"{\"type\": \"object\",\"properties\" : {\"foo\" : {\"type\" : \"string\"}}}");
		JSONObject data = new JSONObject("{\"foo\" : \"1212\",\"sss\":2333}");
		Schema schema = SchemaLoader.load(Schema);
		try {
			schema.validate(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
*/
		/**
		 * String s =
		 * "{\"cljg\":[{\"code\":\"MT1B999999\",\"message\":\"[-411511030]-411511030qryflag入参值有误\",\"abcd\":\"MT1B999999\"}]}";
		 * String a = ""; String strjsonSchema = ""; InputStream isIn = null;
		 * BufferedReader br; String line = ""; StringBuilder sb = new StringBuilder();
		 * ExcelData2DB ex; try { ex = ExcelData2DB.class.newInstance(); isIn =
		 * ex.getClass().getResourceAsStream("/json/" + "普通交易_深圳报价回购_历史委托查询fail_schema2"
		 * + ".json"); br = new BufferedReader(new InputStreamReader(isIn, "UTF-8"));
		 * while ((line = br.readLine()) != null) { sb.append(line); strjsonSchema =
		 * sb.toString(); } } catch (Exception e) { e.printStackTrace(); }
		 * JsonAssertUtil.JsonAssert(s, strjsonSchema);
		 **/
		// Date s = CommonToolsUtil.changeStringToDate("20171109 12:01:34:1","yyyyMMdd
		// HH:mm:ss:S");
		// System.out.println(s);
		// W00HQZXGHQServiceImpl qwe = new W00HQZXGHQServiceImpl();
		// Map<String,String> map = new HashMap<>();
		// map.put("expectMsg","正则校验通过");
		// map.put("bDirect","true");
		// map.put("fieldsBitMap","13690212358");
		// map.put("pszCodes","000001,399001,399006");
		// map.put("bSort","0");
		// map.put("type","zl");
		// map.put("wCount","3");
		// map.put("testPoint","获取自选股行情数据");
		// map.put("marketList","2,1,1");
		// map.put("url","http://111.13.63.2:9800/api/quote/pb_selected");
		// map.put("wFrom","0");
		// map.put("isExcute","true");
		// map.put("functionid","3");
		// map.put("row","1");
		// map.put("wType","0");
		// qwe.test(map);

		// LogUtils.logInfo("INFO22222222222 ~");
		// logger.info("logback 成功了");
		// logger.error("logback 成功了");logger.debug("logback 成功了");

		/**
		 * String response =
		 * "{\"cljg\":[{\"code\":\"MP1B000000\",\"message\":\"沪港通证券组合费交收明细查询成功!\"}],\"cxlb\":[{\"gbysfje\":\"1.18\",\"hbdm\":\"0\",\"hbmc\":\"人民币\",\"jshl\":\"0.81726\",\"jsrq\":\"20180301\",\"jysdm\":\"6\",\"jysjc\":\"沪港通\",\"lastmktvalue\":\"1.11\",\"qsrq\":\"20180228\",\"rmbysfje\":\"1.00\",\"zjzh\":\"80316041\"},{\"gbysfje\":\"1.18\",\"hbdm\":\"0\",\"hbmc\":\"人民币\",\"jshl\":\"0.81726\",\"jsrq\":\"20180401\",\"jysdm\":\"9\",\"jysjc\":\"深港通\",\"lastmktvalue\":\"1.11\",\"qsrq\":\"20180331\",\"rmbysfje\":\"1.00\",\"zjzh\":\"80316041\"}]}";
		 * JsonAssertUtil.checkDvalueOfDates( response, "jsrq", "qsrq", 1);
		 */
		/**
		 * readFile(new File("C:\\Users\\Administrator\\Desktop\\users.xlsx"), true);
		 */
		// try {
		// //TODO:一次校验显示所有错误
		// Pattern p1 = Pattern.compile(".*\\S+.*");
		// Matcher m1 = p1.matcher(" ");
		// Assert.assertTrue(m1.matches(), "接口返回响应字段“!") ;
		// }catch(AssertionError e)
		// {
		// System.out.println(e.getMessage());
		// }finally
		// {
		//
		// }
		////
		// Map<String,String >s = new HashMap<>();
		// s.put("a", "a");
		// System.out.println(s.get("b"));;
		// Logger log = Logger.getLogger("zxjtInterface");
		// log.info("asdfsadfsadf");
		// log.debug("IIIIIIIIIIIIIIIIII");

		// Map<String,String> map = new HashMap<String,String>();
		// map.put("pszCodes", "000001,399001,399006");
		// map.put("marketList", "2,1,1");
		// map.put("wType", "0");
		// map.put("bSort", "0");
		// map.put("bDirect", "true");
		// map.put("wFrom", "0");
		// map.put("wCount", "3");
		// map.put("fieldsBitMap", "13690212358");
		// String url = "http://111.13.63.2:9800/api/quote/pb_selected";
		// http://111.13.63.2:9800/api/quote/pb_selected
		//
		// byte[] postdata = ProtobufReq.multi_selectedStocks_req(map);
		// InputStream stream =ProtobufHttp.post(postdata, url);
		// ProtobufRep.multi_selectedStocks_rep( stream);
		//
		//

	}

	// public void geta(List<Map<String, String>> lisTemp, Object... a) {
	// Object[][] obj = new Object[lisTemp.size()][a.length];
	// for (int j = 0; j < obj.length; j++) {
	// obj[j][0] = lisTemp.get(j);
	// if (a == null)
	// continue;
	// for (int k = 1; k <= a.length; k++) {
	// obj[j][k] = a[k - 1];
	// }
	// }
	// }
}