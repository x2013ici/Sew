package com.stfx.cli.sew.datamodels;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ServiceResponse implements Serializable{

	private boolean isResult=false;
	private boolean isOperationSuccessfull=false;
	//private Service service=null;
	private InputModel inputModel=null;
	private ArrayList<Service> serviceList = new ArrayList<Service>();
	
	public boolean getIsResult(){
		return this.isResult;
	}
	public void setIsResult(boolean isResult){
		this.isResult = isResult;
	}
	
	public boolean getIsOperationSuccessfull(){
		return this.isOperationSuccessfull;
	}
	public void setIsOperationSuccessfull(boolean isOperationSuccessfull){
		this.isOperationSuccessfull = isOperationSuccessfull;
	}
	
	/*public Service getService(){
		return this.service;
	}
	public void setService(Service service){
		this.service = service;
	}*/
	
	public InputModel getInputModel(){
		return this.inputModel;
	}
	public void setInputModel(InputModel inputModel){
		this.inputModel = inputModel;
	}
	
	public ArrayList<Service> getServiceList(){
		return this.serviceList;
	}
	public void setSerivceList(ArrayList<Service> serviceList){
		this.serviceList = serviceList;
	}
	
	
}
