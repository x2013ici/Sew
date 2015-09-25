package com.stfx.sew.datamodel;

public class NovaTargetTask {

	
	public NovaTargetTask(){
		
	}
	
	private int taskId;
	public int getTaskId(){
		return this.taskId;
	}
	public void setTaskId(int taskId){
		this.taskId = taskId;
	}
	
	private String taskName;
	public String getTaskName(){
		return this.taskName;
	}
	public void setTaskName(String taskName){
		this.taskName = taskName;
	}
	
	private int branchOrderId;
	public int getBranchOrderId(){
		return branchOrderId;
	}
	public void setBranchOrderId(int branchOrderId){
		this.branchOrderId = branchOrderId;
	}
}
