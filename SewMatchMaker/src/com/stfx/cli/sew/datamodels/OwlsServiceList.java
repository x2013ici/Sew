package com.stfx.cli.sew.datamodels;

import java.util.ArrayList;

/**
 * 
 * @author Mostafijur Rahman
 * @since 21th March, 2015
 */
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
