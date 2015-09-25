package com.stfx.sew.sewservices;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * @author Mostafijur Rahman
 * 
 */
public class SewHttpConnectionManager {
	
	/**
	 * 
	 */
	public JSONObject httpPostConnection(String url, JSONObject jsonAdd){
		
		HttpParams httpParameters = new BasicHttpParams();
		// Set the default socket timeout (SO_TIMEOUT) 
		// in milliseconds which is the timeout for waiting for data.
		int timeoutSocket = 20000;
		HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
		
		HttpClient httpclient = new DefaultHttpClient(httpParameters);
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-type", "application/json");	
		httpPost.setHeader("Accept", "application/json");	
		try {
			Log.d("JSON_OUTGOING", jsonAdd.toString());
			
			StringEntity se = new StringEntity(jsonAdd.toString());			
			httpPost.setEntity(se);
	
			HttpResponse response = httpclient.execute(httpPost);
			String temp = EntityUtils.toString(response.getEntity());
			JSONObject jObject = new JSONObject(temp);
			return jObject;
		}
		catch(JSONException e){
			e.printStackTrace();
		}
		catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e1) {			
			e1.printStackTrace();
		}
		catch (IOException e1) {			
			e1.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * 
	 */
	public JSONObject httpGetConnection(String url){
		
		JSONObject json = null;
		JSONParser jParser = new JSONParser ();			
		String returnString = jParser.getJSONFromUrl(url);
		try {
			json = new JSONObject(returnString);
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
		return json;
	}
	
	/**
	 * 
	 */
	public JSONObject httpGetConnection2(String url) {
		String resp = "";
		JSONObject jObj = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient() ;
			HttpGet httpPost = new HttpGet(url);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			resp = EntityUtils.toString(httpEntity);
			
			jObj = new JSONObject(resp);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
		return jObj;
	}
}
