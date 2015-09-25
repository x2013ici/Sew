package com.stfx.cli.sew.hpcdatamodels;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DiscoverCareGiverServiceResponse extends ExecuteServiceBaseResponse implements Serializable{
	
	private ArrayList<Caregiver> careGiverList;
	public ArrayList<Caregiver> getCareGiver(){
		return this.careGiverList;
	}
	
	public void setCareGiver(ArrayList<Caregiver> careGiverList){
		this.careGiverList = careGiverList;
	}

}
