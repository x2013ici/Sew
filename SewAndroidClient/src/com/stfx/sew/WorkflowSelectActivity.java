package com.stfx.sew;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd May, 2015
 */
public class WorkflowSelectActivity extends Activity {

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
		setContentView(R.layout.activity_workflow_select);
		
		context = WorkflowSelectActivity.this;
		
		/**
		 * Disable Sequential Workflow Related functionallity
		 * Process http://test.biocomalert.com/docs/workflows/sequence.xml
		 */
		/*try{
			new HpcSequentialWorkflowModel().execute(null,null,null);
		}
		catch(Exception ex){
			
		}*/
		
		/**
		 * http://test.biocomalert.com/docs/workflows/overall.xml
		 */
		try{
			new HpcOverallWorkflowModel().execute(null,null,null);
		}
		catch(Exception ex){
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question_section_one, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_next) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void configureWorkflowTask(View v){
		Intent intent = new Intent(this, ConfigureWorkflowTasksActivity.class);
		startActivity(intent);
	}
	
	public void autmaticWorkflowExecution(View v){
		Intent intent = new Intent(this, AutoWorkflowExecutionActivity.class);
		startActivity(intent);
	}
	
	/**
	 * Disable HpcSequentialWorkflowModel class related functionality
	 * @author Mostafijur Rahman
	 * process http://test.biocomalert.com/docs/workflows/sequence.xml workflow model
	 */
	/*private class HpcSequentialWorkflowModel extends AsyncTask<Void,Void,Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			ArrayList<NovaTask> novaTaskList = null;
			
			URL url = null;
			try {
				url = new URL(WorkflowModelParser.sequencialUrlString);
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
            		novaTaskList = WorkflowModelParser.getHpcSequentialWorkflowTaskList(inputStream);
            		if(novaTaskList.size()>0){
            			AppManager.hpcSequencialNovaTaskList = novaTaskList;
            			
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
			
			if(AppManager.hpcSequencialNovaTaskList.size() >0){
				
				for(NovaTask novaTask : AppManager.hpcSequencialNovaTaskList){
					
					AppManager.hpcSequencialWorkflowTaskList.put(novaTask.getId(), novaTask);
    				//Log.i(AppManager.TAG, "Task Id: " + novaTask.getId() + " Task Name: " + novaTask.getName() + " Task Type: " + novaTask.getTaskType());
					
					Log.i(WorkflowModelParser.TAG, "Task Id: " + novaTask.getId() + " -->Task Name: " + novaTask.getName() + "-->Task Type: " + novaTask.getTaskType());
    				
    				// Target Task Details
    				if(novaTask.getTargetTask() !=null){
    					Log.i(WorkflowModelParser.TAG, "Target Task Id: " + novaTask.getTargetTask().getTaskId()
    							+ "-->Target Task Name: " + novaTask.getTargetTask().getTaskName());
    				}
    				
    				// Target Task List
    				if(novaTask.getTargetTaskList() !=null){
    					for(NovaTargetTask novaTargetTask : novaTask.getTargetTaskList()){
    						Log.i(WorkflowModelParser.TAG, "Target Task Id: " + novaTargetTask.getTaskId()
        							+ " -->Target Task Name: " + novaTargetTask.getTaskName()
        							+ "-->Branch Order Id: " + novaTargetTask.getBranchOrderId());
    					}
    				}
    				
    				// Corresponding Task Details
    				if(novaTask.getCorrespondingTask() !=null){
    					Log.i(WorkflowModelParser.TAG, "Corresponding Task Id: " + novaTask.getCorrespondingTask().getCorrespondingTaskId() 
    							+ " -->Task Name: " + novaTask.getCorrespondingTask().getCorrespondingTaskName());
    				}
    				
    				Log.i(WorkflowModelParser.TAG, "----------------------------------------------------------");
    			}
			}
        }

        @Override
        protected void onPreExecute() {
        	
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        	
        }
	}*/
	
	/**
	 * 
	 * @author Mostafijur Rahman
	 * process http://test.biocomalert.com/docs/workflows/overall.xml workflow model
	 */
	private class HpcOverallWorkflowModel extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			ArrayList<NovaTask> novaTaskList = null;
			
			URL url = null;
			try {
				url = new URL(WorkflowModelParser.overallUrlString);
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
            		//novaTaskList = WorkflowModelParser.getHpcOverallWorkflowTaskList(inputStream);
            		novaTaskList = WorkflowModelParser.getHpcOverallWorkflowTaskListHavingBrnachOrder(inputStream);
            		
            		if(novaTaskList.size()>0){
            			AppManager.hpcOverallNovaTaskList = novaTaskList;
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
			
			if(AppManager.hpcOverallNovaTaskList.size() >0){
				
				AppManager.hpcOverallWorkflowTaskList.clear();
				for(NovaTask novaTask : AppManager.hpcOverallNovaTaskList){
					
					AppManager.hpcOverallWorkflowTaskList.put(novaTask.getId(), novaTask);
					
					//AppManager.sequencialWorkflowTaskList.put(novaTask.getId(), novaTask);
					// Task Details
    				Log.i(WorkflowModelParser.TAG, "Task Id: " + novaTask.getId() + " -->Task Name: " + novaTask.getName() + "-->Task Type: " + novaTask.getTaskType());
    				
    				// Target Task Details
    				if(novaTask.getTargetTask() !=null){
    					Log.i(WorkflowModelParser.TAG, "Target Task Id: " + novaTask.getTargetTask().getTaskId()
    							+ "-->Target Task Name: " + novaTask.getTargetTask().getTaskName());
    				}
    				
    				// Target Task List
    				if(novaTask.getTargetTaskList() !=null){
    					for(NovaTargetTask novaTargetTask : novaTask.getTargetTaskList()){
    						Log.i(WorkflowModelParser.TAG, "Target Task Id: " + novaTargetTask.getTaskId()
        							+ " -->Target Task Name: " + novaTargetTask.getTaskName()
        							+ "-->Branch Order Id: " + novaTargetTask.getBranchOrderId());
    					}
    				}
    				
    				// Corresponding Task Details
    				if(novaTask.getCorrespondingTask() !=null){
    					Log.i(WorkflowModelParser.TAG, "Corresponding Task Id: " + novaTask.getCorrespondingTask().getCorrespondingTaskId() 
    							+ " -->Task Name: " + novaTask.getCorrespondingTask().getCorrespondingTaskName());
    				}
    				Log.i(WorkflowModelParser.TAG, "----------------------------------------------------------");
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
	
	/*private static NovaTask getTargetTaskById(int taskId){
		
		NovaTask novaTask = null;
		try{
			if(AppManager.sequencialWorkflowTaskList.size() >0){
				novaTask = AppManager.sequencialWorkflowTaskList.get(taskId);
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
