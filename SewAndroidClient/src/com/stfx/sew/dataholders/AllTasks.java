/**
 * 
 */
package com.stfx.sew.dataholders;

import java.util.ArrayList;

import com.stfx.sew.datamodel.TaskDataModel;

/**
 * @author Mostafijur Rahman
 *
 */
public class AllTasks {

	private static ArrayList<TaskDataModel> allTasks = new ArrayList<TaskDataModel>();
	
	public static void removeAll(){
		allTasks.clear();
	}
	
	public static void addTask(TaskDataModel task){
		if(allTasks == null){
			allTasks = new ArrayList<TaskDataModel>();
		}
		
		allTasks.add(task);
	}
	
	public static void allAllTask(ArrayList<TaskDataModel> allTask){
		removeAll();
		allTasks = allTask;
	}
	
	public static TaskDataModel getTaskByPosition(int position){
		if(allTasks == null){
			return null;
		}
		
		if(allTasks.size() >= position){
			return null;
		}
		
		return allTasks.get(position);
	}
	
	public static TaskDataModel getTaskById(int id){
		if(allTasks == null){
			return null;
		}
		
		for (TaskDataModel tasksDM : allTasks) {
			if(tasksDM.getId() == id){
				return tasksDM;
			}
		}
		
		return null;
	}
	
	public static ArrayList<TaskDataModel> getAllTasks(){
		return allTasks;
	}
	
	public static ArrayList<TaskDataModel> getAllTasksByWorkflowId(int workflowId){
		if(allTasks == null){
			return null;
		}
		
		ArrayList<TaskDataModel> tasks = new ArrayList<TaskDataModel>();
		for (TaskDataModel tasksDM : allTasks) {
			if(tasksDM.getWorkflowId() == workflowId){
				tasks.add(tasksDM);
			}
		}
		
		return tasks;
	}
}
