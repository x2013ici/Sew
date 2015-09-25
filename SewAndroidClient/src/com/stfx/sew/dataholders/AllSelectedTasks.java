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
public class AllSelectedTasks {

	private static ArrayList<TaskDataModel> allSelectedTasks = new ArrayList<TaskDataModel>();
	
	public static void removeAll(){
		allSelectedTasks.clear();
	}
	
	public static void addSelectedTask(TaskDataModel task){
		if(allSelectedTasks == null){
			allSelectedTasks = new ArrayList<TaskDataModel>();
		}
		
		allSelectedTasks.add(task);
	}
	
	public static void addSelectedTaskTop(TaskDataModel task){
		if(allSelectedTasks == null){
			allSelectedTasks = new ArrayList<TaskDataModel>();
		}
		allSelectedTasks.add(0, task);
	}

	public static ArrayList<TaskDataModel> getAllSelectedTasks() {
		return allSelectedTasks;
	}

	public static void setAllSelectedTasks(ArrayList<TaskDataModel> allSelectedTasks) {
		removeAll();
		AllSelectedTasks.allSelectedTasks = allSelectedTasks;
	}
	
	public static TaskDataModel getTopSelectedTasks(){
		if(allSelectedTasks == null){
			return null;
		}
		if(allSelectedTasks.size() == 0){
			return null;
		}
		return allSelectedTasks.remove(0);
	}
	
	public static TaskDataModel getSelectedTaskByPos(int position){
		if(allSelectedTasks == null){
			return null;
		}
		if(allSelectedTasks.size() <= position){
			return null;
		}
		
		return allSelectedTasks.get(position);
	}
	
	public static TaskDataModel getSelectedTaskById(int id){
		if(allSelectedTasks == null){
			return null;
		}
		for (TaskDataModel tasksDM : allSelectedTasks) {
			if(tasksDM.getId() == id){
				return tasksDM;
			}
		}
		
		return null;
	}
	
	public static TaskDataModel getSelectedTaskByIdAndRemove(int id){
		if(allSelectedTasks == null){
			return null;
		}
		for (TaskDataModel tasksDM : allSelectedTasks) {
			if(tasksDM.getId() == id){
				allSelectedTasks.remove(tasksDM);
				return tasksDM;
			}
		}
		
		return null;
	}
}
