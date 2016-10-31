package com.aerse.ru.reg;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.RequestAcceptEncoding;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class RegAPI {

	private static final Logger LOG = Logger.getLogger(RegAPI.class);

	private HttpClient client;
	private final static String BASE_URL = "https://api.reg.ru/api/regru2";
	private final static Gson gson = new Gson();
	private int timeout = 1000;

	public void start() {
		client = createClient();
	}

	public Response addAlias(AddAliasInputData inputData) throws UnsupportedEncodingException {
		return executeMethod("/zone/add_alias", inputData);
	}

	public Response removeRecord(RemoveRecordInputData inputData) throws UnsupportedEncodingException {
		return executeMethod("/zone/remove_record", inputData);
	}

	private Response executeMethod(String methodName, Object inputData) throws UnsupportedEncodingException {
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("input_format", "json"));
		parameters.add(new BasicNameValuePair("input_data", gson.toJson(inputData)));
		HttpPost post = new HttpPost(BASE_URL + methodName);
		post.setEntity(new UrlEncodedFormEntity(parameters));
		if (LOG.isDebugEnabled()) {
			StringBuilder message = new StringBuilder();
			message.append("URL: ").append(post.getURI());
			message.append(" parameters: ");
			for (NameValuePair cur : parameters) {
				message.append(cur.getName()).append("=").append(cur.getValue()).append(" ");
			}
			LOG.debug(message.toString());
		}
		HttpResponse response = null;
		try {
			response = client.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				LOG.info("invalid response code: " + statusCode);
			}
			String body = EntityUtils.toString(response.getEntity());
			if (LOG.isDebugEnabled()) {
				LOG.debug(body);
			}
			return gson.fromJson(body, Response.class);
		} catch (Exception e) {
			LOG.error("unable to execute", e);
			return new Response("Unable to execute request");
		} finally {
			if (response != null) {
				EntityUtils.consumeQuietly(response.getEntity());
			}
		}
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	private HttpClient createClient() {
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setSoTimeout(params, timeout);
		HttpConnectionParams.setConnectionTimeout(params, timeout);
		HttpProtocolParams.setUserAgent(params, "RegAPI Java");
		HttpProtocolParams.setContentCharset(params, "utf-8");

		DefaultHttpClient client = new DefaultHttpClient(params);
		client.addRequestInterceptor(new RequestAcceptEncoding());
		client.addResponseInterceptor(new ResponseContentEncoding());
		return client;
	}
}
