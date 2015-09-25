/**
 * 
 */
package com.stfx.sew.datamodel;

import com.stfx.sew.dataholders.AllTasks;

/**
 * @author Mostafijur Rahman
 *
 */
public class TaskConfiguration {

	private int taskId;
	private int selectedCondition;
	private int selectedSymptom;
	
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	private int[] inputs;
	public int[] getInputs(){
		return inputs;
	}
	public void setInputs(int[] inputs){
		this.inputs = inputs;
	}
	
	private int[] outputs;
	public int[] getOutputs() {
		return outputs;
	}
	public void setOutputs(int[] outputs) {
		this.outputs = outputs;
	}
	
	private int[] qos;
	public int[] getQos() {
		return qos;
	}
	public void setQos(int[] qos) {
		this.qos = qos;
	}
	
	private int[] taskExecutionRules;
	public int[] getTaskExecutionRules(){
		return taskExecutionRules;
	}
	public void setTaskExecutionRules(int[] taskExecutionRules){
		this.taskExecutionRules = taskExecutionRules;
	}
	
	@Override
	public String toString() {
		return AllTasks.getTaskById(this.taskId).getTaskName();
	}
	
	// Unused properties
	public int getSelectedCondition() {
		return selectedCondition;
	}
	public void setSelectedCondition(int selectedCondition) {
		this.selectedCondition = selectedCondition;
	}
	public int getSelectedSymptom() {
		return selectedSymptom;
	}
	public void setSelectedSymptom(int selectedSymptom) {
		this.selectedSymptom = selectedSymptom;
	}
}
