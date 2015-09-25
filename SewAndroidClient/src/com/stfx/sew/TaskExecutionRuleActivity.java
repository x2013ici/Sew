package com.stfx.sew;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.stfx.sew.dataholders.AllSelectedTasks;
import com.stfx.sew.dataholders.AllTaskConfiguration;
import com.stfx.sew.dataholders.AllTasks;
import com.stfx.sew.datamodel.ConfiguredTask;
import com.stfx.sew.datamodel.Inputs;
import com.stfx.sew.datamodel.OutputsIn;
import com.stfx.sew.datamodel.Qosinputs;
import com.stfx.sew.datamodel.TaskConfiguration;
import com.stfx.sew.datamodel.TaskDataModel;
import com.stfx.sew.datamodel.TaskExecutionRules;
import com.stfx.sew.datamodel.TaskSpecification;
import com.stfx.sew.datamodel.Workflow;
import com.stfx.sew.manager.AppManager;
import com.stfx.sew.util.SharedPreferenceHelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class TaskExecutionRuleActivity extends Activity {

	CheckBox chkRule1;
	CheckBox chkRule2;
	CheckBox chkRule3;
	CheckBox chkRule4;
	
	ArrayList<CheckBox> checkBoxs;
	ArrayList<Integer> selectedCheckBoxIds;
	ArrayList<String> selectedCheckBoxTexts;
	
	String[] selectedRules;
	
	Context context;
	//boolean isConfiguring = false;
	
	String str = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_execution_rule);
		
		context = this;
		selectedCheckBoxTexts = new ArrayList<String>();
		
		chkRule1 = (CheckBox)findViewById(R.id.chkRule1);
		chkRule2 = (CheckBox)findViewById(R.id.chkRule2);
		chkRule3 = (CheckBox)findViewById(R.id.chkRule3);
		chkRule4 = (CheckBox)findViewById(R.id.chkRule4);
		
		chkRule1.setOnCheckedChangeListener(checkChange);
		chkRule2.setOnCheckedChangeListener(checkChange);
		chkRule3.setOnCheckedChangeListener(checkChange);
		chkRule4.setOnCheckedChangeListener(checkChange);
		
		checkBoxs = new ArrayList<CheckBox>();
		checkBoxs.add(chkRule1);
		checkBoxs.add(chkRule2);
		checkBoxs.add(chkRule3);
		checkBoxs.add(chkRule4);
		
		selectedCheckBoxIds = new ArrayList<Integer>();
	}
	
	private OnCheckedChangeListener checkChange = new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			if(isChecked){
				selectedCheckBoxTexts.add(buttonView.getText().toString());
			}
			else{
				selectedCheckBoxTexts.remove(buttonView.getText().toString());
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task_execution_rule, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			
			saveTaskExecutionRules();
			
			if(selectedCheckBoxIds.size() <=0){
				Toast.makeText(context, "Please Select at least Task Execution Rule", Toast.LENGTH_SHORT).show();
			}
			else{
				/**
				 * Add task to workflow
				 */
				
				int selectedTaskId = getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1);
				TaskDataModel tempTask = AllSelectedTasks.getSelectedTaskByIdAndRemove(selectedTaskId);
				
				TaskConfiguration taskConfiguration = new TaskConfiguration();
				taskConfiguration.setTaskId(tempTask.getId());
				
				taskConfiguration.setInputs(AppManager.getInstance().getInputIds());
				taskConfiguration.setQos(AppManager.getInstance().getQos());
				taskConfiguration.setOutputs(AppManager.getInstance().getOutputs());
				taskConfiguration.setTaskExecutionRules(AppManager.getInstance().getTaskExecutionRuleIds());
				
				AllTaskConfiguration.addConfiguredTasks(taskConfiguration);
				addTaskToWorkflow();
							
				Intent intent = new Intent(context, SelectedTasksActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
			
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void saveTaskExecutionRules(){
		try{
			selectedCheckBoxIds = new ArrayList<Integer>();
			ArrayList<String> ruleNames = new ArrayList<String>();
			for(int i = 0; i < checkBoxs.size(); i++){
				if(checkBoxs.get(i).isChecked()){
					selectedCheckBoxIds.add(i+1);
					ruleNames.add(checkBoxs.get(i).getText().toString());
				}
			}
			
			if(selectedCheckBoxIds.size() > 0){
				int[] ruleIds = new int[selectedCheckBoxIds.size()];
				String[] ruleValues = new String[ruleNames.size()];
				for(int i = 0; i < selectedCheckBoxIds.size(); i++){
					ruleIds[i] = selectedCheckBoxIds.get(i);
					ruleValues[i] = ruleNames.get(i);
				}
				
				AppManager.getInstance().setTaskExecutionRuleIds(ruleIds);
				AppManager.getInstance().setTaskExecutionRuleValues(ruleValues);
			}
		}
		catch(Exception ex){
			
		}
	}
	
	private void addTaskToWorkflow(){
		
		ConfiguredTask configuredTask = new ConfiguredTask();
		TaskSpecification taskSpecification = new TaskSpecification();
	
		// Process Input values
		Inputs inputs = new Inputs();
		ArrayList<String> inputValues = new ArrayList<String>();
		String[] selectedinputs = AppManager.getInstance().getInputValues();
		if(selectedinputs.length >0){
			for(int i=0;i <selectedinputs.length;i++){
				inputValues.add(selectedinputs[i].toString());
			}
		}
		inputs.setInputconcepts(inputValues);
		taskSpecification.setInputs(inputs);
		
		//Process QoS input values
		Qosinputs qosInputs = new Qosinputs();
		qosInputs.setResponseTime(AppManager.getInstance().getSelectedResponseTime());
		qosInputs.setExecutionPrice(AppManager.getInstance().getSelectedExecutionPrice());
		qosInputs.setReliability(AppManager.getInstance().getSelectedReliability());
		taskSpecification.setQosinputs(qosInputs);
		
		//Process Output values
		OutputsIn outputsIn = new OutputsIn();
		ArrayList<String> outputValues = new ArrayList<String>();
		
		String[] selectedoutputs = AppManager.getInstance().getOutputsValue();
		if(selectedoutputs.length >0){
			for(int i=0;i <selectedoutputs.length;i++){
				outputValues.add(selectedoutputs[i].toString());
			}
		}
		outputsIn.setOutputconcept(outputValues);
		taskSpecification.setOutputs(outputsIn);
		
		//Process Task Execution Rules
		TaskExecutionRules taskExecutionRules = new TaskExecutionRules();
		ArrayList<String> executionRules = new ArrayList<String>();
		
		String[] selectedTaskExecutionRules = AppManager.getInstance().getTaskExecutionRuleValues();
		if(selectedTaskExecutionRules.length >0){
			for(int i=0;i<selectedTaskExecutionRules.length;i++){
				executionRules.add(selectedTaskExecutionRules[i].toString());
			}
		}
		taskExecutionRules.setTaskExecutionRules(executionRules);
		taskSpecification.setTaskExecutionRules(taskExecutionRules);
		
		configuredTask.setTaskSpecification(taskSpecification);
		int tskId = getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1);
		
		if(tskId == -1){
			configuredTask.setTaskName("CommonTask");
		}
		else{
			configuredTask.setTaskName(AllTasks.getTaskById(tskId).getTaskName());
		}
		
		AppManager.getInstance().getWorkflow().addTask(configuredTask);
		
		// Save Workflow task specifications to JSON file
		Gson gson = new Gson();
		String strJson = gson.toJson(AppManager.getInstance().getWorkflow());
		
		writeOnFile(strJson);
		
	}

	private void writeOnFile(String configInJson){
		
		File dir = AppManager.createDirectory();
		String workflowName = SharedPreferenceHelper.getSelectedWorkflowName(context);
		if(TextUtils.isEmpty(workflowName)){
			workflowName = "Workflow";
		}
		File file = new File(dir, workflowName + ".json");
		if(file.exists()){
			file.delete();
		}

		//Write in file
		try{
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(configInJson.getBytes());
			fos.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		//Read from file to test
		try{
			Workflow fromSDCard = new Workflow();
			FileInputStream fis = new FileInputStream(file);
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
			System.out.println(fromSDCard.toString());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	/*	FileOutputStream outputStream;
		try{
			outputStream = openFileOutput(AppManager.fileName, Context.MODE_PRIVATE);
			outputStream.write(configInJson.getBytes());
			outputStream.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		Workflow fromSDCard = new Workflow();
		FileInputStream fin;
		try{
			fin = openFileInput(AppManager.fileName);
			StringBuffer sbf = new StringBuffer();
			int n;
			byte[] buffers = new byte[1024];
			while((n = fin.read(buffers)) != -1){
				sbf.append(new String(buffers, 0, n));
			}
			
			fin.close();
			
			String outStr = sbf.toString();
			Gson g = new Gson();
			fromSDCard = g.fromJson(outStr, Workflow.class);
			
			System.out.println(fromSDCard);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}*/
	}
	
}
