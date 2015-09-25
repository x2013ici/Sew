package com.stfx.cli.sew.datamodels;

/**
 * 
 * @author Mostafijur Rahman
 * since 23th March, 2015
 */
public class ResponseTime {

	private String value;
	public String getValue(){
		return this.value;
	}
	public void setValue(String value){
		this.value = value;
	}
	
	private String condition;
	public String getCondition(){
		return this.condition;
	}
	public void setCondition(String condition){
		this.condition = condition;
	}
	
	private int weight;
	public int getWeight(){
		return this.weight;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
	
	private String unit;
	public String getUnit(){
		return this.unit;
	}
	public void setUnit(String unit){
		this.unit = unit;
	}
	
	private int position;
	public int getPosition(){
		return position;
	}
	public void setPosition(int position){
		this.position = position;
	}
}
