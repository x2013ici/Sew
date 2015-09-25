package com.stfx.sew.datamodel;

public class NovaBranchOrder {
	
	private int branchOrderId;
	public int getBranchOrderId(){
		return this.branchOrderId;
	}
	public void setBranchOrderId(int branchOrderId){
		this.branchOrderId = branchOrderId;
	}
	
	private int sourceTaskId;
	public int getSourceTaskId(){
		return this.sourceTaskId;
	}
	public void setSourceTaskId(int sourceTaskId){
		this.sourceTaskId = sourceTaskId;
	}
}
