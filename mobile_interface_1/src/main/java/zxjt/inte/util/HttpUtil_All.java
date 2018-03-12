package zxjt.inte.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;

/**
 * HTTP 请求工具类
 *
 */
@SuppressWarnings("deprecation")
public class HttpUtil_All {
	private static PoolingHttpClientConnectionManager connMgr;
	private static RequestConfig requestConfig;
	private static final int MAX_TIMEOUT = 7000;
	private static final String BOUNDARY = "--5f2775d8-3f84-40fa-affa-1c5f24de036a";

	static {
		// 设置连接池
		connMgr = new PoolingHttpClientConnectionManager();
		// 设置连接池大小
		connMgr.setMaxTotal(100);
		connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

		RequestConfig.Builder configBuilder = RequestConfig.custom();
		// 设置连接超时
		configBuilder.setConnectTimeout(MAX_TIMEOUT);
		// 设置读取超时
		configBuilder.setSocketTimeout(MAX_TIMEOUT);
		// 设置从连接池获取连接实例的超时
		configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
		// 在提交请求之前 测试连接是否可用
		configBuilder.setStaleConnectionCheckEnabled(true);
		requestConfig = configBuilder.build();
	}

	/**
	 * 发送 GET 请求（HTTP），不带输入数据
	 * 
	 * @param url
	 * @return
	 */
	public static String doGet(String url) {
		return doGet(url, new HashMap<String, Object>());
	}

	/**
	 * 发送 GET 请求（HTTP），K-V形式
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doGet(String url, Map<String, Object> params) {
		String apiUrl = url;
		StringBuffer param = new StringBuffer();
		int i = 0;
		for (String key : params.keySet()) {
			if (i == 0)
				param.append("?");
			else
				param.append("&");
			param.append(key).append("=").append(params.get(key));
			i++;
		}
		apiUrl += param;
		String result = null;
		HttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpPost = new HttpGet(apiUrl);
			HttpResponse response = httpclient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();

			System.out.println("执行状态码 : " + statusCode);

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				result = IOUtils.toString(instream, "UTF-8");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 发送 POST 请求（HTTP），不带输入数据
	 * 
	 * @param apiUrl
	 * @return
	 */
	public static String doPost(String apiUrl) {
		return doPost(apiUrl, new HashMap<String, Object>());
	}

	/**
	 * 发送 POST 请求（HTTP），K-V形式
	 * 
	 * @param apiUrl
	 *            API接口URL
	 * @param params
	 *            参数map
	 * @return
	 */
	public static String doPost(String apiUrl, Map<String, Object> params) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String httpStr = null;
		HttpPost httpPost = new HttpPost(apiUrl);
		CloseableHttpResponse response = null;

		try {
			httpPost.setConfig(requestConfig);
			List<NameValuePair> pairList = new ArrayList<>(params.size());
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
				pairList.add(pair);
			}
			httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
			response = httpClient.execute(httpPost);
			System.out.println(response.toString());
			HttpEntity entity = response.getEntity();
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return httpStr;
	}

	/**
	 * 发送 POST 请求（HTTP），JSON形式
	 * 
	 * @param apiUrl
	 * @param json
	 *            json对象
	 * @return
	 */
	public static String doPost(String apiUrl, Object json) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String httpStr = null;
		HttpPost httpPost = new HttpPost(apiUrl);
		CloseableHttpResponse response = null;

		try {
			httpPost.setConfig(requestConfig);
			StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");// 解决中文乱码问题
			stringEntity.setContentEncoding("UTF-8");
			stringEntity.setContentType("application/json");
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			System.out.println(response.getStatusLine().getStatusCode());
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return httpStr;
	}

	/**
	 * 发送 SSL POST 请求（HTTPS），K-V形式
	 * 
	 * @param apiUrl
	 *            API接口URL
	 * @param params
	 *            参数map
	 * @return
	 */
	// public static String doPostSSL(String apiUrl, Map<String, Object>
	// params,Boolean flg)
	// {
	// CloseableHttpClient httpClient = createSSLClientDefault();
	// // CloseableHttpClient httpClient =
	//// HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory())
	// //
	// .setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
	// HttpPost httpPost = new HttpPost(apiUrl);
	// CloseableHttpResponse response = null;
	// String httpStr = null;
	//
	// try {
	//
	// httpPost.setConfig(requestConfig);
	// httpPost.setHeader("Content-Type",
	// ContentType.MULTIPART_FORM_DATA.toString());
	// httpPost.setHeader("charset", "utf-8");
	// List<NameValuePair> pairList = new
	// ArrayList<NameValuePair>(params.size());
	// for (Map.Entry<String, Object> entry : params.entrySet()) {
	// NameValuePair pair = new BasicNameValuePair(entry.getKey(),
	// entry.getValue().toString());
	// pairList.add(pair);
	// }
	// httpPost.setEntity(new UrlEncodedFormEntity(pairList,
	// Charset.forName("utf-8")));
	// response = httpClient.execute(httpPost);
	// int statusCode = response.getStatusLine().getStatusCode();
	// if (statusCode != HttpStatus.SC_OK) {
	// return null;
	// }
	// HttpEntity entity = response.getEntity();
	// if (entity == null) {
	// return null;
	// }
	// httpStr = EntityUtils.toString(entity, "utf-8");
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// if (response != null) {
	// try {
	// EntityUtils.consume(response.getEntity());
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// return httpStr;
	// }

	/**
	 * 发送 SSL POST 请求（HTTPS），JSON形式
	 * 
	 * @param apiUrl
	 *            API接口URL
	 * @param json
	 *            JSON对象
	 * @return
	 */
	public static String doPostSSL(String apiUrl, Map<String, String> param) {

		Object json = map2JsonObject(param);
		CloseableHttpClient httpClient = createSSLClientDefault();
		/*
		 * CloseableHttpClient httpClient =
		 * HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory() )
		 * .setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig)
		 * .build();
		 */

		HttpPost httpPost = new HttpPost(apiUrl);
		CloseableHttpResponse response = null;
		String httpStr = null;

		try {
			httpPost.setConfig(requestConfig);
			StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");// 解决中文乱码问题
			stringEntity.setContentEncoding("UTF-8");
			stringEntity.setContentType("application/json");
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode != HttpStatus.SC_OK) {
				throw new RuntimeException("状态码 " + statusCode);
			}
			HttpEntity entity = response.getEntity();

			if (entity == null) {
				return null;
			}
			httpStr = EntityUtils.toString(entity, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return httpStr;
	}

	public static String doPostSSL(String apiUrl, Map<String, String> param, String infoType) {

		Object json = map2JsonObject(param);
		CloseableHttpClient httpClient = createSSLClientDefault();

		HttpPost httpPost = new HttpPost(apiUrl);
		CloseableHttpResponse response = null;
		String httpStr = null;

		try {
			// 根据传入参数，判断该case是否为需要传入cookie
			if (ParamConstant.NEED_PUT_REQ_HEADER_INFO.equals(infoType)) {
				String cookie = SYSBean.getSysData("cookie");
				httpPost.setHeader("cookie", cookie);
			}
			httpPost.setConfig(requestConfig);
			StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");// 解决中文乱码问题
			stringEntity.setContentEncoding("UTF-8");
			stringEntity.setContentType("application/json");
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			
			// 根据传入参数，判断该case是否是返回了cookie的
			if (ParamConstant.NEED_GET_REP_HEADER_INFO.equals(infoType)) {
				String cookie = response.getLastHeader("Set-Cookie").getValue();
				SYSBean.putSysData("cookie", cookie);
			}

			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode != HttpStatus.SC_OK) {
				throw new RuntimeException("状态码 " + statusCode);
			}
			HttpEntity entity = response.getEntity();

			if (entity == null) {
				return null;
			}
			httpStr = EntityUtils.toString(entity, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return httpStr;
	}

	public static JsonObject map2JsonObject(Map<String, String> param) {
		JsonObject j = new JsonObject();
		for (String key : param.keySet()) {
			if (key.contains("验证") || key.contains("类型") || key.contains("区分") || key.contains("测试点")
					|| key.contains("执行") || key.contains("expectmsg") || key.contains("testpoint")) {
				continue;
			}
			j.addProperty(key, param.get(key));
		}
		return j;
	}

	/*
	 * 关闭证书认证
	 */
	public static CloseableHttpClient createSSLClientDefault() {

		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				// 信任所有
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {
				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}

				@Override
				public void verify(String host, SSLSocket ssl) throws IOException {
				}

				@Override
				public void verify(String host, X509Certificate cert) throws SSLException {
				}

				@Override
				public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
				}
			});

			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}

		return HttpClients.createDefault();

	}

	/**
	 * 创建SSL安全连接
	 *
	 * @return
	 */
	private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
		SSLConnectionSocketFactory sslsf = null;
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}

				@Override
				public void verify(String host, SSLSocket ssl) throws IOException {
				}

				@Override
				public void verify(String host, X509Certificate cert) throws SSLException {
				}

				@Override
				public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
				}
			});
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return sslsf;
	}

	/**
	 * 发送form请求
	 */
	public static String sendFormPostRequest(String serverUrl, ArrayList<FieldPairBean> FormInfos,
			ArrayList<FilePairBean> fileInfos) throws Exception {

		// 向服务器发送post请求
		URL url = new URL(serverUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 发送POST请求设置内容
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Connection", "Keep-Alive");
		connection.setRequestProperty("Charset", "UTF-8");
		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

		String boundary = BOUNDARY;
		StringBuffer contentBody = new StringBuffer("--" + BOUNDARY);
		String endBoundary = "\r\n--" + boundary + "--\r\n";
		OutputStream out = connection.getOutputStream();

		// 处理文字形式的POST请求
		for (FieldPairBean fp : FormInfos) {
			contentBody.append("\r\n").append("Content-Disposition: form-data; name=\"").append(fp.getKey() + "\"")
					.append("\r\n").append("\r\n").append(fp.getValue()).append("\r\n").append("--")
					.append(boundary);
		}

		String boundaryFp = contentBody.toString();
		out.write(boundaryFp.getBytes("UTF-8"));

		// 处理文件上传
		for (FilePairBean fip : fileInfos) {
			contentBody = new StringBuffer();
			contentBody.append("\r\n").append("Content-Disposition:form-data; name=\"")
					.append(fip.getFormFieldName() + "\"; ") // form中field的名称
					.append("filename=\"").append(fip.getFileName() + "\"") // 上传文件的文件名，包括目录
					.append("\r\n").append("Content-Type:application/octet-stream").append("\r\n\r\n");

			String boundaryFip = contentBody.toString();
			out.write(boundaryFip.getBytes("UTF-8"));

			// 开始真正向服务器写文件
			File file = new File(fip.getFileName());

			DataInputStream dis = new DataInputStream(new FileInputStream(file));
			int bytes = 0;
			byte[] bufferOut = new byte[(int) file.length()];
			bytes = dis.read(bufferOut);
			out.write(bufferOut, 0, bytes);
			dis.close();
			contentBody.append(BOUNDARY);
			String boundaryMessage = contentBody.toString();
			out.write(boundaryMessage.getBytes("UTF-8"));

		}
		out.write((BOUNDARY+"--\r\n").getBytes("UTF-8"));

		// 写结尾
		out.write(endBoundary.getBytes("UTF-8"));
		out.flush();
		out.close();

		// 从服务器获得回答的内容
		String strLine = "";
		String strResponse = "";
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		while ((strLine = reader.readLine()) != null) {
			strResponse += strLine + "\n";
		}
		return strResponse;
	}
}
