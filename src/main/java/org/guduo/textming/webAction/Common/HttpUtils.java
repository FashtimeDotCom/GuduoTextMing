package org.guduo.textming.webAction.Common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;


/**
 * @athor Lijian
 * @date 2016年04月21日
 */
public class HttpUtils {
	private final static Log logger = LogFactory.getLog(HttpUtils.class);
	private final static String DEFAULT_CONTENT_CHARSET = "UTF-8";
	private final static int DEFAULT_CONNECT_TIMEOUT = 30000;
	private final static int DEFAULT_READ_TIMEOUT = 60000;
	
	public static String get(String url, Map<String, String> params) throws IOException {
		return get(url, params, DEFAULT_CONTENT_CHARSET);
	}
	
	public static String get(String url, Map<String, String> params, String contentCharset) throws IOException {
		if(url == null || url.length() == 0) {
			logger.error("URL cannot be empty to perform HTTP get.");
			return null;
		}
		
		if(contentCharset == null || contentCharset.length() == 0) {
			contentCharset = DEFAULT_CONTENT_CHARSET;
		}
		
		StringBuilder urlWithQueryStr = new StringBuilder(url);
		if(params != null && params.size() > 0) {			
			if(url.indexOf('?') == -1) {
				urlWithQueryStr.append('?');
			} else {
				urlWithQueryStr.append('&');
			}
			
			boolean isFirst = true;
			for(Map.Entry<String, String> p : params.entrySet()) {
				if(!isFirst) {
					urlWithQueryStr.append('&');
				}
				urlWithQueryStr.append(p.getKey()).append('=').append(p.getValue() == null ? "" : encodeURL(p.getValue(), contentCharset));
				isFirst = false;
			}
		}
		
		String responseBody = null;
		HttpURLConnection conn = null;
		try {
			URL _url = new URL(urlWithQueryStr.toString());
			conn = (HttpURLConnection) _url.openConnection();
			conn.setRequestProperty("User-Agent", "Java");
			conn.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT);
			conn.setReadTimeout(DEFAULT_READ_TIMEOUT);
			// conn.setDoOutput(true);
			// conn.setDoInput(true);
			conn.setRequestProperty("Accept-Encoding", "plain");
			conn.setRequestProperty("Content-Encoding", "plain");
			int statusCode = conn.getResponseCode();
			if(statusCode == 200) {
				InputStream input = conn.getInputStream();
				InputStreamReader reader = new InputStreamReader(input, contentCharset);
				StringBuilder sb = new StringBuilder();
				char[] cbuf = new char[1024];
				int k;
				for( ; (k = reader.read(cbuf)) != -1 ; ) {
					sb.append(cbuf, 0, k);
				}
				responseBody = sb.toString();
			} else {
				logger.error("error to get from " + url + ", statusCode=" + statusCode);
			}
		} finally {
			if(conn != null) {
				conn.disconnect();
			}
		}
		
		return responseBody;
	}
	
	public static String post(String url, Map<String, String> params, String contentCharset) throws IOException {
		if(url == null || url.length() == 0) {
			logger.error("URL cannot be empty to perform HTTP get.");
			return null;
		}
		
		if(contentCharset == null || contentCharset.length() == 0) {
			contentCharset = DEFAULT_CONTENT_CHARSET;
		}
		
		StringBuilder queryStr = new StringBuilder();
		if(params != null && params.size() > 0) {
			boolean isFirst = true;
			for(Map.Entry<String, String> p : params.entrySet()) {
				if(!isFirst) {
					queryStr.append('&');
				}
				
				queryStr.append(p.getKey()).append('=').append(p.getValue() == null ? "" : p.getValue());
				isFirst = false;
			}
		}
		
		String responseBody = null;
		HttpURLConnection conn = null;
		try {
			URL _url = new URL(url);
			conn = (HttpURLConnection) _url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("User-Agent", "Java");
			conn.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT);
			conn.setReadTimeout(DEFAULT_READ_TIMEOUT);
			conn.setDoOutput(true);
			// conn.setDoInput(true);
			conn.setRequestProperty("Accept-Encoding", "plain");
			conn.setRequestProperty("Content-Encoding", "plain");
			
			conn.getOutputStream().write(queryStr.toString().getBytes(contentCharset));
			conn.getOutputStream().close();
			int statusCode = conn.getResponseCode();
			if(statusCode == 200) {
				InputStream input = conn.getInputStream();
				InputStreamReader reader = new InputStreamReader(input, contentCharset);
				StringBuilder sb = new StringBuilder();
				char[] cbuf = new char[1024];
				int k;
				for( ; (k = reader.read(cbuf)) != -1 ; ) {
					sb.append(cbuf, 0, k);
				}
				responseBody = sb.toString();
			} else {
				logger.error("error to post to " + url + ", statusCode=" + statusCode);
			}
		} finally {
			if(conn != null) {
				conn.disconnect();
			}
		}
		
		return responseBody;
	}
	
	public static String encodeURL(String s, String encoding){
		if(s == null || s.equals("")){
			return s;
		}
		
		try {
			return URLEncoder.encode(s, encoding);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
}
