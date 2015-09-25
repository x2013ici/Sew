package com.stfx.cli.sew.datamodels;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InputModel implements Serializable{
	
	private String input;
	private String output;
	private String qos;
	
	public String getInput(){
		return this.input;
	}
	public void setInput(String input){
		this.input = input;
	}
	
	public String getQos(){
		return this.qos;
	}
	public void setQos(String qos){
		this.qos = qos;
	}
	
	public String getOutput(){
		return this.output;
	}
	public void setOutput(String output){
		this.output = output;
	}

}
