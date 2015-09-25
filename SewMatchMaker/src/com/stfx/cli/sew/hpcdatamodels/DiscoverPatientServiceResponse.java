package com.stfx.cli.sew.hpcdatamodels;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DiscoverPatientServiceResponse extends ExecuteServiceBaseResponse implements Serializable{

	private ArrayList<Patient> patientList;
	public ArrayList<Patient> getPatientList(){
		return patientList;
	}
	public void setPatientList(ArrayList<Patient> patientList){
		this.patientList = patientList;
	}

}
