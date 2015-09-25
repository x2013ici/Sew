/**
 * 
 */
package com.stfx.sew.datamodel;

import com.google.gson.annotations.SerializedName;

/**
 * @author Mostafijur Rahman
 *
 */
public class ExecuteServiceDM {

	@SerializedName("isOperationSuccessfull")
	private boolean isOperationSuccessfull;
	@SerializedName("isResult")
	private boolean isResult;
	@SerializedName("message")
	private String message;
	@SerializedName("outputModel")
	private ExecutionOutputsDM outputModel;
	public boolean isOperationSuccessfull() {
		return isOperationSuccessfull;
	}
	public void setOperationSuccessfull(boolean isOperationSuccessfull) {
		this.isOperationSuccessfull = isOperationSuccessfull;
	}
	public boolean isResult() {
		return isResult;
	}
	public void setResult(boolean isResult) {
		this.isResult = isResult;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExecutionOutputsDM getOutputModel() {
		return outputModel;
	}
	public void setOutputModel(ExecutionOutputsDM outputModel) {
		this.outputModel = outputModel;
	}
	
}
