package com.stfx.sew.responsemodel;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DiscoverPhysicianServiceResponse extends ExecuteServiceBaseResponse implements Serializable{

	private ArrayList<Physician> physicianList;
	public ArrayList<Physician> getPhysicianList(){
		return physicianList;
	}
	public void setPhysicianList(ArrayList<Physician> physicianList){
		this.physicianList = physicianList;
	}	
}
