package com.tangkuo.cn.online.util;

import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @ClassName: HttpClientUtil
 * @Description: (利用HttpClient进行post请求的工具类)
 * @author 
 * @see
 */
public class HttpClientUtil {

	public HttpClientUtil() {

	}

	class SSLClient extends DefaultHttpClient {
		public SSLClient() throws Exception {
			super();
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager tm = new X509TrustManager() {
				@Override
				public void checkClientTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}

				@Override
				public void checkServerTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}

				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			LayeredConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(
					ctx, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder
					.<ConnectionSocketFactory> create();
			ConnectionSocketFactory plainSocketFactory = new PlainConnectionSocketFactory();
			registryBuilder.register("http", plainSocketFactory);
			registryBuilder.register("https", sslSocketFactory);
		}
	}

	public String doPost(String url, String reqMsg) {
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			httpPost.setHeader("Content-Type",
					"application/json; charset=UTF-8");
			StringEntity se = new StringEntity(reqMsg, Charset.forName("utf-8"));
			se.setContentEncoding("UTF-8");
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/json"));
			httpPost.setEntity(se);

			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "UTF-8");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}