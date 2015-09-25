package com.stfx.sew.responsemodel;

import java.util.ArrayList;

public class OwlsServiceList {
	
	private int isOperationSuccessfull;
	public int getIsOperationSuccessfull(){
		return this.isOperationSuccessfull;
	}
	public void setIsOperationSuccessfull(int isOperationSuccessfull){
		this.isOperationSuccessfull = isOperationSuccessfull;
	}
	
	private int isResult;
	public int getIsResult(){
		return isResult;
	}
	public void setIsResult(int isResult){
		this.isResult = isResult;
	}
	
	private ArrayList<OwlsService> owlsServiceList;
	public ArrayList<OwlsService> getOwlsServiceList(){
		return this.owlsServiceList;
	}
	public void setOwlsServiceList(ArrayList<OwlsService> owlsServiceList){
		this.owlsServiceList = owlsServiceList;
	}

}
