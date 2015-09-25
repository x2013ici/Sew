package com.stfx.cli.sew.datamodels;

import java.io.Serializable;

import com.stfx.cli.sew.services.OutputModel;

@SuppressWarnings("serial")
public class ServiceExecutionResponse implements Serializable{

	private boolean isResult=false;
	
	
	public boolean getIsResult(){
		return this.isResult;
	}
	public void setIsResult(boolean isResult){
		this.isResult = isResult;
	}
	
	private boolean isOperationSuccessfull=false;
	public boolean getIsOperationSuccessfull(){
		return this.isOperationSuccessfull;
	}
	public void setIsOperationSuccessfull(boolean isOperationSuccessfull){
		this.isOperationSuccessfull = isOperationSuccessfull;
	}
	
	private String message = null;
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	
	private OutputModel outputModel = null;
	public OutputModel getOutputModel(){
		return this.outputModel;
	}
	
	public void setOutputModel(OutputModel outputModel){
		this.outputModel = outputModel;
	}
}
