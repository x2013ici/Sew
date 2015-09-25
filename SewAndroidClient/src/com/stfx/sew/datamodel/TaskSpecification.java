/**
 * 
 */
package com.stfx.sew.datamodel;

/**
 * @author Mostafijur Rahman
 *
 */
public class TaskSpecification {

	private Inputs inputs;
	private Qosinputs qosinputs;
	
	private OutputsIn outputs;
	private TaskExecutionRules taskExecutionRules;
	
	public Inputs getInputs() {
		return inputs;
	}
	public void setInputs(Inputs inputs) {
		this.inputs = inputs;
	}
	
	public Qosinputs getQosinputs() {
		return qosinputs;
	}
	public void setQosinputs(Qosinputs qosinputs) {
		this.qosinputs = qosinputs;
	}
	
	public OutputsIn getOutputs() {
		return outputs;
	}
	public void setOutputs(OutputsIn outputs) {
		this.outputs = outputs;
	}
	
	public TaskExecutionRules getTaskExecutionRules(){
		return taskExecutionRules;
	}
	public void setTaskExecutionRules(TaskExecutionRules taskSpecificationRules){
		this.taskExecutionRules = taskSpecificationRules;
	}
	
}
