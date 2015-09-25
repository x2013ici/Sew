package com.stfx.sew.datamodel;

public class QoSInstance {

	private int id;
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	private String name;
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public QoSInstance(){
		
	}
	
	public QoSInstance(int id, String name){
		this.id = id;
		this.name = name;
	}
}
