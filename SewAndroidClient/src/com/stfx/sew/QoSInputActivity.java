package com.stfx.sew;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class QoSInputActivity extends Activity  implements OnItemSelectedListener{

	
	Spinner spnExecutionPrice;
	Spinner spnResponseTime;
	Spinner spnReliability;
	
	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qos_input);
		
		context = QoSInputActivity.this;
		// Execution Price Spinner 
        spnExecutionPrice = (Spinner) findViewById(R.id.spnExecutionPrice);
        spnExecutionPrice.setOnItemSelectedListener(this);
        
        
		// Response Time Spinner
		spnResponseTime = (Spinner)findViewById(R.id.spnResponseTime);
		spnResponseTime.setOnItemSelectedListener(this);
		
		// Reliability Spinner
		spnReliability = (Spinner)findViewById(R.id.spnReliability);
		spnReliability.setOnItemSelectedListener(this);
		
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
			
			/*Toast.makeText(context,
					"Selected Items : " + 
					"\nExecution Price: " + String.valueOf(spnExecutionPrice.getSelectedItem()) +
					"\nReliability: " + String.valueOf(spnReliability.getSelectedItem()) +
					"\nResponse Time: " + String.valueOf(spnResponseTime.getSelectedItem()),
					Toast.LENGTH_SHORT).show();*/
			
			AppManager.getInstance().setSelectedExecutionPrice(String.valueOf(spnExecutionPrice.getSelectedItem()));
			AppManager.getInstance().setSelectedResponseTime(String.valueOf(spnResponseTime.getSelectedItem()));
			AppManager.getInstance().setSelectedReliability(String.valueOf(spnReliability.getSelectedItem()));
			
			Intent intent = new Intent(context, TaskExecutionRuleActivity.class);
			intent.putExtra(AppManager.IS_CONFIGURING, getIntent().getBooleanExtra(AppManager.IS_CONFIGURING, false));
			intent.putExtra(AppManager.SELECTED_TASK_ID, getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1));
			startActivity(intent);
			
			/**
			 * Add task to workflow
			 */
			
			/*
			int selectedTaskId = getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1);
			
			TaskDataModel tempTask = AllSelectedTasks.getSelectedTaskByIdAndRemove(selectedTaskId);
			
			TaskConfiguration taskConfiguration = new TaskConfiguration();
			taskConfiguration.setTaskId(tempTask.getId());
			
			taskConfiguration.setInputs(AppManager.getInstance().getInputIds());
			taskConfiguration.setQos(AppManager.getInstance().getQos());
			taskConfiguration.setOutputs(AppManager.getInstance().getOutputs());
			
			// Add task to Workflow and save Workflow task specifications to JSON file.
			AllTaskConfiguration.addConfiguredTasks(taskConfiguration);
			addTaskToWorkflow();
						
			Intent intent = new Intent(context, SelectedTasksActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);*/
			
			return true;
		}
		return super.onOptionsItemSelected(item);
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

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
		// On selecting a spinner item
		//String item = parent.getItemAtPosition(position).toString();
				
		// Showing selected spinner item
		//Toast.makeText(parent.getContext(), "Selected Execution Price: " + item, Toast.LENGTH_LONG).show();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
