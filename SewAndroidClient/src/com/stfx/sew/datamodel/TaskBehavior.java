package com.stfx.sew.datamodel;

public class TaskBehavior {
	
	private int id;
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	private String behaviorName;
	public String getBehaviorName(){
		return this.behaviorName;
	}
	public void setBehaviorName(String behaviorName){
		this.behaviorName= behaviorName;
	}
	
	public TaskBehavior(){
		
	}
	public TaskBehavior(int id, String behaviorName){
		this.id = id;
		this.behaviorName = behaviorName;
	}

}
