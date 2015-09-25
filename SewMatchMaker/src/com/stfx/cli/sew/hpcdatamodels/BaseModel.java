package com.stfx.cli.sew.hpcdatamodels;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BaseModel implements Serializable{
	
	private String ontologyIRI;
	public String getOntologyIRI(){
		return ontologyIRI;
	}
	public void setOntologyIRI(String ontologyIRI){
		this.ontologyIRI = ontologyIRI;
	}
	
	private String conceptType;
	public String getConceptType(){
		return conceptType;
	}
	public void setConceptType(String conceptType){
		this.conceptType = conceptType;
	}

}
