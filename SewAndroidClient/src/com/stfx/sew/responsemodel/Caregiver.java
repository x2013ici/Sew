package com.stfx.sew.responsemodel;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Caregiver extends BaseModel implements Serializable{

	private String careGiverName;
	public String getCareGiverName(){
		return this.careGiverName;
	}
	public void setCaregiverName(String careGiverName){
		this.careGiverName = careGiverName;
	}
}
