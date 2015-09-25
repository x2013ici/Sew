/**
 * 
 */
package com.stfx.sew.datamodel;

/**
 * @author Mostafijur Rahman
 *
 */
public class TaskDataModel extends NovaTask{

	private int id;
	private String taskName;
	private int workflowId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.taskName;
	}
	
}
