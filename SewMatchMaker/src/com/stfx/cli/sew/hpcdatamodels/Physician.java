package com.stfx.cli.sew.hpcdatamodels;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Physician extends BaseModel implements Serializable{
	
	private String physicianName;
	public String getPhysicianName(){
		return physicianName;
	}
	public void setPhysicianName(String physicianName){
		this.physicianName = physicianName;
	}

}