package com.stfx.sew;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import com.stfx.sew.BlockingQueueActivity.SewWebRequestReceiver;


import android.app.IntentService;
import android.content.Intent;
import android.text.format.DateFormat;
import android.util.Log;

public class SewWebRequestIntentService extends IntentService{

	public static final String REQUEST_STRING = "myRequest";
    public static final String RESPONSE_STRING = "myResponse";
    public static final String RESPONSE_MESSAGE = "myResponseMessage";
 
    private String URL = null;
    private static final int REGISTRATION_TIMEOUT = 3 * 1000;
    private static final int WAIT_TIMEOUT = 30 * 1000;
    
	public SewWebRequestIntentService() {
		super("SewWebRequestIntentService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		
		String requestString = intent.getStringExtra(REQUEST_STRING);
        String responseString = requestString + " " + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
        
        String responseMessage = "";
        
        //SystemClock.sleep(10000); // Wait 10 seconds
        
        Log.v("SewWebRequestIntentService:",responseString);
 
        // Do some really cool here
        // I am making web request here as an example...
        try {
 
            URL = requestString;
            HttpClient httpclient = new DefaultHttpClient();
            HttpParams params = httpclient.getParams();
 
            HttpConnectionParams.setConnectionTimeout(params, REGISTRATION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(params, WAIT_TIMEOUT);
            ConnManagerParams.setTimeout(params, WAIT_TIMEOUT);
 
            HttpGet httpGet = new HttpGet(URL);
            HttpResponse response = httpclient.execute(httpGet);
 
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseMessage = out.toString();
            }
 
            else{
                //Closes the connection.
                Log.w("HTTP1:",statusLine.getReasonPhrase());
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
 
        } catch (ClientProtocolException e) {
            Log.w("HTTP2:",e );
            responseMessage = e.getMessage();
        } catch (IOException e) {
            Log.w("HTTP3:",e );
            responseMessage = e.getMessage();
        }catch (Exception e) {
            Log.w("HTTP4:",e );
            responseMessage = e.getMessage();
        }
 
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(SewWebRequestReceiver.PROCESS_RESPONSE);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        
        broadcastIntent.putExtra(RESPONSE_STRING, responseString);
        broadcastIntent.putExtra(RESPONSE_MESSAGE, responseMessage);
        sendBroadcast(broadcastIntent);
		
	}

}
