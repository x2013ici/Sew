package com.stfx.sew;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.stfx.sew.dataholders.AllSelectedTasks;
import com.stfx.sew.dataholders.AllTaskConfiguration;
import com.stfx.sew.dataholders.AllTasks;
import com.stfx.sew.datamodel.Inputs;
import com.stfx.sew.datamodel.ConfiguredTask;
import com.stfx.sew.datamodel.OutputsIn;
import com.stfx.sew.datamodel.Qosinputs;
import com.stfx.sew.datamodel.TaskSpecification;
import com.stfx.sew.datamodel.TaskConfiguration;
import com.stfx.sew.datamodel.TaskDataModel;
import com.stfx.sew.datamodel.Workflow;
import com.stfx.sew.manager.AppManager;
import com.stfx.sew.util.SharedPreferenceHelper;

/**
 * 
 * @author Motsafijur Rahman
 * @since 25th April, 2015
 */
public class ChooseOutputConceptActivity extends Activity {

	
	CheckBox chkOutput1;
	CheckBox chkOutput2;
	CheckBox chkOutput3;
	
	CheckBox chkOutput4;
	CheckBox chkOutput5;
	CheckBox chkOutput6;
	CheckBox chkOutput7;
	
	CheckBox chkOutput8;
	CheckBox chkOutput9;
	CheckBox chkOutput10;
	
	Button btnDiscoverServices;
	ViewGroup llConfigureHolder;
	
	TextView txtOutputsBanner;
	
	ArrayList<CheckBox> checkBoxs;
	ArrayList<Integer> selectedCheckBoxIds;
	ArrayList<String> selectedCheckBoxTexts;
	
	String[] selectedOutputs;
	ArrayList<String> outputNames = new ArrayList<String>();
	
	Context context;
	boolean isConfiguring = false;
	
	String str = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_output_select);
		
		context = this;
		selectedCheckBoxTexts = new ArrayList<String>();
		
		//isConfiguring = getIntent().getBooleanExtra(AppManager.IS_CONFIGURING, false);
		
		/*txtOutputsBanner = (TextView)findViewById(R.id.txtOutputsBanner);
		if(isConfiguring){
			
			str = str + "Configuraing ";
			str = str + SharedPreferenceHelper.getSelectedWorkflowName(context);
			str = str + " -> ";
			str = str + AllSelectedTasks.getSelectedTaskById(getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1)).getTaskName();
			str = "Task (" + getResources().getString(R.string.txt_core_input_banner);
			str = str + " )";
			txtOutputsBanner.setText(str);
			
			txtOutputsBanner.setVisibility(View.VISIBLE);
		}*/
		
		/*btnDiscoverServices = (Button)findViewById(R.id.btnDiscoverServices);
		llConfigureHolder = (ViewGroup)findViewById(R.id.llConfigureHolder);
		if(isConfiguring){
			llConfigureHolder.setVisibility(View.VISIBLE);
			btnDiscoverServices.setVisibility(View.GONE);
		}
		else{
			llConfigureHolder.setVisibility(View.GONE);
			btnDiscoverServices.setVisibility(View.VISIBLE);
		}*/
		
		chkOutput1 = (CheckBox)findViewById(R.id.chkOutput1);
		chkOutput2 = (CheckBox)findViewById(R.id.chkOutput2);
		chkOutput3 = (CheckBox)findViewById(R.id.chkOutput3);
		
		chkOutput4 = (CheckBox)findViewById(R.id.chkOutput4);
		chkOutput5 = (CheckBox)findViewById(R.id.chkOutput5);
		chkOutput6 = (CheckBox)findViewById(R.id.chkOutput6);
		chkOutput7 = (CheckBox)findViewById(R.id.chkOutput7);
		
		chkOutput8 = (CheckBox)findViewById(R.id.chkOutput8);
		chkOutput9 = (CheckBox)findViewById(R.id.chkOutput9);
		chkOutput10 = (CheckBox)findViewById(R.id.chkOutput10);
		
		chkOutput1.setOnCheckedChangeListener(checkChange);
		chkOutput2.setOnCheckedChangeListener(checkChange);
		chkOutput3.setOnCheckedChangeListener(checkChange);
		
		chkOutput4.setOnCheckedChangeListener(checkChange);
		chkOutput5.setOnCheckedChangeListener(checkChange);
		chkOutput6.setOnCheckedChangeListener(checkChange);
		chkOutput7.setOnCheckedChangeListener(checkChange);
		
		chkOutput8.setOnCheckedChangeListener(checkChange);
		chkOutput9.setOnCheckedChangeListener(checkChange);
		chkOutput10.setOnCheckedChangeListener(checkChange);
		
		checkBoxs = new ArrayList<CheckBox>();
		checkBoxs.add(chkOutput1);
		checkBoxs.add(chkOutput2);
		checkBoxs.add(chkOutput3);
		
		checkBoxs.add(chkOutput4);
		checkBoxs.add(chkOutput5);
		checkBoxs.add(chkOutput6);
		checkBoxs.add(chkOutput7);
		
		checkBoxs.add(chkOutput8);
		checkBoxs.add(chkOutput9);
		checkBoxs.add(chkOutput10);
		
		
		
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
			
			saveOutputs();
			
			if(selectedCheckBoxIds.size() <= 0){
				Toast.makeText(context, "Please select at least one output instance", Toast.LENGTH_SHORT).show();
			}
			else{
				Intent intent = new Intent(this, QoSInputActivity.class);
				intent.putExtra(AppManager.IS_CONFIGURING, getIntent().getBooleanExtra(AppManager.IS_CONFIGURING, false));
				intent.putExtra(AppManager.SELECTED_TASK_ID, getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1));
				startActivity(intent);
			}
			
			/*if(isConfiguring){
				saveAllData();
			}
			else{
				search();
			}*/
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void saveOutputs(){
		
		
		selectedCheckBoxIds = new ArrayList<Integer>();
		
		for(int i = 0; i < checkBoxs.size(); i++){
			if(checkBoxs.get(i).isChecked()){
				selectedCheckBoxIds.add(i+1);
				outputNames.add(checkBoxs.get(i).getText().toString());
			}
		}
		if(selectedCheckBoxIds.size() > 0){
			int[] outputs = new int[selectedCheckBoxIds.size()];
			String[] outputsValues = new String[outputNames.size()];
			for(int i = 0; i < selectedCheckBoxIds.size(); i++){
				outputs[i] = selectedCheckBoxIds.get(i);
				outputsValues[i] = outputNames.get(i);
			}
			
			AppManager.getInstance().setOutputs(outputs);
			AppManager.getInstance().setOutputsValue(outputsValues);
			
			/**
			 * Add task to workflow
			 */
			
			/*int selectedTaskId = getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1);
			
			TaskDataModel tempTask = AllSelectedTasks.getSelectedTaskByIdAndRemove(selectedTaskId);
			
			TaskConfiguration taskConfiguration = new TaskConfiguration();
			taskConfiguration.setTaskId(tempTask.getId());
			
			//taskConfiguration.setSelectedCondition(AppManager.getInstance().getSelectedCondition());
			//taskConfiguration.setSelectedSymptom(AppManager.getInstance().getSelectedSymptom());
			
			taskConfiguration.setInputs(AppManager.getInstance().getInputIds());
			taskConfiguration.setQos(AppManager.getInstance().getQos());
			taskConfiguration.setOutputs(AppManager.getInstance().getOutputs());
			
			AllTaskConfiguration.addConfiguredTasks(taskConfiguration);*/
			
			/*Intent intent = new Intent(context, SelectedTasksActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);*/
			
			// Add task to Workflow and save Workflow task specifications to JSON file.
			//addTaskToWorkflow();
		}
		else{
			Toast.makeText(context, "Please select output concept(s)", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void cancelConfigure(View v){
		Intent intent = new Intent(context, SelectedTasksActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
	
	private void addTaskToWorkflow(){
		
		ConfiguredTask configuredTask = new ConfiguredTask();
		TaskSpecification taskSpecification = new TaskSpecification();
		
		//Add Inputs
		/*Inputs inputs = new Inputs();
		ArrayList<String> inps = new ArrayList<String>();
		inps.add(AppManager.getInstance().getSelectedConditionName());
		inps.add(AppManager.getInstance().getSelectedSymptomName());
		
		inputs.setInputconcept(inps);
		taskSpecification.setInputs(inputs);*/
		
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
		
		//Add QoS Inputs
		/*int[] qos = AppManager.getInstance().getQos();
		Qosinputs qosInputs = new Qosinputs();
		
		qosInputs.setResponseTime(AppManager.getInstance().getPriorityById(qos[0]));
		qosInputs.setExecutionPrice(AppManager.getInstance().getPriorityById(qos[1]));
		qosInputs.setReliability(AppManager.getInstance().getPriorityById(qos[2]));*/
		
		Qosinputs qosInputs = new Qosinputs();
		qosInputs.setResponseTime(AppManager.getInstance().getSelectedResponseTime());
		qosInputs.setExecutionPrice(AppManager.getInstance().getSelectedExecutionPrice());
		qosInputs.setReliability(AppManager.getInstance().getSelectedReliability());
		
		taskSpecification.setQosinputs(qosInputs);
		
		//Add Outputs
		/*OutputsIn outputsIn = new OutputsIn();
		outputsIn.setOutputconcept(selectedCheckBoxTexts);
		taskSpecification.setOutputs(outputsIn);*/
		
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
	
	public void searchServices(View v){
		search();
	}
	
	private void search(){
		if(selectedCheckBoxTexts != null && selectedCheckBoxTexts.size() > 0){
			selectedOutputs = new String[selectedCheckBoxTexts.size()];
			for(int i = 0; i< selectedCheckBoxTexts.size(); i++){
				selectedOutputs[i] = selectedCheckBoxTexts.get(i);
			}
			
			AppManager.getInstance().setOutputsValue(selectedOutputs);
			Intent intent = new Intent(context, DiscoveryServicesActivity.class);
			startActivity(intent);
		}
		else{
			Toast.makeText(context, "Please select output concept(s)", Toast.LENGTH_SHORT).show();
		}
		/*checkedIds = new ArrayList<Integer>();
		ArrayList<String> outputNames = new ArrayList<String>();
		for(int i = 0; i < checkBoxs.size(); i++){
			if(checkBoxs.get(i).isChecked()){
				checkedIds.add(i+1);
				outputNames.add(checkBoxs.get(i).getText().toString());
			}
		}
		
		if(checkedIds.size() > 0){
			int[] outputs = new int[checkedIds.size()];
			String[] outputsV = new String[outputNames.size()];
			for(int i = 0; i < checkedIds.size(); i++){
				outputs[i] = checkedIds.get(i);
				outputsV[i] = outputNames.get(i);
			}
			
			AppManager.getInstance().setOutputs(outputs);
			AppManager.getInstance().setOutputsValue(outputsV);
			
			Intent intent = new Intent(context, SearchReasultActivity.class);
			startActivity(intent);
		}
		else{
			Toast.makeText(context, "Please select output types", Toast.LENGTH_SHORT).show();
		}*/
	}
	
	public void saveConfigure(View v){
		saveOutputs();
	}
	
}
