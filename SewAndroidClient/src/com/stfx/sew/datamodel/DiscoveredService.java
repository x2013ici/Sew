/**
 * 
 */
package com.stfx.sew.datamodel;

import com.google.gson.annotations.SerializedName;

/**
 * @author Mostafijur Rahman
 *
 */
public class DiscoveredService {

	@SerializedName("id")
	private int id;
	@SerializedName("inputOutputScore")
	private int inputOutputScore;
	@SerializedName("qosScore")
	private int qosScore;
	@SerializedName("serviceName")
	private String serviceName;
	@SerializedName("serviceProvider")
	private String serviceProvider;
	@SerializedName("totalScore")
	private int totalScore;
	public int getInputOutputScore() {
		return inputOutputScore;
	}
	public void setInputOutputScore(int inputOutputScore) {
		this.inputOutputScore = inputOutputScore;
	}
	public int getQosScore() {
		return qosScore;
	}
	public void setQosScore(int qosScore) {
		this.qosScore = qosScore;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
}
