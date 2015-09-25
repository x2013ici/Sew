/**
 * 
 */
package com.stfx.sew.dataholders;

import java.util.ArrayList;

import com.stfx.sew.datamodel.WorkflowDataModel;

/**
 * @author Mostafijur Rahman
 *
 */
public class AllWorkflows {

	private static ArrayList<WorkflowDataModel> allWorkflow = new ArrayList<WorkflowDataModel>();
	
	public static void removeAll(){
		if(allWorkflow != null){
			allWorkflow.clear();
		}
	}
	
	public static void addWorkflow(WorkflowDataModel workflow){
		if(allWorkflow == null){
			allWorkflow = new ArrayList<WorkflowDataModel>();
		}
		
		allWorkflow.add(workflow);
	}
	
	public static void addAllWorkflow(ArrayList<WorkflowDataModel> workflowList){
		removeAll();
		allWorkflow = workflowList;
	}
	
	public static WorkflowDataModel getWorkflowByPositon(int position){
		if(allWorkflow == null){
			return null;
		}
		
		if(allWorkflow.size() >= position){
			return null;
		}
		
		return allWorkflow.get(position);
	}
	
	public static WorkflowDataModel getWorkflowById(int id){
		if(allWorkflow == null){
			return null;
		}
		
		for (WorkflowDataModel workflowDM : allWorkflow) {
			if(workflowDM.getId() == id){
				return workflowDM;
			}
		}
		
		return null;
	}
	
	public static ArrayList<WorkflowDataModel> getAllWorkflow(){
		return allWorkflow;
	}
	
}
