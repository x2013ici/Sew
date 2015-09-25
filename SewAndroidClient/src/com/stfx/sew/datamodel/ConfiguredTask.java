package com.stfx.sew.datamodel;

import com.google.gson.annotations.SerializedName;

public class ConfiguredTask {

	@SerializedName("TaskName")
	private String taskName;
	@SerializedName("TaskSpecification")
	private TaskSpecification taskSpecification;
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public TaskSpecification getTaskSpecification() {
		return taskSpecification;
	}
	public void setTaskSpecification(TaskSpecification taskSpecification) {
		this.taskSpecification= taskSpecification;
	}
	
}
