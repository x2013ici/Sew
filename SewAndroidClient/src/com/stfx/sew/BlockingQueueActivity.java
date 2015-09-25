package com.stfx.sew;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.stfx.sew.datamodel.NovaTask;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BlockingQueueActivity extends Activity {

	Handler mHandler;
	
	private SewWebRequestReceiver receiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blocking_queue);
		
		try{
			
			IntentFilter filter = new IntentFilter(SewWebRequestReceiver.PROCESS_RESPONSE);
	        filter.addCategory(Intent.CATEGORY_DEFAULT);
	        
	        receiver = new SewWebRequestReceiver();
	        registerReceiver(receiver, filter);
	 
	        Button addButton = (Button) findViewById(R.id.sendRequest);
	        addButton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	 
	                Intent msgIntent = new Intent(BlockingQueueActivity.this, SewWebRequestIntentService.class);
	                
	                msgIntent.putExtra(SewWebRequestIntentService.REQUEST_STRING, "http://www.amazon.com");
	                startService(msgIntent);
	                
	                msgIntent.putExtra(SewWebRequestIntentService.REQUEST_STRING, "http://www.ebay.com");
	                startService(msgIntent);
	                
	                msgIntent.putExtra(SewWebRequestIntentService.REQUEST_STRING, "http://www.yahoo.com");
	                startService(msgIntent);
	            }
	        });
	        
			/*MyHandlerThread thread = new MyHandlerThread();
			thread.start();
			thread.taskOne();*/
			
			/*mHandler = new Handler(){
				
				@Override
				public void handleMessage(Message message){
					
					NovaTask novaTask = (NovaTask) message.obj;
					
					System.out.println("Task Id: " + novaTask.getId() + " TaskName: " + novaTask.getName());
					Log.i("Thread", "Task Id: " + novaTask.getId() + " TaskName: " + novaTask.getName());
					//Toast.makeText(this, "Task Id: " + novaTask.getId() + " TaskName: " + novaTask.getName(), Toast.LENGTH_SHORT).show();
				}
			};
			
			Thread thread = new Thread(new TestThread());
			thread.start(); */
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		// Start LooperThread
		/*try{
			LooperThread looperThread = new LooperThread();
			looperThread.start();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}*/
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blocking_queue, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
    public void onDestroy() {
        this.unregisterReceiver(receiver);
        super.onDestroy();
    }
	
	public class SewWebRequestReceiver extends BroadcastReceiver{
		 
        public static final String PROCESS_RESPONSE = "com.as400samplecode.intent.action.PROCESS_RESPONSE";

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			
			String responseString = intent.getStringExtra(SewWebRequestIntentService.RESPONSE_STRING);
            String reponseMessage = intent.getStringExtra(SewWebRequestIntentService.RESPONSE_MESSAGE);
 
            //TextView myTextView = (TextView) findViewById(R.id.response);
            //myTextView.setText(responseString);
 
            //WebView myWebView = (WebView) findViewById(R.id.myWebView);
            //myWebView.getSettings().setJavaScriptEnabled(true);
            
            try {
            	
            	Toast.makeText(context, "Response Sttring: " + responseString, Toast.LENGTH_LONG).show();
            	Toast.makeText(context, "Response Message: " + reponseMessage, Toast.LENGTH_LONG).show();
            	
                //myWebView.loadData(URLEncoder.encode(reponseMessage,"utf-8").replaceAll("\\+"," "), "text/html", "UTF-8");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
		}
    }
	
	/*class LooperThread extends Thread {
		
		@Override
		public void run(){
			
			Looper.prepare();
			
			mHandler = new Handler(){
				
				@Override
	            public void handleMessage(Message msg) {
	                // process incoming messages here
	            }
			};
			
			Looper.loop();
		}
	}
	
	class TestThread extends Thread {
		
		@Override
		public void run(){
			
			NovaTask novaTask = new NovaTask();
			novaTask.setId(1);
			novaTask.setTaskName("ReceiveReferral");
			
			Message message = Message.obtain();
			message.obj = novaTask;
			
			mHandler.sendMessage(message);
		}
	}
	
	class MyHandlerThread extends HandlerThread {
		 
	    private Handler mHandler;
	 
	    public MyHandlerThread() 
	    {
	        super("MyHandlerThread",  Process.THREAD_PRIORITY_BACKGROUND);
	    }
	 
	    @Override
	    protected void onLooperPrepared() {
	        super.onLooperPrepared();
	 
	        mHandler = new Handler(getLooper()) {
	            @Override
	            public void handleMessage(Message msg) {
	                switch (msg.what) {
	                    case 1:
	                        // Handle message
	                    	Log.i("Thread", "Message: " + msg.what);
	                        break;
	                    case 2:
	                        // Handle message
	                    	Log.i("Thread", "Message: " + msg.what);
	                        break;
	                }
	            }
	        };
	    }
	 
	    public void taskOne() {
	        mHandler.sendEmptyMessage(1);
	    }
	 
	    public void taskTwo() {
	        mHandler.sendEmptyMessage(2);
	    }
	     
	}*/
}
