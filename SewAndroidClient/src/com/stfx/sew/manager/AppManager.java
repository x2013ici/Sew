/**
 * 
 */
package com.stfx.sew.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import android.os.Environment;

import com.stfx.sew.datamodel.ConfiguredTask;
import com.stfx.sew.datamodel.NovaTask;
import com.stfx.sew.datamodel.Workflow;


/**
 * @author Mostafijur Rahman
 *
 */
public class AppManager {

	private static AppManager instance = null;
	public static synchronized AppManager getInstance(){
		if(instance == null){
			instance = new AppManager();
		}
		return instance;
	}
	
	private AppManager(){
		
	}
	
	public static String TAG = "SewAndroidClient";
	
	//public static final int HOSPICE_PALLIATIVE_CARE_SEQUENCIAL_WORKFLOW_ID = 1;
	//public static final String HOSPICE_PALLIATIVE_CARE_SEQUENCIAL_WORKFLOW_NAME = "Hospice Palliative Care Sequential Workflow";
	
	public static final int HOSPICE_PALLIATIVE_CARE_OVERLL_WORKFLOW_ID = 1;
	public static final String HOSPICE_PALLIATIVE_CARE_OVERALL_WORKFLOW_NAME = "Hospice Palliative Care Overall Workflow";
	//public static final String HOSPICE_PALLIATIVE_CARE_OVERALL_WORKFLOW_NAME = "Sample Workflow";
	
	public static final int MAX_QOS_PROPERTY = 3;
	public static int TOP_MOST_SERVICE_INDEX = 0;
	
	
	public static final String PRIORITY_HIGH = "High";
	public static final String PRIORITY_MEIDUM = "Medium";
	public static final String PRIORITY_LOW = "Low";
	
	public static final String IS_CONFIGURING = "IsConfiguring";
	public static final String SELECTED_TASK_ID = "SelectedTaskId";
	
	public static final String FILE_NAME = "SEWConfiguration.txt";
	
	private int selectedCondition = 0;
	private String selectedConditionName = "";
	
	private int selectedSymptom = 0;
	private String selectedSymptomName = "";
	
	private int[] qos = new int[MAX_QOS_PROPERTY];
	private String[] qosValues = new String[MAX_QOS_PROPERTY];
	
	
	private Workflow workFlow;
	//public static int selectedWorkflowIndex;
	
	
	//public static ArrayList<NovaTask> hpcSequencialNovaTaskList = new ArrayList<NovaTask>();
	public static ArrayList<NovaTask> hpcOverallNovaTaskList = new ArrayList<NovaTask>();
	
	public static ArrayList<NovaTask> selectedNovaTaskList = new ArrayList<NovaTask>();
	
	// Hospice Palliative Care Sequential Work-flow
	//public static HashMap<Integer, NovaTask> hpcSequencialWorkflowTaskList = new HashMap<Integer, NovaTask>();
	//public static LinkedHashMap<Integer, NovaTask> hpcSequencialWorkflowTaskExecutionList = new LinkedHashMap<Integer, NovaTask>();
	//public static HashMap<String, ConfiguredTask> hpcSequencialWorkflowSpecificConfiguredTaskList = new HashMap<String, ConfiguredTask>();
	
	
	// Hospic Palliative Care Split-Join Work-flow
	public static HashMap<Integer, NovaTask> hpcOverallWorkflowTaskList = new HashMap<Integer, NovaTask>();
	public static LinkedHashMap<Integer, NovaTask> hpcOverallWorkflowTaskExecutionList = new LinkedHashMap<Integer, NovaTask>();
	//public static HashMap<String, ConfiguredTask> hpcOverallWorkflowSpecificConfiguredTaskLlist = new HashMap<String, ConfiguredTask>();
	
	public static HashMap<String, ConfiguredTask> workflowSpecificConfiguredTaskList = new HashMap<String, ConfiguredTask>();
	
	/*public ArrayList<NovaTask> getNovaTaskList(){
		return this.novaTaskList;
	}
	
	public void setNovaTaskList(ArrayList<NovaTask> novaTaskList){
		this.novaTaskList = novaTaskList;
	}*/
	
	
	
	private int[] inPuts;
	public int[] getInputIds(){
		return inPuts;
	}
	public void setInputIds(int[] inputs){
		this.inPuts = inputs;
	}
	
	private int[] outPuts;
	public int[] getOutputs() {
		return outPuts;
	}
	public void setOutputs(int[] outputs) {
		this.outPuts = outputs;
	}
	
	private int[] taskExecutionRuleIds;
	public int[] getTaskExecutionRuleIds(){
		return taskExecutionRuleIds;
	}
	public void setTaskExecutionRuleIds(int[] taskExecutionRuleIds){
		this.taskExecutionRuleIds = taskExecutionRuleIds;
	}

	private String[] inputValues;
	public String[] getInputValues(){
		return inputValues;
	}
	public void setInputValues(String[] inputValues){
		this.inputValues = inputValues;
	}
	
	private String[] outPutValues;
	public String[] getOutputsValue() {
		return outPutValues;
	}
	public void setOutputsValue(String[] outputsValue) {
		this.outPutValues = outputsValue;
	}
	
	private String[] taskExecutionRuleValues;
	public String[] getTaskExecutionRuleValues(){
		return this.taskExecutionRuleValues;
	}
	public void setTaskExecutionRuleValues(String[] taskExecutionRuleValues){
		this.taskExecutionRuleValues = taskExecutionRuleValues;
	}

	private String responseTime;
	public String getSelectedResponseTime(){
		return responseTime;
	}
	public void setSelectedResponseTime(String responseTime){
		this.responseTime = responseTime;
	}
	
	private String executionPrice;
	public String getSelectedExecutionPrice(){
		return executionPrice;
	}
	public void setSelectedExecutionPrice(String executionPrice){
		this.executionPrice = executionPrice;
	}
	
	private String reliability;
	public String getSelectedReliability(){
		return reliability;
	}
	public void setSelectedReliability(String reliability){
		this.reliability = reliability;
	}
	
	public Workflow getWorkflow() {
		if(workFlow == null){
			workFlow = new Workflow();
		}
		return workFlow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workFlow = workflow;
	}

	public String getPriorityById(int priorityId){
		switch(priorityId){
		case 1:
			return PRIORITY_HIGH;
		case 2:
			return PRIORITY_MEIDUM;
		case 3:
			return PRIORITY_LOW;
		default:
				return "";
		}
	}

	public static File createDirectory(){
		String basePath = Environment.getExternalStorageDirectory().getAbsolutePath();
		File dir = new File(basePath + "/Sew");
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		return dir;
	}
	
	public int[] getQos() {
		return qos;
	}
	public void setQos(int[] qos) {
		this.qos = qos;
	}
	
	public String[] getQosValues() {
		return qosValues;
	}

	public void setQosValues(String[] qosValues) {
		this.qosValues = qosValues;
	}
	
	public int getSelectedCondition() {
		return selectedCondition;
	}
	public void setSelectedCondition(int selectedCondition) {
		this.selectedCondition = selectedCondition;
	}
	
	public int getSelectedSymptom() {
		return selectedSymptom;
	}
	public void setSelectedSymptom(int selectedSymptom) {
		this.selectedSymptom = selectedSymptom;
	}
	
	public String getSelectedConditionName() {
		return selectedConditionName;
	}

	public void setSelectedConditionName(String selectedConditionName) {
		this.selectedConditionName = selectedConditionName;
	}

	public String getSelectedSymptomName() {
		return selectedSymptomName;
	}

	public void setSelectedSymptomName(String selectedSymptomName) {
		this.selectedSymptomName = selectedSymptomName;
	}
}
