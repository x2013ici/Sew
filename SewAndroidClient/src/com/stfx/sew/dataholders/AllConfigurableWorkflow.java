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
public class AllConfigurableWorkflow {

	private static ArrayList<WorkflowDataModel> allWorkflows = new ArrayList<WorkflowDataModel>();
	
	public static void removeAll(){
		allWorkflows.clear();
	}
	
	public static void addWorkflow(WorkflowDataModel workflow){
		if(allWorkflows == null){
			allWorkflows = new ArrayList<WorkflowDataModel>();
		}
		
		allWorkflows.add(workflow);
	}
	
	public static void addAllWOrkflow(ArrayList<WorkflowDataModel> allWorflow){
		removeAll();
		allWorkflows = allWorflow;
	}
	
	public static WorkflowDataModel getWorkflowByPosition(int position){
		if(allWorkflows == null){
			return null;
		}
		
		if(allWorkflows.size() >= position){
			return null;
		}
		
		return allWorkflows.get(position);
	}
	
	public static WorkflowDataModel getWorkflowById(int id){
		if(allWorkflows == null){
			return null;
		}
		
		for(int i = 0; i<allWorkflows.size(); i++){
			if(allWorkflows.get(i).getId() == id){
				return allWorkflows.get(i);
			}
		}
		
		return null;
	}
	
	public static ArrayList<WorkflowDataModel> getAllWorkflows(){
		return allWorkflows;
	}
}
