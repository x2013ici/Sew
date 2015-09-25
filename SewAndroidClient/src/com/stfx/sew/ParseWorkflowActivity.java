package com.stfx.sew;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;


import com.stfx.sew.datamodel.NovaTargetTask;
import com.stfx.sew.datamodel.NovaTask;
import com.stfx.sew.manager.AppManager;
import com.stfx.sew.parsers.ParseXML;
import com.stfx.sew.parsers.WorkflowModelParser;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author Mostafijur Rahman
 * @since 22th April, 2015
 */
public class ParseWorkflowActivity extends Activity {

	boolean isDownloaded = false;
	private static ProgressDialog pd;
	
	Context context;
	InputStream inputStream = null;
	
	
	private XmlPullParserFactory xmlFactoryObject;
	public volatile boolean parsingComplete = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parse_workflow);
		
		context = ParseWorkflowActivity.this;
		
		/* Disable Sequential Workflow Related functionality */
		/*try{
			new HpcSequentialWorkflowModel().execute(null,null,null);
		}
		
		catch(Exception ex){
			
		}*/
		
		try{
			new HpcOverallWorkflowModel().execute(null,null,null);
		}
		catch(Exception ex){
			
		}
	}

	
	public void ParseWorkflowTasks(View v){
		
	}
	
	public void ChoiceScreen(View v){
		
		try{
			Intent intent = new Intent(this, ChooseOptionActivity.class);
	    	startActivity(intent);
		}
		catch(Exception ex){
			
		}
	}
	
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

	/*public void ParseXML(View v){
		
		//Toast.makeText(this, "Not implemented yet", Toast.LENGTH_SHORT).show();
		//Toast.makeText(this, "Started to Parse XML!!!", Toast.LENGTH_SHORT).show();
		pd = ProgressDialog.show(context, "", "Downloading Workflow Model Data. Please wait...",true);
    	try{
    		
    		//ParseXML parseXML = new ParseXML();
        	//parseXML.fetchXML();
    		
    		WorkflowModelParser workFlowModelParser = new WorkflowModelParser();
    		workFlowModelParser.downloadWorkflowModel();
    		
    		handler.sendEmptyMessage(0);
        	Toast.makeText(this, "Workflow Model Parsed Successfully!!!", Toast.LENGTH_SHORT).show();
        	
        	if(AppManager.novaTaskList.size()>0){
        		for(NovaTask novaTask : AppManager.novaTaskList){
        			
        			Log.i(AppManager.TAG, "Task Id: " + novaTask.getId() + " Task Name: " + novaTask.getName() + " Task Type: " + novaTask.getTaskType());
        		}
        	}
        	else{
        		Toast.makeText(this, "Workflow Task List is empty!!!", Toast.LENGTH_SHORT).show();
        	}
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    	}
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.parse_workflow, menu);
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
	
	static Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			try{pd.dismiss();}
			catch(Exception ex){}
		};
	};
	
	/*public void DoAsynchronousCall(View v){
		
		// Make Asynchronous Call to download XML file
		try{
			
			pd = ProgressDialog.show(context, "", "Downloading Workflow Model Data. Please wait...",true);
			
			new AsyncTask<Void, Void, Void>(){

				@Override
				protected Void doInBackground(Void... params) {
					// TODO Auto-generated method stub
					
					URL url;
					try {
						url = new URL(urlString);
						HttpURLConnection conn = null;
						try {
							conn = (HttpURLConnection) 
							url.openConnection();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    conn.setReadTimeout(10000  milliseconds );
					    conn.setConnectTimeout(15000  milliseconds );
					    
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
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		               
		               
					return null;
				}
				
				@Override
		        protected void onPostExecute(Void result) {
		            
		            // might want to change "executed" for the returned string passed
		            // into onPostExecute() but that is upto you
					handler.sendEmptyMessage(0);
					if(inputStream !=null){
						try {
							xmlFactoryObject = XmlPullParserFactory.newInstance();
						} catch (XmlPullParserException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			            XmlPullParser xmlPullParser = null;
						try {
							xmlPullParser = xmlFactoryObject.newPullParser();
						} catch (XmlPullParserException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

			            try {
							xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
						} catch (XmlPullParserException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			            try {
							xmlPullParser.setInput(inputStream, null);
							WorkflowModelParser.parseAndStoreWorkflowModel(xmlPullParser);

						} catch (XmlPullParserException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					TextView tvExecutionStatus = (TextView) findViewById(R.id.tvExecutionStatus);
					tvExecutionStatus.setText("Executed");
		        }

		        @Override
		        protected void onPreExecute() {}

		        @Override
		        protected void onProgressUpdate(Void... values) {}
				
			}.execute(null,null,null);
			
			//Toast.makeText(this, "Started Async Task Call!!!", Toast.LENGTH_SHORT).show();
			//new LongOperation().execute("");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private class LongOperation extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return "Executed";
		}
		
		@Override
        protected void onPostExecute(String result) {
            
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
			
			TextView tvExecutionStatus = (TextView) findViewById(R.id.tvExecutionStatus);
			tvExecutionStatus.setText("Executed");
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
        
	}*/
	
	/*private class ParseWorkflowModel extends AsyncTask<Void,Void,Void>{

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		ArrayList<NovaTask> novaTaskList = null;
		
		URL url = null;
		try {
			url = new URL(urlString);
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
				Log.i(AppManager.TAG, "Task Id: " + novaTask.getId() + " Task Name: " + novaTask.getName() + " Task Type: " + novaTask.getTaskType());
			}
		}
		
		TextView tvExecutionStatus = (TextView) findViewById(R.id.tvExecutionStatus);
		tvExecutionStatus.setText("Executed");
    }

    @Override
    protected void onPreExecute() {
    	
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    	
    }
}
*/
}
