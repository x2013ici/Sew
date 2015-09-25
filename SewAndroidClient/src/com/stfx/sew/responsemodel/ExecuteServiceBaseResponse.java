package com.stfx.sew.responsemodel;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExecuteServiceBaseResponse implements Serializable{

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
}
