package com.stfx.sew.datamodel;

public class InputOutputInstance {
	
	private String name;
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	private String ontologyIri;
	public String getOntologyIri(){
		return this.ontologyIri;
	}
	public void setOntologyIri(String ontologyIri){
		this.ontologyIri = ontologyIri;
	}
	
	public InputOutputInstance(){
		
	}
	public InputOutputInstance(String name, String ontologyIri){
		this.name = name;
		this.ontologyIri = ontologyIri;
	}

}
