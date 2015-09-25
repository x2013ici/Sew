package com.stfx.sew.parsers;

import java.io.InputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.stfx.sew.datamodel.NovaBranchOrder;
import com.stfx.sew.datamodel.NovaCorrespondingTask;
import com.stfx.sew.datamodel.NovaTargetTask;
import com.stfx.sew.datamodel.NovaTask;
import com.stfx.sew.manager.AppManager;

import android.util.Log;
import android.util.Xml;

public class WorkflowModelParser {
	
	public static String TAG = "SewNova";
	
	public static final int INPUT_CONDITION_TASK_ID = 1;
	public static final int OUTPUT_CONDITION_TASK_ID =2;
	
	public static String TaskType_InputCondition = "InputCondition";
	public static String TaskType_OutputCondition = "OutputCondition";
	
	public static String TaskType_CompensableTask = "CompensableTask";
	public static String TaskType_UncompensableTask = "UncompensableTask";
	
	public static String TaskType_XorSplitTask = "XorSplitTask";
	public static String TaskType_XorJoinTask = "XorJoinTask";
	
	public static String sequencialUrlString = "http://test.biocomalert.com/docs/workflows/sequence.xml";
	
	//public static String overallUrlString = "http://test.biocomalert.com/docs/workflows/overall.xml";
	//public static String overallUrlString = "http://test.biocomalert.com/docs/workflows/hpcoverall.xml";
	public static String overallUrlString = "http://test.biocomalert.com/docs/workflows/hpcoveralltest.xml";
	
	
	private static XmlPullParserFactory xmlFactoryObject;
	
	
	
	public WorkflowModelParser(){
		
	}
	
	/*
	 * @author Mostafijur Rahman
	 * source file: Sequence.xml file
	 */
	public static ArrayList<NovaTask> getHpcSequentialWorkflowTaskList(InputStream inputStream){
		
		int event;
		String text = null;
		String tagName = null;
		
		String taskId = null;
		String taskName = null;
		String taskType = null;
		
		String targetTaskId = null;
		String targetTaskName = null;
		
		NovaTask novaTask = null;
		NovaTargetTask novaTargetTask = null;
		ArrayList<NovaTask> novaTaskList = new ArrayList<NovaTask>();
		
		try{
			
			xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = xmlFactoryObject.newPullParser();

            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            xmlPullParser.setInput(inputStream, null);
            
			/*XmlPullParser xmlPullParser = Xml.newPullParser();
			xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);    		
			xmlPullParser.setInput(reader);*/
			//xmlPullParser.nextTag(); 
            
			event = xmlPullParser.getEventType();
			while(event != xmlPullParser.END_DOCUMENT){
				
				tagName = xmlPullParser.getName();
				switch(event){
					case XmlPullParser.START_DOCUMENT:
						break;
						
					case XmlPullParser.START_TAG:
						
						if(tagName.equals("task")){
							taskId = xmlPullParser.getAttributeValue(null, "id");
							if(!taskId.isEmpty()){
								//Log.i(AppManager.TAG, "Task Id: " + taskId);
							}
							
							taskName = xmlPullParser.getAttributeValue(null, "name");
							if(!taskName.isEmpty()){
								//Log.i(AppManager.TAG,"Task Name: " + taskName);
							}
							
							taskType = xmlPullParser.getAttributeValue(null, "type");
							
							if(!taskType.isEmpty()){
								//Log.i(AppManager.TAG, "Task Type: " + taskType);
							}
							
							//Construct NovaTask Object
							novaTask = new NovaTask();
							novaTask.setId(Integer.parseInt(taskId));
							novaTask.setTaskName(taskName);
							novaTask.setTaskType(taskType);
							
							if(novaTask.getClass().equals(TaskType_OutputCondition)){
								novaTargetTask = null;
								novaTask.setTargetTask(novaTargetTask);
							}
						}
						
						if(tagName.equals("target")){
							targetTaskId = xmlPullParser.getAttributeValue(null, "id");
							if(!targetTaskId.isEmpty()){
								//Log.i(AppManager.TAG, "Target Task Id: " + targetTaskId);
							}
							
							targetTaskName = xmlPullParser.getAttributeValue(null, "name");
							if(!targetTaskName.isEmpty()){
								//Log.i(AppManager.TAG, "Target Task Name: " + targetTaskName);
							}
							
							novaTargetTask = new NovaTargetTask();
							novaTargetTask.setTaskId(Integer.parseInt(targetTaskId));
							novaTargetTask.setTaskName(targetTaskName);
							
							novaTask.setTargetTask(novaTargetTask);
						}
						break;
					
					case XmlPullParser.TEXT:
						/*text = xmlPullParser.getText();
						if(!text.isEmpty()){
							Log.i(TAG, "Text: " + text);
						}*/
						break;
					case XmlPullParser.END_TAG:
						if(tagName.equals("task")){
							
							novaTaskList.add(novaTask);
							//Log.i(AppManager.TAG,"End of Task Block: " + novaTask.getName());
						}
						break;
					case XmlPullParser.END_DOCUMENT:
						break;
				}
				event = xmlPullParser.next(); 
			}
			
			//parsingComplete = true;
		}
		
		catch(Exception ex){
			ex.printStackTrace();
		}
		return novaTaskList;
		
	}

	/**
	 * Disabled Temporarily
	 * @param inputStream
	 * @return
	 */
	/*public static ArrayList<NovaTask> getHpcOverallWorkflowTaskList(InputStream inputStream){
		
		int event;
		//String text = null;
		String tagName = null;
		
		String taskId = null;
		String taskName = null;
		String taskType = null;
		
		String targetTaskId = null;
		String targetTaskName = null;
		String branchOrderId = null;
		
		String correspondingTaskId = null;
		String correspondingTaskName = null;
		
		NovaTask novaTask = null;
		NovaTargetTask novaTargetTask = null;
		NovaCorrespondingTask novaCorrespondingTask = null;
		ArrayList<NovaTask> novaTaskList = new ArrayList<NovaTask>();
		
		ArrayList<NovaTargetTask> novaTargetTaskList = null;
		
		try{
			
			xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = xmlFactoryObject.newPullParser();

            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            xmlPullParser.setInput(inputStream, null);
            
			XmlPullParser xmlPullParser = Xml.newPullParser();
			xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);    		
			xmlPullParser.setInput(reader);
			//xmlPullParser.nextTag(); 
            
			event = xmlPullParser.getEventType();
			while(event != xmlPullParser.END_DOCUMENT){
				
				tagName = xmlPullParser.getName();
				switch(event){
					case XmlPullParser.START_DOCUMENT:
						break;
						
					case XmlPullParser.START_TAG:
						
						*//**
						 * Parse task tag
						 *//*
						if(tagName.equals("task")){
							
							*//**
							 * Task Id, Name and Type are common to all type of tasks
							 *//*
							taskId = xmlPullParser.getAttributeValue(null, "id");
							if(!taskId.isEmpty()){
								Log.i(AppManager.TAG, "Task Id: " + taskId);
							}
							
							taskName = xmlPullParser.getAttributeValue(null, "name");
							if(!taskName.isEmpty()){
								Log.i(AppManager.TAG,"Task Name: " + taskName);
							}
							
							taskType = xmlPullParser.getAttributeValue(null, "type");
							
							if(!taskType.isEmpty()){
								Log.i(AppManager.TAG, "Task Type: " + taskType);
							}
							
							*//**
							 * Create NovaTask object and assign Id, Name and Type properties to this 
							 *//*
							novaTask = new NovaTask();
							novaTask.setId(Integer.parseInt(taskId));
							novaTask.setTaskName(taskName);
							novaTask.setTaskType(taskType);
							
							*//**
							 * If TaskType == OutputCondition, TargetTask, CorrespondingTak and TargetTaskList properties are null
							 *//*
							if(novaTask.getTaskType().equals(TaskType_OutputCondition)){
								novaTargetTask = null;
								//novaTask.setTargetTask(novaTargetTask);
								novaTask.setTargetTask(null);
								novaTask.setCorrespondingTask(null);
								novaTask.setTargetTaskList(null);
							}
							
							*//**
							 * If TaskType == XorSplitTask or XorJoinTask, initialize TargetTaskList Array
							 *//*
							if(novaTask.getTaskType() !=null && 
									((taskType.equals(TaskType_XorSplitTask)))){
								
								if(novaTargetTaskList == null){
									novaTargetTaskList = new ArrayList<NovaTargetTask>();
								}
							}
						}
						
						*//**
						 * Parse target tag
						 *//*
						if(tagName.equals("target")){
							
							*//**
							 * Id and Name are common to all Target Task
							 *//*
							targetTaskId = xmlPullParser.getAttributeValue(null, "id");
							if(!targetTaskId.isEmpty()){
								Log.i(AppManager.TAG, "Target Task Id: " + targetTaskId);
							}
							
							targetTaskName = xmlPullParser.getAttributeValue(null, "name");
							if(!targetTaskName.isEmpty()){
								Log.i(AppManager.TAG, "Target Task Name: " + targetTaskName);
							}
							
							novaTargetTask = new NovaTargetTask();
							novaTargetTask.setTaskId(Integer.parseInt(targetTaskId));
							novaTargetTask.setTaskName(targetTaskName);
							
							*//**
							 * BranchOrder property is specific to XorSplitTask task type
							 *//*
							if(novaTask.getTaskType().equals(TaskType_XorSplitTask)){
								branchOrderId = xmlPullParser.getAttributeValue(null, "branchorder");
								Log.i(AppManager.TAG, "Branch Order Id: " + branchOrderId);
								
								if(Integer.parseInt(branchOrderId)>0){
									novaTargetTask.setBranchOrderId(Integer.parseInt(branchOrderId));
								}
							}
							
							*//**
							 * If TaskType == InputCondition, XorJoinTask,UncompensableTask   or UncompensableTask, set TargetTask property of NovaTask object
							 *//*
							if(novaTask.getTaskType() !=null && 
									((novaTask.getTaskType().equals(TaskType_InputCondition)) || (novaTask.getTaskType().equals(TaskType_XorJoinTask))
											|| (novaTask.getTaskType().equals(TaskType_UncompensableTask)) || (novaTask.getTaskType().equals(TaskType_CompensableTask)))){
								
								novaTask.setTargetTask(novaTargetTask);
								//novaTask.setCorrespondingTask(null);
								novaTask.setTargetTaskList(null);
								
							}
							
							*//**
							 * If TaskType == InputCondition, UncompensableTask  or UncompensableTask, set TargetTask property of NovaTask object
							 *//*
							
							if(novaTask.getTaskType() !=null && 
									((novaTask.getTaskType().equals(TaskType_InputCondition)) 
											|| (novaTask.getTaskType().equals(TaskType_UncompensableTask)) || (novaTask.getTaskType().equals(TaskType_CompensableTask)))){
								
								novaTask.setCorrespondingTask(null);
								
							}
							
							*//**
							 * If TaskType == XorSplitTask, set TargetTask property to null
							 *//*
							if(novaTask.getTaskType() != null &&
									novaTask.getTaskType().equals(TaskType_XorSplitTask)){
								
								novaTask.setTargetTask(null);
							}
							
							
							*//**
							 * If TaskType == XorSplitTask or XorJoinTask, set TargetTaskList property of NovaTask
							 *//*
							if(novaTargetTaskList !=null && 
									(novaTask.getTaskType().equals(TaskType_XorSplitTask))){
								
								novaTargetTaskList.add(novaTargetTask);
								novaTask.setTargetTaskList(novaTargetTaskList);
							}
						}
						
						*//**
						 * Parse correspondingTask tag
						 *//*
						if(tagName.equals("correspondingTask")){
							
							correspondingTaskId = xmlPullParser.getAttributeValue(null, "id");
							if(!correspondingTaskId.isEmpty()){
								Log.i(AppManager.TAG, "Corresponding Task Id: " + correspondingTaskId);
							}
							
							correspondingTaskName = xmlPullParser.getAttributeValue(null, "name");
							if(!correspondingTaskName.isEmpty()){
								Log.i(AppManager.TAG, "Corresponding Task Name: " + correspondingTaskName);
							}
							
							novaCorrespondingTask = new NovaCorrespondingTask();
							novaCorrespondingTask.setCorrespondingtaskId(Integer.parseInt(correspondingTaskId));
							novaCorrespondingTask.setcorrespondingTaskName(correspondingTaskName);
							
							*//**
							 * if Task Type == XorSplitTask or XorJoinTask, set CorrespondingTask property 
							 *//*
							if((novaTask.getTaskType().equals(TaskType_XorSplitTask)) || (novaTask.getTaskType().equals(TaskType_XorJoinTask))){
								novaTask.setCorrespondingTask(novaCorrespondingTask);
							}
						}
						break;
					
					case XmlPullParser.TEXT:
						text = xmlPullParser.getText();
						if(!text.isEmpty()){
							Log.i(TAG, "Text: " + text);
						}
						break;
					case XmlPullParser.END_TAG:
						if(tagName.equals("task")){
							
							novaTaskList.add(novaTask);
							//Log.i(AppManager.TAG,"End of Task Block: " + novaTask.getName());
						}
						break;
					case XmlPullParser.END_DOCUMENT:
						break;
				}
				event = xmlPullParser.next(); 
			}
			
			//parsingComplete = true;
		}
		
		catch(Exception ex){
			//ex.printStackTrace();
		}
		return novaTaskList;
	}*/

	public static ArrayList<NovaTask> getHpcOverallWorkflowTaskListHavingBrnachOrder(InputStream inputStream){
		
		int event;
		//String text = null;
		String tagName = null;
		
		String taskId = null;
		String taskName = null;
		String taskType = null;
		
		String targetTaskId = null;
		String targetTaskName = null;
		String branchOrderId = null;
		
		String correspondingTaskId = null;
		String correspondingTaskName = null;
		
		String branchId = null;
		String sourceTaskId = null;
		
		NovaTask novaTask = null;
		NovaTargetTask novaTargetTask = null;
		NovaBranchOrder novaBranchOrder = null;
		
		NovaCorrespondingTask novaCorrespondingTask = null;
		ArrayList<NovaTask> novaTaskList = new ArrayList<NovaTask>();
		
		ArrayList<NovaTargetTask> novaTargetTaskList = null;
		
		try{
			
			xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = xmlFactoryObject.newPullParser();

            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            xmlPullParser.setInput(inputStream, null);
            
			/*XmlPullParser xmlPullParser = Xml.newPullParser();
			xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);    		
			xmlPullParser.setInput(reader);*/
			//xmlPullParser.nextTag(); 
            
			event = xmlPullParser.getEventType();
			while(event != xmlPullParser.END_DOCUMENT){
				
				tagName = xmlPullParser.getName();
				switch(event){
					case XmlPullParser.START_DOCUMENT:
						break;
						
					case XmlPullParser.START_TAG:
						
						/**
						 * Parse task tag
						 */
						if(tagName.equals("task")){
							
							/**
							 * Task Id, Name and Type are common to all type of tasks
							 */
							taskId = xmlPullParser.getAttributeValue(null, "id");
							if(!taskId.isEmpty()){
								Log.i(AppManager.TAG, "Task Id: " + taskId);
							}
							
							taskName = xmlPullParser.getAttributeValue(null, "name");
							if(!taskName.isEmpty()){
								Log.i(AppManager.TAG,"Task Name: " + taskName);
							}
							
							taskType = xmlPullParser.getAttributeValue(null, "type");
							
							if(!taskType.isEmpty()){
								Log.i(AppManager.TAG, "Task Type: " + taskType);
							}
							
							/**
							 * Create NovaTask object and assign Id, Name and Type properties to this 
							 */
							novaTask = new NovaTask();
							novaTask.setId(Integer.parseInt(taskId));
							novaTask.setTaskName(taskName);
							novaTask.setTaskType(taskType);
							
							/**
							 * If TaskType == OutputCondition, TargetTask, CorrespondingTak and TargetTaskList properties are null
							 */
							if(novaTask.getTaskType().equals(TaskType_OutputCondition)){
								novaTargetTask = null;
								//novaTask.setTargetTask(novaTargetTask);
								novaTask.setTargetTask(null);
								novaTask.setCorrespondingTask(null);
								novaTask.setTargetTaskList(null);
							}
							
							/**
							 * If TaskType == XorSplitTask or XorJoinTask, initialize TargetTaskList Array
							 */
							if(novaTask.getTaskType() !=null && 
									((taskType.equals(TaskType_XorSplitTask)))){
								
								if(novaTargetTaskList == null){
									novaTargetTaskList = new ArrayList<NovaTargetTask>();
								}
							}
						}
						
						/**
						 * Parse target tag
						 */
						if(tagName.equals("target")){
							
							/**
							 * Id and Name are common to all Target Task
							 */
							targetTaskId = xmlPullParser.getAttributeValue(null, "id");
							if(!targetTaskId.isEmpty()){
								Log.i(AppManager.TAG, "Target Task Id: " + targetTaskId);
							}
							
							targetTaskName = xmlPullParser.getAttributeValue(null, "name");
							if(!targetTaskName.isEmpty()){
								Log.i(AppManager.TAG, "Target Task Name: " + targetTaskName);
							}
							
							novaTargetTask = new NovaTargetTask();
							novaTargetTask.setTaskId(Integer.parseInt(targetTaskId));
							novaTargetTask.setTaskName(targetTaskName);
							
							/**
							 * BranchOrder property is specific to XorSplitTask task type
							 */
							if(novaTask.getTaskType().equals(TaskType_XorSplitTask)){
								branchOrderId = xmlPullParser.getAttributeValue(null, "branchorder");
								Log.i(AppManager.TAG, "Branch Order Id: " + branchOrderId);
								
								if(Integer.parseInt(branchOrderId)>0){
									novaTargetTask.setBranchOrderId(Integer.parseInt(branchOrderId));
								}
							}
							
							/**
							 * If TaskType == InputCondition, XorJoinTask,UncompensableTask   or UncompensableTask, set TargetTask property of NovaTask object
							 */
							if(novaTask.getTaskType() !=null && 
									((novaTask.getTaskType().equals(TaskType_InputCondition)) || (novaTask.getTaskType().equals(TaskType_XorJoinTask))
											|| (novaTask.getTaskType().equals(TaskType_UncompensableTask)) || (novaTask.getTaskType().equals(TaskType_CompensableTask)))){
								
								novaTask.setTargetTask(novaTargetTask);
								//novaTask.setCorrespondingTask(null);
								novaTask.setTargetTaskList(null);
								
							}
							
							/**
							 * If TaskType == InputCondition, UncompensableTask  or UncompensableTask, set TargetTask property of NovaTask object
							 */
							
							if(novaTask.getTaskType() !=null && 
									((novaTask.getTaskType().equals(TaskType_InputCondition)) 
											|| (novaTask.getTaskType().equals(TaskType_UncompensableTask)) || (novaTask.getTaskType().equals(TaskType_CompensableTask)))){
								
								novaTask.setCorrespondingTask(null);
								
							}
							
							/**
							 * If TaskType == XorSplitTask, set TargetTask property to null
							 */
							if(novaTask.getTaskType() != null &&
									novaTask.getTaskType().equals(TaskType_XorSplitTask)){
								
								novaTask.setTargetTask(null);
							}
							
							
							/**
							 * If TaskType == XorSplitTask or XorJoinTask, set TargetTaskList property of NovaTask
							 */
							if(novaTargetTaskList !=null && 
									(novaTask.getTaskType().equals(TaskType_XorSplitTask))){
								
								novaTargetTaskList.add(novaTargetTask);
								novaTask.setTargetTaskList(novaTargetTaskList);
							}
						}
						
						/**
						 * Parse correspondingTask tag
						 */
						if(tagName.equals("correspondingTask")){
							
							correspondingTaskId = xmlPullParser.getAttributeValue(null, "id");
							if(!correspondingTaskId.isEmpty()){
								Log.i(AppManager.TAG, "Corresponding Task Id: " + correspondingTaskId);
							}
							
							correspondingTaskName = xmlPullParser.getAttributeValue(null, "name");
							if(!correspondingTaskName.isEmpty()){
								Log.i(AppManager.TAG, "Corresponding Task Name: " + correspondingTaskName);
							}
							
							novaCorrespondingTask = new NovaCorrespondingTask();
							novaCorrespondingTask.setCorrespondingtaskId(Integer.parseInt(correspondingTaskId));
							novaCorrespondingTask.setcorrespondingTaskName(correspondingTaskName);
							
							/**
							 * if Task Type == XorSplitTask or XorJoinTask, set CorrespondingTask property 
							 */
							if((novaTask.getTaskType().equals(TaskType_XorSplitTask)) || (novaTask.getTaskType().equals(TaskType_XorJoinTask))){
								novaTask.setCorrespondingTask(novaCorrespondingTask);
							}
						}
						
						/**
						 * Parse branchOrder tag
						 */
						
						if(tagName.equals("branchOrder")){
							
							branchId = xmlPullParser.getAttributeValue(null,"id");
							if(!branchId.isEmpty()){
								Log.i(AppManager.TAG, "Branch Order Id: " + branchId);
							}
							
							sourceTaskId = xmlPullParser.getAttributeValue("", "sourcetaskid");
							if(!sourceTaskId.isEmpty()){
								Log.i(AppManager.TAG, "Source Task Id: " + sourceTaskId);
							}
							
							novaBranchOrder = new NovaBranchOrder();
							novaBranchOrder.setBranchOrderId(Integer.parseInt(branchId));
							novaBranchOrder.setSourceTaskId(Integer.parseInt(sourceTaskId));
							
							novaTask.setNovaBranchOrder(novaBranchOrder);
						}
						break;
					
					case XmlPullParser.TEXT:
						/*text = xmlPullParser.getText();
						if(!text.isEmpty()){
							Log.i(TAG, "Text: " + text);
						}*/
						break;
					case XmlPullParser.END_TAG:
						if(tagName.equals("task")){
							
							novaTaskList.add(novaTask);
							//Log.i(AppManager.TAG,"End of Task Block: " + novaTask.getName());
						}
						break;
					case XmlPullParser.END_DOCUMENT:
						break;
				}
				event = xmlPullParser.next(); 
			}
			
			//parsingComplete = true;
		}
		
		catch(Exception ex){
			//ex.printStackTrace();
		}
		return novaTaskList;
	}
	
	/*public boolean parseWorkflowModel(XmlPullParser xmlPullParser){
		
		int event;
		String text = null;
		String tagName = null;
		
		boolean parsingComplete = false;
		
		String taskId = null;
		String taskName = null;
		String taskType = null;
		
		String targetTaskId = null;
		String targetTaskName = null;
		
		NovaTask novaTask = null;
		NovaTargetTask novaTargetTask = null;
		//ArrayList<NovaTask> novaTaskList = new ArrayList<NovaTask>();
		
		try{
			
			event = xmlPullParser.getEventType();
			while(event != xmlPullParser.END_DOCUMENT){
				
				tagName = xmlPullParser.getName();
				switch(event){
					case XmlPullParser.START_DOCUMENT:
						break;
						
					case XmlPullParser.START_TAG:
						
						if(tagName.equals("task")){
							taskId = xmlPullParser.getAttributeValue(null, "id");
							if(!taskId.isEmpty()){
								Log.i(TAG, "Task Id: " + taskId);
							}
							
							taskName = xmlPullParser.getAttributeValue(null, "name");
							if(!taskName.isEmpty()){
								Log.i(TAG,"Task Name: " + taskName);
							}
							
							taskType = xmlPullParser.getAttributeValue(null, "type");
							
							if(!taskType.isEmpty()){
								Log.i(TAG, "Task Type: " + taskType);
							}
							
							//Construct NovaTask Object
							novaTask = new NovaTask();
							novaTask.setId(Integer.parseInt(taskId));
							novaTask.setTaskName(taskName);
							novaTask.setTaskType(taskType);
						}
						
						if(tagName.equals("target")){
							targetTaskId = xmlPullParser.getAttributeValue(null, "id");
							if(!targetTaskId.isEmpty()){
								Log.i(TAG, "Target Task Id: " + targetTaskId);
							}
							
							targetTaskName = xmlPullParser.getAttributeValue(null, "name");
							if(!targetTaskName.isEmpty()){
								Log.i(TAG, "Target Task Name: " + targetTaskName);
							}
							
							novaTargetTask = new NovaTargetTask();
							novaTargetTask.setTaskId(Integer.parseInt(targetTaskId));
							novaTargetTask.setTaskName(targetTaskName);
							
							novaTask.setTargetTask(novaTargetTask);
						}
						break;
					
					case XmlPullParser.TEXT:
						text = xmlPullParser.getText();
						if(!text.isEmpty()){
							Log.i(TAG, "Text: " + text);
						}
						break;
					case XmlPullParser.END_TAG:
						if(tagName.equals("task")){
							AppManager.novaTaskList.add(novaTask);
							Log.i(TAG,"End of Task Block: " + novaTask.getName());
						}
						break;
					case XmlPullParser.END_DOCUMENT:
						break;
				}
				event = xmlPullParser.next(); 
			}
			
			parsingComplete = true;
		}
		
		catch(Exception ex){
			ex.printStackTrace();
		}
		return parsingComplete;
	}
	
	public void downloadWorkflowModel(){
	      Thread thread = new Thread(new Runnable(){
	         @Override
	         public void run() {
	            try {
	               URL url = new URL(urlString);
	               HttpURLConnection conn = (HttpURLConnection) 
	               url.openConnection();
	               conn.setReadTimeout(10000  milliseconds );
	               conn.setConnectTimeout(15000  milliseconds );
	               conn.setRequestMethod("GET");
	               conn.setDoInput(true);
	               conn.connect();
	            
	               InputStream stream = conn.getInputStream();

	            xmlFactoryObject = XmlPullParserFactory.newInstance();
	            XmlPullParser xmlPullParser = xmlFactoryObject.newPullParser();

	            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
	            xmlPullParser.setInput(stream, null);
	            
	            parseAndStoreWorkflowModel(xmlPullParser);
	            
	            stream.close();
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	        }
	    });

	    thread.start(); 
	}

	public void parseAndStoreWorkflowModel(XmlPullParser xmlPullParser){
		
		int event;
		String text = null;
		String tagName = null;
		
		String taskId = null;
		String taskName = null;
		String taskType = null;
		
		String targetTaskId = null;
		String targetTaskName = null;
		
		NovaTask novaTask = null;
		NovaTargetTask novaTargetTask = null;
		ArrayList<NovaTask> novaTaskList = new ArrayList<NovaTask>();
		
		try{
			
			
			event = xmlPullParser.getEventType();
			while(event != xmlPullParser.END_DOCUMENT){
				
				tagName = xmlPullParser.getName();
				switch(event){
					case XmlPullParser.START_DOCUMENT:
						break;
						
					case XmlPullParser.START_TAG:
						
						if(tagName.equals("task")){
							taskId = xmlPullParser.getAttributeValue(null, "id");
							if(!taskId.isEmpty()){
								Log.i(AppManager.TAG, "Task Id: " + taskId);
							}
							
							taskName = xmlPullParser.getAttributeValue(null, "name");
							if(!taskName.isEmpty()){
								Log.i(AppManager.TAG,"Task Name: " + taskName);
							}
							
							taskType = xmlPullParser.getAttributeValue(null, "type");
							
							if(!taskType.isEmpty()){
								Log.i(AppManager.TAG, "Task Type: " + taskType);
							}
							
							//Construct NovaTask Object
							novaTask = new NovaTask();
							novaTask.setId(Integer.parseInt(taskId));
							novaTask.setTaskName(taskName);
							novaTask.setTaskType(taskType);
						}
						
						if(tagName.equals("target")){
							targetTaskId = xmlPullParser.getAttributeValue(null, "id");
							if(!targetTaskId.isEmpty()){
								Log.i(AppManager.TAG, "Target Task Id: " + targetTaskId);
							}
							
							targetTaskName = xmlPullParser.getAttributeValue(null, "name");
							if(!targetTaskName.isEmpty()){
								Log.i(AppManager.TAG, "Target Task Name: " + targetTaskName);
							}
							
							novaTargetTask = new NovaTargetTask();
							novaTargetTask.setTaskId(Integer.parseInt(targetTaskId));
							novaTargetTask.setTaskName(targetTaskName);
							
							novaTask.setTargetTask(novaTargetTask);
						}
						break;
					
					case XmlPullParser.TEXT:
						text = xmlPullParser.getText();
						if(!text.isEmpty()){
							Log.i(TAG, "Text: " + text);
						}
						break;
					case XmlPullParser.END_TAG:
						if(tagName.equals("task")){
							novaTaskList.add(novaTask);
							Log.i(AppManager.TAG,"End of Task Block: " + novaTask.getName());
						}
						break;
					case XmlPullParser.END_DOCUMENT:
						break;
				}
				event = xmlPullParser.next(); 
			}
			
			//parsingComplete = true;
		}
		
		catch(Exception ex){
			ex.printStackTrace();
		}
		//return novaTaskList;
	}*/
	
	
}
