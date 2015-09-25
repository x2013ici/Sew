package com.stfx.sew.sewservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


public class JSONParser {

String returnJsonAsString = "" ;
	
	public JSONParser() {

	}
	
	/**
	 * 
	 */
	private static volatile JSONParser jsonParser ;
	public static JSONParser getInstance(){
		if(jsonParser ==null)
			synchronized (JSONParser.class){
				jsonParser = new JSONParser();
			}
		return jsonParser;
	}
	
	/*public static JSONParser getInstance ()
	{
		if(_instance == null)
			_instance = new JSONParser() ;

		return _instance ;
	}*/

	/**
	 * 
	 */
	public String getJSONFromUrl(String url) {

		// Making HTTP request
		try {
			HttpParams httpParameters = new BasicHttpParams();
			// Set the default socket timeout (SO_TIMEOUT) 
			// in milliseconds which is the timeout for waiting for data.
			int timeoutSocket = 5000;
			HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
			// defaultHttpClient
			DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
			HttpGet httpPost = new HttpGet(url);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			returnJsonAsString = EntityUtils.toString(httpEntity);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		

		return returnJsonAsString;

	}

	/**
	 * 
	 */
	public void sendJSONByUrl (String url, JSONObject obj)	{

		// Create a new HttpClient and Post Header
		HttpParams myParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(myParams, 10000);
		HttpConnectionParams.setSoTimeout(myParams, 10000);
		HttpClient httpclient = new DefaultHttpClient(myParams);

		try {
			HttpPost httppost = new HttpPost(url.toString());
			httppost.setHeader("Content-type", "application/json");
			StringEntity se = new StringEntity(obj.toString()); 
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			httppost.setEntity(se); 

			HttpResponse response = httpclient.execute(httppost);
			String temp = EntityUtils.toString(response.getEntity());
			Log.i("tag", temp);

		} catch (ClientProtocolException e) {

		} catch (IOException e) {
		}

	}

	/**
	 * 
	 */
	public static JSONObject doPost(String url, JSONObject obj) {
		JSONObject json = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			//	httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			StringEntity se = new StringEntity(obj.toString());			
			httpPost.setEntity(se);

			HttpResponse response;
			response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				String result = convertStreamToString(instream);
				json = new JSONObject(result);
				instream.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

	// convert InputStream to String
	private static String convertStreamToString(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
