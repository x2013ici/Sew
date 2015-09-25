package com.stfx.sew.responsemodel;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Patient extends BaseModel implements Serializable{
	
	private String patientName;
	public String getPatientName(){
		return patientName;
	}
	public void setPaitentName(String patientName){
		this.patientName = patientName;
	}

}
