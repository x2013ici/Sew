package com.stfx.cli.sew.datamodels;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InputModelResponse implements Serializable{
	
	private boolean isResult;
	private boolean isOperationSuccessfull;
	private InputModel inputModel;
	
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
	
	public InputModel getInputModel(){
		return this.inputModel;
	}
	public void setInputModel(InputModel inputModel){
		this.inputModel = inputModel;
		
	}

}
