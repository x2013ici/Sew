package com.stfx.sew;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import org.xmlpull.v1.XmlPullParserFactory;

import com.stfx.sew.datamodel.NovaTargetTask;
import com.stfx.sew.datamodel.NovaTask;
import com.stfx.sew.manager.AppManager;
import com.stfx.sew.parsers.WorkflowModelParser;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * 
 * @author Mostafijur Rahman
 * @since 21th April, 2015
 */
public class ChooseOptionActivity extends Activity {

	boolean isDownloaded = false;
	private static ProgressDialog pd;
	
	Context context;
	InputStream inputStream = null;
	
	//private String urlString = "http://test.biocomalert.com/docs/workflows/sequence.xml";
	
	private XmlPullParserFactory xmlFactoryObject = null;
	public volatile boolean parsingComplete = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);
		
		context = ChooseOptionActivity.this;
		
		/*try{
			new ParseWorkflowModel().execute(null,null,null);
		}
		catch(Exception ex){
			
		}*/
	}

	public void openPhaseOne(View v){
		
		try{
			Intent intent = new Intent(this, ChooseInputConceptActivity.class);
	    	startActivity(intent);
		}
		catch(Exception ex){
			
		}
	}
	
	public void openPhaseTwo(View v){
		
		// Redirect to next Screen
		Intent intent = new Intent(this, WorkflowSelectActivity.class);
    	startActivity(intent);
    	
	}
	
	/*private class ParseWorkflowModel extends AsyncTask<Void,Void,Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			ArrayList<NovaTask> novaTaskList = null;
			
			URL url = null;
			try {
				url = new URL(WorkflowModelParser.urlString);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpURLConnection conn = null;
			try {
				conn = (HttpURLConnection) 
				url.openConnection();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn.setReadTimeout(10000);
			conn.setConnectTimeout(15000);
			try {
				conn.setRequestMethod("GET");
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn.setDoInput(true);
			try {
				conn.connect();
				inputStream = conn.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
            try{
            	if(inputStream !=null){
            		novaTaskList = WorkflowModelParser.getParsedNovaTaskList(inputStream);
            		
            		if(novaTaskList.size()>0){
            			AppManager.novaTaskList = novaTaskList;
            			
            			for(NovaTask novaTask : novaTaskList){
            				
            				//Log.i(AppManager.TAG, "Task Id: " + novaTask.getId() + " Task Name: " + novaTask.getName() + " Task Type: " + novaTask.getTaskType());
            			}
            		}
	            }
            }
            catch(Exception ex){
            	ex.printStackTrace();
            }
            
			
			return null;
		}
		
		@Override
        protected void onPostExecute(Void result) {
            
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
			
			if(AppManager.novaTaskList.size() >0){
				for(NovaTask novaTask : AppManager.novaTaskList){
					AppManager.workflowTaskList.put(novaTask.getId(), novaTask);
    				//Log.i(AppManager.TAG, "Task Id: " + novaTask.getId() + " Task Name: " + novaTask.getName() + " Task Type: " + novaTask.getTaskType());
    			}
			}
			
        }

        @Override
        protected void onPreExecute() {
        	
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        	
        }
	}
	
	private static NovaTask getTargetTaskById(int taskId){
		
		NovaTask novaTask = null;
		try{
			if(AppManager.workflowTaskList.size() >0){
				novaTask = AppManager.workflowTaskList.get(taskId);
				if(novaTask !=null){
					if(novaTask.getTargetTask() == null){
						
					}
				}
			}
		}
		catch(Exception ex){
			//novaTask = null;
		}
		return novaTask;
	}*/
}
