/**
 * 
 */
package com.stfx.sew.datamodel;

/**
 * @author Mostafijur Rahman
 *
 */
public class WorkflowDataModel {

	private int id;
	private String workflowName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	
	@Override
	public String toString() {
		return this.workflowName;
	}
	
}
