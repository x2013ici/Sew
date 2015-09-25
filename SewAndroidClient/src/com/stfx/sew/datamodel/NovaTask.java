package com.stfx.sew.datamodel;

import java.util.ArrayList;

public class NovaTask {
	
	/**
	 * @author Mostafijur Rahman
	 */
	
	public NovaTask(){
		
	}
	
	private int taskId;
	public int getId(){
		return this.taskId;
	}
	public void setId(int taskId){
		this.taskId = taskId;
	}
	
	private String taskName;
	public String getName(){
		return this.taskName;
	}
	public void setTaskName(String taskName){
		this.taskName = taskName;
	}
	
	private String taskType;
	public String getTaskType(){
		return this.taskType;
	}
	public void setTaskType(String taskType){
		this.taskType = taskType;
	}
	
	private NovaTargetTask novaTargetTask;
	public NovaTargetTask getTargetTask(){
		return this.novaTargetTask;
	}
	public void setTargetTask(NovaTargetTask novaTargetTask){
		this.novaTargetTask = novaTargetTask;
	}
	
	private ArrayList<NovaTargetTask> novaTargetTaskList;
	public ArrayList<NovaTargetTask> getTargetTaskList(){
		return novaTargetTaskList;
	}
	public void setTargetTaskList(ArrayList<NovaTargetTask> novaTargetTaskList){
		this.novaTargetTaskList = novaTargetTaskList;
	}
	
	private NovaBranchOrder novaBranchOrder;
	public NovaBranchOrder getNovaBranchOrder(){
		return this.novaBranchOrder;
	}
	public void setNovaBranchOrder(NovaBranchOrder novaBranchOrder){
		this.novaBranchOrder = novaBranchOrder;
	}
	
	private NovaCorrespondingTask novaCorrespondingTask;
	public NovaCorrespondingTask getCorrespondingTask(){
		return novaCorrespondingTask;
	}
	
	public void setCorrespondingTask(NovaCorrespondingTask novaCorrespondingTask){
		this.novaCorrespondingTask = novaCorrespondingTask;
	}
}
