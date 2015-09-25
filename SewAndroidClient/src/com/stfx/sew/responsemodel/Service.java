package com.stfx.sew.responsemodel;

public class Service {
	
	private int id;
	private String serviceProvider=null;
	private String serviceName=null;
	private int inputOutputScore=0;
	private int qosScore=0;
	private int totalScore=0;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getServiceProvider(){
		return this.serviceProvider;
	}
	public void setServiceProvider(String serviceProvider){
		this.serviceProvider = serviceProvider;
	}
	
	public String getServiceName(){
		return this.serviceName;
	}
	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}
	
	public int getInputOutputScore(){
		return this.inputOutputScore;
	}
	public void setInputOutputScore(int inputOutputScore){
		this.inputOutputScore = inputOutputScore;
	}
	
	public int getQosScore(){
		return this.qosScore;
	}
	public void setQosScore(int qosScore){
		this.qosScore = qosScore;
	}
	
	public int getTotalScore(){
		return this.inputOutputScore + this.qosScore;
	}
	public void setTotalScore(int inputOutputScore, int qosScore){
		this.totalScore = inputOutputScore + qosScore;
	}

}
