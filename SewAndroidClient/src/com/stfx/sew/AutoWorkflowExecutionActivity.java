package com.stfx.sew;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.http.Header;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.stfx.sew.BlockingQueueActivity.SewWebRequestReceiver;
import com.stfx.sew.dataholders.AllTasks;
import com.stfx.sew.dataholders.AllWorkflows;
import com.stfx.sew.datamodel.ConfiguredTask;
import com.stfx.sew.datamodel.DiscoverServiceResponceModel;
import com.stfx.sew.datamodel.DiscoveredService;
import com.stfx.sew.datamodel.ExecuteServiceDM;
import com.stfx.sew.datamodel.NovaTask;
import com.stfx.sew.datamodel.ServiceDiscoveryRequest;
import com.stfx.sew.datamodel.TaskDataModel;
import com.stfx.sew.datamodel.TaskSpecification;
import com.stfx.sew.datamodel.Workflow;
import com.stfx.sew.datamodel.WorkflowDataModel;
import com.stfx.sew.manager.AppManager;
import com.stfx.sew.manager.WorkflowExecutionManager;
import com.stfx.sew.util.AllUrls;
import com.stfx.sew.util.NetInfo;

/**
 * 
 * @author Mostafijur Rahman
 * @since 4nd May, 2015
 */
public class AutoWorkflowExecutionActivity extends Activity {

	
	Context context;
	Gson gsonObject;
	
	ProgressDialog pd;
	Handler handler;
	
	ArrayList<Workflow> savedWorkflows;
	ExpandableListView lstWorkflowList;
	
	static int selectedId = -1;
	ServiceDiscoveryRequest serviceInput = null;
	
	private SewServiceDiscoveryResultReceiver receiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto_workflow_execution);
		
		context = this;
		gsonObject = new Gson();
		handler = new Handler();
		savedWorkflows = new ArrayList<Workflow>();
		
		lstWorkflowList = (ExpandableListView)findViewById(R.id.lstWorkflowList);
		lstWorkflowList.setAdapter(new ConfigureWorkflowAdapter());
		lstWorkflowList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		loadSavedWorkflowConfiguration();
		
		// Register Broadcast Receiver
		IntentFilter filter = new IntentFilter(SewServiceDiscoveryResultReceiver.PROCESS_RESPONSE);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        
        receiver = new SewServiceDiscoveryResultReceiver();
        registerReceiver(receiver, filter);
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
	
	@Override
    public void onDestroy() {
        this.unregisterReceiver(receiver);
        super.onDestroy();
    }
	
	/**
	 * 
	 * @param v
	 */
	public void executionWorkflow(View v){
		
		
		ConfiguredTask matchedConfiguredTask =null;
		//ArrayList<NovaTask> novaTaskList = null;
		
		try{
			
			if (!NetInfo.isOnline(context)) {
				Toast.makeText(context, "Please connect to the Internet and try again", Toast.LENGTH_SHORT).show();
				return;
			}
			
			if(selectedId < 0){
				Toast.makeText(context, "Please Select a Workflow", Toast.LENGTH_SHORT).show();
			}
			else{
				
				// Select Workflow Specific Task List
				//AppManager.selectedWorkflowIndex = selectedId;
				
				// Populate AppManager.workflowSpecificConfiguredTaskList to access it from IntentService
				ArrayList<ConfiguredTask> configurdTaskList = savedWorkflows.get(selectedId).getTaskList();
				if(configurdTaskList.size()>0){
					for(ConfiguredTask configuredTask : configurdTaskList){
						AppManager.workflowSpecificConfiguredTaskList.put(configuredTask.getTaskName(), configuredTask);
					}
				}
				
				// Iterate over configured task list of the selected workflow to initiate service discovery request for each task
				if(AppManager.hpcOverallNovaTaskList.size()>0 && AppManager.workflowSpecificConfiguredTaskList.size() >0){
					
					Intent taskIntent = new Intent(AutoWorkflowExecutionActivity.this,SewServiceDiscoveryIntentService.class);
					for(NovaTask novaTask : AppManager.hpcOverallNovaTaskList){
						
						matchedConfiguredTask = AppManager.workflowSpecificConfiguredTaskList.get(novaTask.getName());
						if(matchedConfiguredTask !=null){
							taskIntent.putExtra(SewServiceDiscoveryIntentService.REQUESTED_TASK_ID, novaTask.getId());
							taskIntent.putExtra(SewServiceDiscoveryIntentService.REQUESTED_TASK_NAME, matchedConfiguredTask.getTaskName());
							startService(taskIntent);
						}
					}
					
					// Send Finish/End task to IntentService to notify the workflow execution status
					taskIntent.putExtra(SewServiceDiscoveryIntentService.REQUESTED_TASK_ID, WorkflowExecutionManager.FINISH_TASK_ID);
					taskIntent.putExtra(SewServiceDiscoveryIntentService.REQUESTED_TASK_NAME, WorkflowExecutionManager.FINISH_TASK_NAME);
					startService(taskIntent);
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		/**
		 * Automatic Worklfow Exeuction using AsyncTask level implemenation
		 */
		/*TaskSpecification taskSpecification = null; 
		ConfiguredTask matchedConfiguredTask =null;
		ArrayList<NovaTask> novaTaskList = null;
		
		if (!NetInfo.isOnline(context)) {
			Toast.makeText(context, "Please connect to the Internet and try again", Toast.LENGTH_SHORT).show();
			return;
		}
		
		if(selectedId < 0){
			Toast.makeText(context, "Please Select a Workflow", Toast.LENGTH_SHORT).show();
		}
		else{
			
			if(savedWorkflows.size()>0){
				
				if(selectedId ==0 ){
					novaTaskList = AppManager.hpcSequencialNovaTaskList;
				}
				else{
					novaTaskList = AppManager.hpcOverallNovaTaskList;
				}
				
				ArrayList<ConfiguredTask> configurdTaskList = savedWorkflows.get(selectedId).getTaskList();
				if(configurdTaskList.size()>0){
					for(ConfiguredTask configuredTask : configurdTaskList){
						AppManager.workflowSpecificConfiguredTaskList.put(configuredTask.getTaskName(), configuredTask);
					}
				}
				
				if(novaTaskList.size()>0 && AppManager.workflowSpecificConfiguredTaskList.size() >0){
					
					for(NovaTask novaTask : novaTaskList){
						
						matchedConfiguredTask = AppManager.workflowSpecificConfiguredTaskList.get(novaTask.getName());
						
						
						if(matchedConfiguredTask !=null){
							
							serviceInput = new ServiceDiscoveryRequest();
							
							//AppManager.hpcSequencialWorkflowSpecificConfiguredTaskList.put(matchedConfiguredTask.getTaskName(), matchedConfiguredTask);
							
							taskSpecification = matchedConfiguredTask.getTaskSpecification();
							
							String input = "";
							for(int i = 0; i< taskSpecification.getInputs().getInputconcept().size(); i++){
								input = input + taskSpecification.getInputs().getInputconcept().get(i);
								input = input + ":";
							}
							input = input.trim();
							if(input.endsWith(":")){
								input = input.substring(0, input.length() - 1);
							}
							
							serviceInput.setInput(input);
							
							String responseTimeValue = taskSpecification.getQosinputs().getResponseTime();
							String executionPriceValue = taskSpecification.getQosinputs().getExecutionPrice();
							String reliabilityValue = taskSpecification.getQosinputs().getReliability();
							
							String qosInput = getQoSInputInSequence(responseTimeValue,executionPriceValue,reliabilityValue);
							serviceInput.setQos(qosInput);
							
							String outputs = "";
							for(int i = 0; i<taskSpecification.getOutputs().getOutputconcept().size(); i++){
								outputs = outputs + taskSpecification.getOutputs().getOutputconcept().get(i);
								outputs = outputs + ":";
							}
							outputs = outputs.trim();
							if(outputs.endsWith(":")){
								outputs = outputs.substring(0, outputs.length() - 1);
							}
							serviceInput.setOutput(outputs);
							
							try{
								DiscoverHpcSemanticWebServices(serviceInput);
							}
							catch(Exception ex){
								
							}
						}
						matchedConfiguredTask = null;
					}
				}
			}
		}*/
	}

	/**
	 * 
	 * @param serviceInput
	 */
	/*private void DiscoverHpcSemanticWebServices(ServiceDiscoveryRequest serviceInput) {
		
		String constructedServiceUrl = null;
		try{
			
			constructedServiceUrl = AllUrls.getHpcServiceDiscoveryUrl(serviceInput);
			
			AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
			asyncHttpClient.setTimeout(120000);
			asyncHttpClient.get(constructedServiceUrl, new AsyncHttpResponseHandler() {

				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] response) {
					// TODO Auto-generated method stub
					
					String responseString = new String(response);
					DiscoverServiceResponceModel discoveryServiceResponseModel = gsonObject.fromJson(responseString, DiscoverServiceResponceModel.class);
					System.out.println(discoveryServiceResponseModel.getInputModel());
					if(discoveryServiceResponseModel.isOperationSuccessfull() && discoveryServiceResponseModel.isResult()){
						
						if(discoveryServiceResponseModel.getServiceList().size()>0){
							//Execute top most service of the list
							WorkflowExecutionManager.taskSpecificDiscoveredServiceList = discoveryServiceResponseModel.getServiceList();
							
							if(WorkflowExecutionManager.taskSpecificDiscoveredServiceList.size()>0){
								Toast.makeText(context, "Total Matched Semantic Web Service: " + WorkflowExecutionManager.taskSpecificDiscoveredServiceList.size(), Toast.LENGTH_SHORT).show();
							}
							else{
								Toast.makeText(context, "No Semantic Web Service Fourd for the current Task...", Toast.LENGTH_SHORT).show();
							}
							
							
							DiscoveredService discoveredService = WorkflowExecutionManager.taskSpecificDiscoveredServiceList.get(AppManager.TOP_MOST_SERVICE_INDEX);
							if(discoveredService !=null){
								ExecuteSelectedService(discoveredService);
							}
							else{
								Toast.makeText(context, "No Semantic Web Service Fourd for the current Task...", Toast.LENGTH_SHORT).show();
							}
						}
						else{
							Toast.makeText(context, "No Semantic Web Service Found for the Current Request...", Toast.LENGTH_SHORT).show();
						}
					}
					else{
						Toast.makeText(context, "No Semantic Web Service Fourd for the Current Request...", Toast.LENGTH_SHORT).show();
						//Toast.makeText(context, "Failed to Execute Current Semantic Web Service Discovery Request...", Toast.LENGTH_SHORT).show();
					}
				}

				@Override
				public void onFailure(int statusCode, Header[] headers, byte[] responce, Throwable th) {
					// TODO Auto-generated method stub
					Toast.makeText(context, "Error occured while discovering semantic web services... " + th, Toast.LENGTH_SHORT).show();
				}
			});
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	/**
	 * 
	 * @param discoveredService
	 */
	/*private void ExecuteSelectedService(DiscoveredService discoveredService){
		
		try{
			
			if(discoveredService !=null){
				
				String url = AllUrls.getExecuteServiceUrl(discoveredService.getId() + "");
				
				AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
				asyncHttpClient.setTimeout(12000);
				asyncHttpClient.get(url, new AsyncHttpResponseHandler(){

					@Override
					public void onFailure(int statusCode, Header[] headers, byte[] response,
								Throwable th) {
							// TODO Auto-generated method stub
							pd.dismiss();
							Toast.makeText(context, "Error occured while discovering semantic web services... " + th, Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onSuccess(int statusCode, Header[] headers, byte[] response) {
						// TODO Auto-generated method stub
						//pd.dismiss();
						String responseString = new String(response);
						Gson gson = new Gson();
						ExecuteServiceDM es = gson.fromJson(responseString, ExecuteServiceDM.class);
						//Toast.makeText(context, es.getMessage(), Toast.LENGTH_SHORT).show();
						Toast.makeText(context, "Successfully executed the top ranked Service...", Toast.LENGTH_SHORT).show();
					}
							
				});
			}
		}
		catch(Exception ex){
			
		}
	}*/

	/**
	 * 
	 */
	private void loadSavedWorkflowConfiguration(){
		savedWorkflows = new ArrayList<Workflow>();
		File dir = AppManager.createDirectory();
		
		File[] allFiles = dir.listFiles();
		if(allFiles.length > 0){
			for (File file : allFiles) {
				if(file.getName().endsWith(".json")){
					Workflow workFlow = parseWorkflow(file);
					if(workFlow != null){
						savedWorkflows.add(workFlow);
					}
				}
			}
		}
		else{
			Toast.makeText(context, "No configured workflow found", Toast.LENGTH_SHORT).show();
		}
		
		((BaseAdapter)lstWorkflowList.getAdapter()).notifyDataSetChanged();
		lstWorkflowList.invalidate();
	}
	
	/**
	 * 
	 * @param workflowFile
	 * @return
	 */
	private Workflow parseWorkflow(File workflowFile){
		Workflow fromSDCard = null;
		try{
			fromSDCard = new Workflow();
			FileInputStream fis = new FileInputStream(workflowFile);
			StringBuffer sbf = new StringBuffer();
			int n;
			byte[] buffers = new byte[1024];
			while((n = fis.read(buffers)) != -1){
				sbf.append(new String(buffers, 0, n));
			}
			fis.close();
			
			String outStr = sbf.toString();
			Gson g = new Gson();
			fromSDCard = g.fromJson(outStr, Workflow.class);
			if(!workflowFile.getName().isEmpty()){
				String workflowName = workflowFile.getName().substring(0,workflowFile.getName().length()- 5);
				fromSDCard.setWorkflowName(workflowName);
			}
			
			System.out.println(fromSDCard.toString());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return fromSDCard;
	}
	
	/**
	 * 
	 * @author Mostafijur Rahman
	 *
	 */
	private class ConfigureWorkflowAdapter extends BaseExpandableListAdapter{

		@Override
		public int getGroupCount() {
			return savedWorkflows.size();
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return savedWorkflows.get(groupPosition).getTaskList().size();
		}

		@Override
		public Object getGroup(int groupPosition) {
			return savedWorkflows.get(groupPosition);
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return savedWorkflows.get(groupPosition).getTaskList().get(childPosition);
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

		@Override
		public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
			if(convertView == null){
				convertView = LayoutInflater.from(context).inflate(R.layout.row_configured_workflow, parent, false);
			}
			
			Workflow workFlow = savedWorkflows.get(groupPosition);
			TextView workflowName = (TextView)convertView.findViewById(R.id.txtConfWorkflowName);
			RadioButton rbSelected = (RadioButton)convertView.findViewById(R.id.rbSelecte);
			workflowName.setText(workFlow.getWorkflowName());
			if(selectedId == groupPosition){
				rbSelected.setChecked(true);
			}
			else{
				rbSelected.setChecked(false);
			}
			
			rbSelected.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					selectedId = groupPosition;
					//AppManager.selectedWorkflowIndex = selectedId;
					
					((BaseAdapter)lstWorkflowList.getAdapter()).notifyDataSetChanged();
					lstWorkflowList.invalidate();
				}
			});
			
			return convertView;
		}

		/**
		 * 
		 */
		@Override
		public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
			
			if(convertView == null){
				convertView = LayoutInflater.from(context).inflate(R.layout.row_workflow_task, parent, false);
			}
			
			ConfiguredTask configuredTask = savedWorkflows.get(groupPosition).getTaskList().get(childPosition);
			TaskSpecification taskSpecification = configuredTask.getTaskSpecification();
			
			TextView txtTaskname = (TextView)convertView.findViewById(R.id.txtTaskname);
			TextView txtInputs = (TextView)convertView.findViewById(R.id.txtInputs);
			
			TextView txtReceptionValue = (TextView)convertView.findViewById(R.id.txtReceptionValue);
			TextView txtExecutionValue = (TextView)convertView.findViewById(R.id.txtExecutionValue);
			TextView txtReliability = (TextView)convertView.findViewById(R.id.txtReliability);
			TextView txtOutput = (TextView)convertView.findViewById(R.id.txtOutput);
			
			TextView txtExecutionRules = (TextView) convertView.findViewById(R.id.txtExecutionRules);
			
			txtTaskname.setText(configuredTask.getTaskName());
			
			String input = "";
			for(int i = 0; i< taskSpecification.getInputs().getInputconcepts().size(); i++){
				input = input + taskSpecification.getInputs().getInputconcepts().get(i);
				input = input + ",";
			}
			input = input.trim();
			if(input.endsWith(",")){
				input = input.substring(0, input.length() - 1);
			}
			txtInputs.setText(input);
			
			txtReceptionValue.setText(taskSpecification.getQosinputs().getResponseTime());
			txtExecutionValue.setText(taskSpecification.getQosinputs().getExecutionPrice());
			txtReliability.setText(taskSpecification.getQosinputs().getReliability());
			
			String outputs = "";
			for(int i = 0; i<taskSpecification.getOutputs().getOutputconcept().size(); i++){
				outputs = outputs + taskSpecification.getOutputs().getOutputconcept().get(i);
				outputs = outputs + ",";
			}
			outputs = outputs.trim();
			if(outputs.endsWith(",")){
				outputs = outputs.substring(0, outputs.length() - 1);
			}
			txtOutput.setText(outputs);
			
			String executionRules = "";
			for(int i=0;i<taskSpecification.getTaskExecutionRules().getTaskExecutionRules().size();i++){
				executionRules = executionRules + taskSpecification.getTaskExecutionRules().getTaskExecutionRules().get(i);
				executionRules = executionRules + ", ";
			}
			
			executionRules = executionRules.trim();
			if(executionRules.endsWith(",")){
				executionRules = executionRules.substring(0, executionRules.length() - 1);
			}
			
			txtExecutionRules.setText(executionRules);
			
			return convertView;
		}

		/**
		 * 
		 */
		
		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
		
		/*private  String getQoSInputInSequence(String responseTimeValue,
				String executionPriceValue, String reliabilityValue) {
			
			// TODO Auto-generated method stub
			String qoSInput = null;
			try{
				
				if(!responseTimeValue.isEmpty() && !executionPriceValue.isEmpty() && !reliabilityValue.isEmpty()){
					
					//High
					if(responseTimeValue.equals(WorkflowExecutionManager.HIGH))
						qoSInput = qoSInput + WorkflowExecutionManager.ResponseTime;
					else if(executionPriceValue.equals(WorkflowExecutionManager.HIGH))
						qoSInput = qoSInput + WorkflowExecutionManager.ExecutionPrice;
					else if(reliabilityValue.equals(WorkflowExecutionManager.HIGH))
						qoSInput = qoSInput + WorkflowExecutionManager.Reliability;
					
					
					//Medium
					qoSInput = qoSInput + ":";
					
					if(responseTimeValue.equals(WorkflowExecutionManager.MEDIUM))
						qoSInput = qoSInput + WorkflowExecutionManager.ResponseTime;
					else if(executionPriceValue.equals(WorkflowExecutionManager.MEDIUM))
						qoSInput = qoSInput + WorkflowExecutionManager.ExecutionPrice;
					else if(reliabilityValue.equals(WorkflowExecutionManager.MEDIUM))
						qoSInput = qoSInput + WorkflowExecutionManager.Reliability;
					
					//Low
					qoSInput = qoSInput + ":";
					
					if(responseTimeValue.equals(WorkflowExecutionManager.LOW))
						qoSInput = qoSInput + WorkflowExecutionManager.ResponseTime;
					else if(executionPriceValue.equals(WorkflowExecutionManager.LOW))
						qoSInput = qoSInput + WorkflowExecutionManager.ExecutionPrice;
					else if(reliabilityValue.equals(WorkflowExecutionManager.LOW))
						qoSInput = qoSInput + WorkflowExecutionManager.Reliability;
					
				}
			}
			catch(Exception ex){
				
			}
			return qoSInput;
		}*/
		
		/*private void setDummyData(){
			
			try{
			
				// Hospice Palliative Care Work-flow
				AllWorkflows.removeAll();
				WorkflowDataModel workflowDataModel = new WorkflowDataModel();
				workflowDataModel.setId(AppManager.HOSPICE_PALLIATIVE_CARE_WORKFLOW_ID);
				workflowDataModel.setWorkflowName(AppManager.HOSPICE_PALLIATIVE_CARE_WORKFLOW_NAME);
				AllWorkflows.addWorkflow(workflowDataModel);
				
				// Ambulatory Blood Pressure Measurement Work-flow
				workflowDataModel = new WorkflowDataModel();
				workflowDataModel.setId(AppManager.AMBULATORY_BLOOD_PRESSURE_MEASUREMENT_WORKFLOW_ID);
				workflowDataModel.setWorkflowName(AppManager.AMBULATORY_BLOOD_PRESSURE_MEASUREMENT_WORKFLOW_NAME);
				AllWorkflows.addWorkflow(workflowDataModel);
			}
			catch(Exception ex){
				
			}
		}*/
	}
	
	/**
	 * SewServiceDiscoveryResultReceiver receives broadcasted results initiated by SewServiceDiscoveryIntentService
	 * Process the result and display it to the UI
	 */
	public class SewServiceDiscoveryResultReceiver extends BroadcastReceiver{
		 
        int defaultValue = 0;
        String selectedPatient = "";
        String selectedPhysician = "";
        
        String selectedCaregiver = "";
		public static final String PROCESS_RESPONSE = "com.as400samplecode.intent.action.PROCESS_RESPONSE";

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			
			int taskId = intent.getIntExtra(SewServiceDiscoveryIntentService.RESPONSE_TASK_ID, defaultValue);
			
			if(taskId >0){
				
				switch(taskId){
					case 1:
						// Start: InputCondition
						// InputCondition type of task will not be passed to Background thread
						break;
					case 2:
						// OutputCondition: OutputCondition
						// OutputCondition type of task will not be passed to Background thread
						try {
			            	
							//SystemClock.sleep(10000);
			            	Toast.makeText(context, "Workflow has been executed successfully!!!", Toast.LENGTH_LONG).show();
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
						break;
					case 3:
						// Discover_Select_Patient: UncompensableTask
						selectedPatient = intent.getStringExtra(SewServiceDiscoveryIntentService.SELECTED_PATIENT_NAME);
						String responseTaskExecutionTime = intent.getStringExtra(SewServiceDiscoveryIntentService.RESPONSE_TASK_EXECUTION_TIME);
			            try {
			            	
			            	//SystemClock.sleep(5000);
			            	Toast.makeText(context, responseTaskExecutionTime, Toast.LENGTH_LONG).show();
			            	Toast.makeText(context, "Task Execution Result --> Selected Patient: " + selectedPatient, Toast.LENGTH_LONG).show();
			            	
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
						break;
					case 4:
						// Discover_Select_Physician: UncompensableTask
						selectedPhysician = intent.getStringExtra(SewServiceDiscoveryIntentService.SELECTED_PHYSICIAN_NAME);
						responseTaskExecutionTime = intent.getStringExtra(SewServiceDiscoveryIntentService.RESPONSE_TASK_EXECUTION_TIME);
			            try {
			            	//SystemClock.sleep(5000);
			            	Toast.makeText(context, responseTaskExecutionTime, Toast.LENGTH_LONG).show();
			            	Toast.makeText(context, "Task Execution Result --> Selected Physican: " + selectedPhysician, Toast.LENGTH_LONG).show();
			            	
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
						break;
					case 5:
						// Setup_Appointment: UncompensableTask
						boolean isSetupAppointment = intent.getBooleanExtra(SewServiceDiscoveryIntentService.IS_APPOINTMENT_SETUP,false);
						responseTaskExecutionTime = intent.getStringExtra(SewServiceDiscoveryIntentService.RESPONSE_TASK_EXECUTION_TIME);
			            try {
			            	//SystemClock.sleep(5000);
			            	Toast.makeText(context, responseTaskExecutionTime, Toast.LENGTH_LONG).show();
			            	if(isSetupAppointment){
			            		Toast.makeText(context, "Task Execution Result: Appointment has been setup successfully.", Toast.LENGTH_LONG).show();
			            	}
			            	else{
			            		Toast.makeText(context, "Task Execution Result: Failed to setup Appointment.", Toast.LENGTH_LONG).show();
			            	}
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
						break;
					case 6:
						// Consult: UncompensableTask
						boolean isConsulted = intent.getBooleanExtra(SewServiceDiscoveryIntentService.IS_CONSULTED,false);
						boolean isEligible = intent.getBooleanExtra(SewServiceDiscoveryIntentService.IS_ELIGIBLE,false);
						
						responseTaskExecutionTime = intent.getStringExtra(SewServiceDiscoveryIntentService.RESPONSE_TASK_EXECUTION_TIME);
			            try {
			            	//SystemClock.sleep(5000);
			            	Toast.makeText(context, responseTaskExecutionTime, Toast.LENGTH_LONG).show();
			            	if(isConsulted && isEligible){
			            		Toast.makeText(context, "Task Execution Result: the " + selectedPatient + " is eligible for the pgoram", Toast.LENGTH_LONG).show();
			            	}
			            	else{
			            		Toast.makeText(context, "Task Execution Result: the " + selectedPatient + " is not eligible for the program.", Toast.LENGTH_LONG).show();
			            	}
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
						break;
					case 7:
						// Patient_Valid: XorSplitTask
						break;
					case 8:
						// Discover_Select_Caregiver: UncompensableTask
						selectedCaregiver = intent.getStringExtra(SewServiceDiscoveryIntentService.SELECTED_CARE_GIVER);
						responseTaskExecutionTime = intent.getStringExtra(SewServiceDiscoveryIntentService.RESPONSE_TASK_EXECUTION_TIME);
			            try {
			            	//SystemClock.sleep(5000);
			            	Toast.makeText(context, responseTaskExecutionTime, Toast.LENGTH_LONG).show();
			            	Toast.makeText(context, "Task Execution Result --> Selected Caregiver: " + selectedCaregiver, Toast.LENGTH_LONG).show();
			            	
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
						break;
					case 9:
						// Explanation: UncompensableTask
						boolean isExplained = intent.getBooleanExtra(SewServiceDiscoveryIntentService.IS_EXPLAINED,false);
						responseTaskExecutionTime = intent.getStringExtra(SewServiceDiscoveryIntentService.RESPONSE_TASK_EXECUTION_TIME);
			            try {
			            	//SystemClock.sleep(5000);
			            	Toast.makeText(context, responseTaskExecutionTime, Toast.LENGTH_LONG).show();
			            	if(isExplained){
			            		Toast.makeText(context, "Task Execution Result: Explanation has been save for: " + selectedPatient, Toast.LENGTH_LONG).show();
			            	}
			            	else{
			            		Toast.makeText(context, "Task Execution Result: Failed to describe explanation for: " + selectedPatient, Toast.LENGTH_LONG).show();
			            	}
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
						break;
					case 10:
						// Finished: XorJoinTask
						break;
					case 11:
						// Deliver_Care: UncompensableTask
						boolean isDeliveredCare = intent.getBooleanExtra(SewServiceDiscoveryIntentService.IS_DELIVERED_CARE,false);
						responseTaskExecutionTime = intent.getStringExtra(SewServiceDiscoveryIntentService.RESPONSE_TASK_EXECUTION_TIME);
			            try {
			            	//SystemClock.sleep(5000);
			            	Toast.makeText(context, responseTaskExecutionTime, Toast.LENGTH_LONG).show();
			            	if(isDeliveredCare){
			            		Toast.makeText(context, "Task Execution Result: Care delivered to the patient: " + selectedPatient + " successfully", Toast.LENGTH_LONG).show();
			            	}
			            	else{
			            		Toast.makeText(context, "Task Execution Result: Failed to deliver care to the patient: " + selectedPatient, Toast.LENGTH_LONG).show();
			            	}
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
						break;
					case 12:
						// Prescribe_Drugs: UncompensableTask
						boolean isPrescribedDrug = intent.getBooleanExtra(SewServiceDiscoveryIntentService.IS_DRUG_PRESCRIBED,false);
						responseTaskExecutionTime = intent.getStringExtra(SewServiceDiscoveryIntentService.RESPONSE_TASK_EXECUTION_TIME);
			            try {
			            	//SystemClock.sleep(1000);
			            	Toast.makeText(context, responseTaskExecutionTime, Toast.LENGTH_LONG).show();
			            	if(isPrescribedDrug){
			            		Toast.makeText(context, "Task Execution Result: Drugs are prescribed to the patient: " + selectedPatient + " successfully", Toast.LENGTH_LONG).show();
			            	}
			            	else{
			            		Toast.makeText(context, "Task Execution Result: Failed to prescribe drugs to the patient: " + selectedPatient, Toast.LENGTH_LONG).show();
			            	}
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
						break;
					default:
						break;
					}
			}
		}
    }
}
