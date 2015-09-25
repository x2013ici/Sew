/**
 * 
 */
package com.stfx.sew.datamodel;

import com.google.gson.annotations.SerializedName;

/**
 * @author Mostafijur Rahman
 *
 */
public class ServiceDiscoveryRequest {

	@SerializedName("input")
	private String input;
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
	@SerializedName("output")
	private String output;
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	
	@SerializedName("qos")
	private String qos;
	public String getQos() {
		return qos;
	}
	public void setQos(String qos) {
		this.qos = qos;
	}	
}
