/**
 * 
 */
package com.stfx.sew.dataholders;

import java.util.ArrayList;

import com.stfx.sew.datamodel.TaskConfiguration;

/**
 * @author Mostafijur Rahman
 *
 */
public class AllTaskConfiguration {

	private static ArrayList<TaskConfiguration> configuredTasksList = new ArrayList<TaskConfiguration>();
	
	public static void removeAll(){
		configuredTasksList.clear();
	}
	
	public static void addConfiguredTasks(TaskConfiguration configuredTasks){
		if(configuredTasksList == null){
			configuredTasksList = new ArrayList<TaskConfiguration>();
		}
		
		configuredTasksList.add(configuredTasks);
	}
	
	public static void addAllConfiguredTasks(ArrayList<TaskConfiguration> configuredTasksList){
		AllTaskConfiguration.configuredTasksList = configuredTasksList;
	}
	
	public static ArrayList<TaskConfiguration> getAllConfiguredTasksList(){
		return configuredTasksList;
	}
}
