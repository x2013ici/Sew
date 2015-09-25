/**
 * 
 */
package com.stfx.sew.datamodel;

/**
 * @author Mostafijur Rahman
 *
 */
public class SearchResultDataModel {

	private int id;
	private String serviceName;
	private int conditionId;
	private int symptompId;
	private int[] priorityList;
	private int[] outputList;
	private int inputOutputScore;
	private int qosScore;
	private int totalScore;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getConditionId() {
		return conditionId;
	}
	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}
	public int getSymptompId() {
		return symptompId;
	}
	public void setSymptompId(int symptompId) {
		this.symptompId = symptompId;
	}
	public int[] getPriorityList() {
		return priorityList;
	}
	public void setPriorityList(int[] priorityList) {
		this.priorityList = priorityList;
	}
	public int[] getOutputList() {
		return outputList;
	}
	public void setOutputList(int[] outputList) {
		this.outputList = outputList;
	}
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
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	
}
