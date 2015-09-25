/**
 * 
 */
package com.stfx.sew.datamodel;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

/**
 * @author Mostafijur Rahman
 *
 */
public class DiscoverServiceResponceModel {

	@SerializedName("inputModel")
	private ServiceDiscoveryRequest inputModel;
	@SerializedName("isOperationSuccessfull")
	private boolean isOperationSuccessfull;
	@SerializedName("isResult")
	private boolean isResult;
	@SerializedName("serviceList")
	private ArrayList<DiscoveredService> serviceList;
	public ServiceDiscoveryRequest getInputModel() {
		return inputModel;
	}
	public void setInputModel(ServiceDiscoveryRequest inputModel) {
		this.inputModel = inputModel;
	}
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
	public ArrayList<DiscoveredService> getServiceList() {
		return serviceList;
	}
	public void setServiceList(ArrayList<DiscoveredService> serviceList) {
		this.serviceList = serviceList;
	}
	
}
