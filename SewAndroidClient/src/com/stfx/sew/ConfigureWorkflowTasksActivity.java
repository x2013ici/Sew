package com.stfx.sew;

import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.stfx.sew.dataholders.AllConfigurableWorkflow;
import com.stfx.sew.dataholders.AllSelectedTasks;
import com.stfx.sew.dataholders.AllTaskConfiguration;
import com.stfx.sew.dataholders.AllTasks;
import com.stfx.sew.datamodel.NovaTargetTask;
import com.stfx.sew.datamodel.NovaTask;
import com.stfx.sew.datamodel.TaskDataModel;
import com.stfx.sew.datamodel.WorkflowDataModel;
import com.stfx.sew.manager.AppManager;
import com.stfx.sew.parsers.WorkflowModelParser;
import com.stfx.sew.util.SharedPreferenceHelper;

/**
 * 
 * @author Mostafijur Rahman
 * @since 2th May, 2015
 */
public class ConfigureWorkflowTasksActivity extends Activity {

	Context context;
	ListView lstTaskList;
	Spinner spnSelectWorkflow;
	TextView txtEmptyList;
	
	ArrayList<WorkflowDataModel> workflowList;
	ArrayList<TaskDataModel> tasksList;
	
	ArrayAdapter<TaskDataModel> listAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configure_workflow_tasks);
		context = this;
		
		try{
			
			// Populate Work-flow and Associated Task Details
			//loadHospicePalliativeCareSequencialTaskList();
			
			loadHospicePalliativeCareOverallTaskList();
			
			// Bind Work-flow Details to UI
			bindHospicePalliativeCareTaskListToUI();
		}
		catch(Exception ex){
			
		}
		
		spnSelectWorkflow = (Spinner) findViewById(R.id.spnSelectWorkflow);
		lstTaskList = (ListView)findViewById(R.id.lstSelectTasks);
		//txtEmptyList = (TextView)findViewById(R.id.txtEmptyList);
		
		workflowList = AllConfigurableWorkflow.getAllWorkflows();
		WorkflowDataModel workfow = new WorkflowDataModel();
		workfow.setId(-1);
		workfow.setWorkflowName("Select a Workflow");
		workflowList.add(0, workfow);
		tasksList = new ArrayList<TaskDataModel>();
		
		ArrayAdapter<WorkflowDataModel> spinnerAdapter = new ArrayAdapter<WorkflowDataModel>(context, android.R.layout.simple_spinner_dropdown_item, workflowList);
		spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnSelectWorkflow.setAdapter(spinnerAdapter);
		
		listAdapter = new ArrayAdapter<TaskDataModel>(context, android.R.layout.simple_list_item_checked, tasksList);
		lstTaskList.setAdapter(listAdapter);
		lstTaskList.setEmptyView(txtEmptyList);
		
		spnSelectWorkflow.setOnItemSelectedListener(workfowSelectListener);
		
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
	
	private void loadHospicePalliativeCareOverallTaskList(){
		
		//int startingTaskIndex = 0;
		//boolean isFinished = false;
		
		//NovaTask novaTask = null;
		//NovaTargetTask novaTargetTask = null;
		//ArrayList<NovaTargetTask> novaTargetTaskList = null;
		
		try{
			if(AppManager.hpcOverallNovaTaskList.size() >0){
				
				for(NovaTask novaTask : AppManager.hpcOverallNovaTaskList){
					if(novaTask.getTaskType().equals(WorkflowModelParser.TaskType_UncompensableTask)
							|| (novaTask.getTaskType().equals(WorkflowModelParser.TaskType_CompensableTask))){
						AppManager.hpcOverallWorkflowTaskExecutionList.put(novaTask.getId(), novaTask);
					}
				}
				
				for(Map.Entry<Integer, NovaTask> entry : AppManager.hpcOverallWorkflowTaskExecutionList.entrySet()){
					Log.i(AppManager.TAG,"Task Id: " + entry.getKey() + " Task Name:" + entry.getValue().getName());
				}
				
				/*novaTask = AppManager.hpcOverallNovaTaskList.get(startingTaskIndex);
				while(true){
					
					if(novaTask !=null){
						
						String taskType = novaTask.getTaskType();
						if(taskType.equals(WorkflowModelParser.TaskType_InputCondition)){
							
							novaTargetTask = novaTask.getTargetTask(); 
							if(novaTargetTask !=null){
								novaTask = getTargetTaskById(novaTargetTask.getTaskId());
								
								if(novaTask != null){
									
									if(novaTask.getTaskType().equals(WorkflowModelParser.TaskType_UncompensableTask)){
										AppManager.hpcOverallWorkflowTaskExecutionList.put(novaTask.getId(), novaTask);
									}
									
									if(novaTask.getTargetTask() !=null){
										continue;
									}
									else{
										break;
									}
								}
							}
						}
						
						else if(taskType.equals(WorkflowModelParser.TaskType_UncompensableTask)
								|| (taskType.equals(WorkflowModelParser.TaskType_CompensableTask))){
							
							AppManager.hpcOverallWorkflowTaskExecutionList.put(novaTask.getId(), novaTask);
							
							novaTargetTask = novaTask.getTargetTask();
							
							if(novaTargetTask !=null){
								novaTask = getTargetTaskById(novaTargetTask.getTaskId());
								if(novaTask != null && novaTask.getTargetTask() !=null){
									continue;
								}
							}
							else{
								break;
							}
							
						}
						
						else if(taskType.equals(WorkflowModelParser.TaskType_XorSplitTask)){
							
							novaTargetTaskList = novaTask.getTargetTaskList();
							for(NovaTargetTask novaTarTask : novaTargetTaskList){
								
								novaTask = getTargetTaskById(novaTarTask.getTaskId());
								if(novaTask !=null){
									if(novaTask.getTaskType().equals(WorkflowModelParser.TaskType_UncompensableTask)){
										AppManager.hpcOverallWorkflowTaskExecutionList.put(novaTask.getId(), novaTask);
									}
									else if(novaTask.getTaskType().equals(WorkflowModelParser.TaskType_XorJoinTask)){
										break;
									}
								}
								
								while(true){
									if(novaTask.getTargetTask() !=null){
										novaTask = getTargetTaskById(novaTask.getTargetTask().getTaskId());
										if(novaTask !=null){
											if(novaTask.getTaskType().equals(WorkflowModelParser.TaskType_UncompensableTask)){
												AppManager.hpcOverallWorkflowTaskExecutionList.put(novaTask.getId(), novaTask);
											}
											else if(novaTask.getTaskType().equals(WorkflowModelParser.TaskType_XorJoinTask)){
												break;
											}
										}
									}
								}
							}
						}
						
						else if(taskType.equals(WorkflowModelParser.TaskType_XorJoinTask)){
							
							novaTargetTask = novaTask.getTargetTask(); 
							if(novaTargetTask !=null){
								novaTask = getTargetTaskById(novaTargetTask.getTaskId());
								
								if(novaTask != null && novaTask.getTargetTask() !=null){
									continue;
								}
							}
						}
						
						else if(taskType.equals(WorkflowModelParser.TaskType_OutputCondition)){
							
							novaTargetTask = novaTask.getTargetTask(); 
							if(novaTargetTask ==null){
								break;
							}
							
						}
					}
				}
				
				// Print Work-flow Execution List
				for(Map.Entry<Integer, NovaTask> entry : AppManager.hpcOverallWorkflowTaskExecutionList.entrySet()){
					Log.i(AppManager.TAG,"Task Id: " + entry.getKey() + " Task Name:" + entry.getValue().getName());
				}*/
			}
		}
		catch(Exception ex){
			
		}
	}
	
	
	private void bindHospicePalliativeCareTaskListToUI(){
		
		NovaTask novaTask = null;
		TaskDataModel taskDataModel  = null;
		try{
			
			// Hospice Palliative Care Sequential Work-flow
			AllConfigurableWorkflow.removeAll();
			AllTasks.removeAll();
			
			// Hospice Palliative Care Overall Work-flow
			WorkflowDataModel workflowDataModel = new WorkflowDataModel();
			workflowDataModel.setId(AppManager.HOSPICE_PALLIATIVE_CARE_OVERLL_WORKFLOW_ID);
			workflowDataModel.setWorkflowName(AppManager.HOSPICE_PALLIATIVE_CARE_OVERALL_WORKFLOW_NAME);
			AllConfigurableWorkflow.addWorkflow(workflowDataModel);
						
			//AllTasks.removeAll();
			if(AppManager.hpcOverallWorkflowTaskExecutionList.size()>0){
							
				for(Map.Entry<Integer, NovaTask> entry : AppManager.hpcOverallWorkflowTaskExecutionList.entrySet()){
								
					novaTask = entry.getValue();
					if(novaTask !=null){
						taskDataModel = new TaskDataModel();
						taskDataModel.setId(novaTask.getId());
						taskDataModel.setWorkflowId(AppManager.HOSPICE_PALLIATIVE_CARE_OVERLL_WORKFLOW_ID);
						taskDataModel.setTaskName(novaTask.getName());
						AllTasks.addTask(taskDataModel);
					}
				}
			}
			
			/*WorkflowDataModel workflowDataModel = new WorkflowDataModel();
			workflowDataModel.setId(AppManager.HOSPICE_PALLIATIVE_CARE_SEQUENCIAL_WORKFLOW_ID);
			workflowDataModel.setWorkflowName(AppManager.HOSPICE_PALLIATIVE_CARE_SEQUENCIAL_WORKFLOW_NAME);
			AllConfigurableWorkflow.addWorkflow(workflowDataModel);*/
			
			// Add Tasks to this Work-flow by parsing its XML data model 
			
			
			/*if(AppManager.hpcSequencialWorkflowTaskExecutionList.size()>0){
				
				for(Map.Entry<Integer, NovaTask> entry : AppManager.hpcSequencialWorkflowTaskExecutionList.entrySet()){
					
					novaTask = entry.getValue();
					if(novaTask !=null){
						taskDataModel = new TaskDataModel();
						taskDataModel.setId(novaTask.getId());
						taskDataModel.setWorkflowId(AppManager.HOSPICE_PALLIATIVE_CARE_SEQUENCIAL_WORKFLOW_ID);
						taskDataModel.setTaskName(novaTask.getName());
						AllTasks.addTask(taskDataModel);
					}
				}
			}*/
		}
		catch(Exception ex){
			
		}
	}

	private OnItemSelectedListener workfowSelectListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			
			if(position == 0){
				tasksList = new ArrayList<TaskDataModel>();
			}
			else{
				int workfowId = workflowList.get(position).getId();
				tasksList = AllTasks.getAllTasksByWorkflowId(workfowId);
			}
			/*listAdapter.notifyDataSetChanged();
			lstTaskList.invalidate();*/
			
			listAdapter = new ArrayAdapter<TaskDataModel>(context, android.R.layout.simple_list_item_checked, tasksList);
			lstTaskList.setAdapter(listAdapter);
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
	};
	
	public void configureTask(View v){
		
		int totalTask = 0;
		String taskName = null;
		boolean isAnyTaskChecked = false;
		try{
			
			AllTaskConfiguration.removeAll();
			AllSelectedTasks.removeAll();
			
			totalTask = lstTaskList.getCount();
			SparseBooleanArray checkeds = lstTaskList.getCheckedItemPositions();
			
			for(int i = 0; i<totalTask; i++){
				if(checkeds.get(i)){
					isAnyTaskChecked = true;
					TaskDataModel taskDataModel = tasksList.get(i);
					AllSelectedTasks.addSelectedTask(taskDataModel);
					taskName = taskName + taskDataModel.getTaskName() + " ";
				}
			}
			
			if(isAnyTaskChecked){
				SharedPreferenceHelper.setSelectedWowrkflow(context, workflowList.get(spnSelectWorkflow.getSelectedItemPosition()).getWorkflowName());
				Intent intent = new Intent(context, SelectedTasksActivity.class);
				startActivity(intent);
			}
			else{
				Toast.makeText(context, "Please Select Tasks to Configure", Toast.LENGTH_SHORT).show();
			}
			
		}
		catch(Exception ex){
			
		}
		
	}
	
	private static NovaTask getTargetTaskById(int taskId){
		
		NovaTask novaTask = null;
		try{
			if(AppManager.hpcOverallWorkflowTaskList.size() >0){
				novaTask = AppManager.hpcOverallWorkflowTaskList.get(taskId);
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
	}
	
	/**
	 * Display Task List as per the control flow of the Workflows
	 */
	/*private void loadHospicePalliativeCareSequencialTaskList(){
		
		//int startingTaskIndex = 0;
		//boolean isFinished = false;
		
		//NovaTask novaTask = null;
		//NovaTargetTask novaTargetTask = null;
		
		try{
			
			if(AppManager.hpcSequencialNovaTaskList.size() >0){
				
				
				for(NovaTask novaTask : AppManager.hpcSequencialNovaTaskList){
					if(novaTask.getTaskType().equals(WorkflowModelParser.TaskType_UncompensableTask)
							|| (novaTask.getTaskType().equals(WorkflowModelParser.TaskType_CompensableTask))){
						
						AppManager.hpcSequencialWorkflowTaskExecutionList.put(novaTask.getId(), novaTask);
					}
				}
				
				for(Map.Entry<Integer, NovaTask> entry : AppManager.hpcSequencialWorkflowTaskExecutionList.entrySet()){
					Log.i(AppManager.TAG,"Task Id: " + entry.getKey() + " Task Name:" + entry.getValue().getName());
				}
				
				novaTask = AppManager.hpcSequencialNovaTaskList.get(startingTaskIndex);
				
				*//**
				 * Sorting Work-flow execution list
				 * Display only UncompensableTask type of tasks to the configurable list
				 *//*
				while(true){
					
					if(novaTask !=null){
						
						novaTargetTask = novaTask.getTargetTask(); 
						if(novaTargetTask !=null){
							
							if(novaTask.getTaskType().equals(WorkflowModelParser.TaskType_UncompensableTask)){
								AppManager.hpcSequencialWorkflowTaskExecutionList.put(novaTask.getId(), novaTask);
							}
							
							novaTask = getTargetTaskById(novaTargetTask.getTaskId());
							if(novaTask != null && novaTask.getTargetTask() !=null){
								continue;
								//AppManager.workflowTaskExecutionList.put(novaTask.getId(), novaTask);
							}
							else if(novaTask != null && novaTask.getTargetTask() == null){
								
								if(novaTask.getTaskType().equals(WorkflowModelParser.TaskType_UncompensableTask)){
									AppManager.hpcSequencialWorkflowTaskExecutionList.put(novaTask.getId(), novaTask);
								}
								
								//AppManager.hpcSequencialWorkflowTaskExecutionList.put(novaTask.getId(), novaTask);
								isFinished = true;
							}
						}
						else {
							
							if(novaTask.getTaskType().equals(WorkflowModelParser.TaskType_UncompensableTask)){
								AppManager.hpcSequencialWorkflowTaskExecutionList.put(novaTask.getId(), novaTask);
							}
							
							//AppManager.hpcSequencialWorkflowTaskExecutionList.put(novaTask.getId(), novaTask);
							isFinished = true;
						}
					}
					if(isFinished)
						break;
				}
				
				// Print Work-flow Execution List
				for(Map.Entry<Integer, NovaTask> entry : AppManager.hpcSequencialWorkflowTaskExecutionList.entrySet()){
					Log.i(AppManager.TAG,"Task Id: " + entry.getKey() + " Task Name:" + entry.getValue().getName());
				}
			}
		}
		catch(Exception ex){
			
		}
	}*/

}
