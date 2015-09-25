package com.stfx.sew.responsemodel;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Explanation extends BaseModel implements Serializable{

	private boolean isExplained;
	public boolean getIsExplained(){
		return isExplained;
	}
	public void setIsExplained(boolean isExplained){
		this.isExplained = isExplained;
	}
	
	private String description;
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
}
