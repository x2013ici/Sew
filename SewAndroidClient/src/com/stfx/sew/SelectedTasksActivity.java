package com.stfx.sew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.stfx.sew.dataholders.AllSelectedTasks;
import com.stfx.sew.dataholders.AllTaskConfiguration;
import com.stfx.sew.datamodel.TaskConfiguration;
import com.stfx.sew.datamodel.TaskDataModel;
import com.stfx.sew.manager.AppManager;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd May, 2015
 */
public class SelectedTasksActivity extends Activity {

	Context context;
	TextView txtConfigureListEmpty;
	ListView lstConfiguredTasksList;
	TextView txtTobeConfiguredEmpty;
	ListView lstTobeConfigurTasksList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selected_tasks);
		context = this;
		
		txtConfigureListEmpty = (TextView)findViewById(R.id.txtConfigureListEmpty);
		txtTobeConfiguredEmpty = (TextView)findViewById(R.id.txtTobeConfiguredEmpty);
		lstConfiguredTasksList = (ListView)findViewById(R.id.lstConfiguredTasksList);
		lstTobeConfigurTasksList = (ListView)findViewById(R.id.lstTobeConfigurTasksList);
		
		ArrayAdapter<TaskDataModel> tobeConfiguredAdapter = new ArrayAdapter<TaskDataModel>(context, android.R.layout.simple_list_item_single_choice, AllSelectedTasks.getAllSelectedTasks());
		lstTobeConfigurTasksList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstTobeConfigurTasksList.setAdapter(tobeConfiguredAdapter);
		lstTobeConfigurTasksList.setEmptyView(txtTobeConfiguredEmpty);
		
		ArrayAdapter<TaskConfiguration> configuredAdapter = new ArrayAdapter<TaskConfiguration>(context, android.R.layout.simple_list_item_1, AllTaskConfiguration.getAllConfiguredTasksList());
		lstConfiguredTasksList.setAdapter(configuredAdapter);
		lstConfiguredTasksList.setEmptyView(txtConfigureListEmpty);
		
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
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		((BaseAdapter)lstTobeConfigurTasksList.getAdapter()).notifyDataSetChanged();
		lstTobeConfigurTasksList.invalidate();
		((BaseAdapter)lstConfiguredTasksList.getAdapter()).notifyDataSetChanged();
		lstConfiguredTasksList.invalidate();
		
		
		if((AllSelectedTasks.getAllSelectedTasks() != null && AllSelectedTasks.getAllSelectedTasks().size() == 0) && (AllTaskConfiguration.getAllConfiguredTasksList() != null && AllTaskConfiguration.getAllConfiguredTasksList().size() > 0)){
			Intent intent = new Intent(context, WorkflowSelectActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
		
	}

	public void configureTasks(View v){
		
		
		if(AllSelectedTasks.getAllSelectedTasks() != null && AllSelectedTasks.getAllSelectedTasks().size() > 0){
			int selectedTaskPos = lstTobeConfigurTasksList.getCheckedItemPosition();//.getSelectedItemPosition();
			if(selectedTaskPos >= 0){
				TaskDataModel selectedTask = AllSelectedTasks.getSelectedTaskByPos(selectedTaskPos);
				
				//Intent intent = new Intent(context, ChooseInputConceptActivity.class);
				Intent intent = new Intent(context, InputConceptActivity.class);
				
				intent.putExtra(AppManager.IS_CONFIGURING, true);
				intent.putExtra(AppManager.SELECTED_TASK_ID, selectedTask.getId());
				startActivity(intent);
			}
			else{
				Toast.makeText(context, "Please Select a Task", Toast.LENGTH_SHORT).show();
			}
		}
		else{
			Toast.makeText(context, "No tasks left to be cinfigured...", Toast.LENGTH_SHORT).show();
		}
		
		/*if(AllSelectedTasks.getAllSelectedTasks().size() == 0 && AllTaskConfiguration.getAllConfiguredTasksList().size() > 0){
			if(AppManager.getInstance().getWorkflow() != null){
				try{
					Workflow workflow = AppManager.getInstance().getWorkflow();
					XStream xStream = new XStream(new DomDriver());
					xStream.alias("workflow1", Workflow.class);
					xStream.alias("Task", Task.class);
					xStream.alias("outputs", OutputsIn.class);
					xStream.alias("inputconcept", InputConcepts.class);
//					xStream.addImplicitCollection(String.class, "String");
//					xStream.alias("outputconcept", OutputConcepts.class);
					xStream.addImplicitCollection(Workflow.class, "Task");
					xStream.addImplicitCollection(OutputsIn.class, "outputconcept");
					xStream.addImplicitCollection(Inputs.class, "inputconcept");
					
					xStream.addImplicitArray(OutputsIn.class, "outputconcept", "outputconcept");
//					xStream.addImplicitArray(Inputs.class, "inputconcept", "inputconcept");
					xStream.addImplicitMap(Inputs.class, "inputconcept", "inputconcept", String.class, "inputconcept");
					
					String xmlValue = xStream.toXML(workflow);
					Log.i("XML_VALUE", xmlValue);
					
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}*/
	}
	
}
