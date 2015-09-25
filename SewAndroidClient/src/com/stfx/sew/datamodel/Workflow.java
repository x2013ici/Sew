/**
 * 
 */
package com.stfx.sew.datamodel;

import java.util.ArrayList;

import com.google.gson.Gson;

/**
 * @author Mostafijur Rahman
 *
 */
public class Workflow {

	private String workflowName;
	private ArrayList<ConfiguredTask> taskList;

	public ArrayList<ConfiguredTask> getTaskList() {
		return taskList;
	}

	public void setTaskList(ArrayList<ConfiguredTask> taskList) {
		this.taskList = taskList;
	}
	
	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public void addTask(ConfiguredTask task){
		if(taskList == null){
			taskList = new ArrayList<ConfiguredTask>();
		}
		
		taskList.add(task);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
