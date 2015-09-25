package com.stfx.sew;

import com.stfx.sew.dataholders.AllSelectedTasks;
import com.stfx.sew.manager.AppManager;
import com.stfx.sew.util.SharedPreferenceHelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author Mostafijur Rahman
 * @since 22th April, 2015
 */
public class ChooseInputConceptActivity extends Activity {

	RadioGroup rdgCondition;
	RadioButton rdCondition1;
	RadioButton rdCondition2;
	RadioButton rdCondition3;
	
	RadioGroup rdgSymptom;
	RadioButton rdSymptom1;
	RadioButton rdSymptom2;
	RadioButton rdSymptom3;
	RadioButton rdSymptom4;
	
	RadioButton rdSymptom5;
	RadioButton rdSymptom6;
	RadioButton rdSymptom7;
	
	TextView txtBanner;
	
	Context context;
	String str = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_input_concept);
		context = this;
		
		/*txtBanner = (TextView)findViewById(R.id.txtBanner);
		if(getIntent().getBooleanExtra(AppManager.IS_CONFIGURING, false)){
			
			str = str + "Configuraing ";
			str = str + SharedPreferenceHelper.getSelectedWorkflowName(context);
			str = str + " -> ";
			str = str + AllSelectedTasks.getSelectedTaskById(getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1)).getTaskName();
			str = str + " Task";
			str = str + "( ";
			str = getResources().getString(R.string.txt_core_input_banner);
			str = str + ")";
			txtBanner.setText(str);
			
			txtBanner.setVisibility(View.VISIBLE);
		}*/
		
		rdgCondition = (RadioGroup)findViewById(R.id.rdgCondition);
		rdCondition1 = (RadioButton)findViewById(R.id.rdCondition1);
		rdCondition2 = (RadioButton)findViewById(R.id.rdCondition2);
		rdCondition3 = (RadioButton)findViewById(R.id.rdCondition3);
		
		rdgSymptom = (RadioGroup)findViewById(R.id.rdgSymptom);
		rdSymptom1 = (RadioButton)findViewById(R.id.rdSymptom1);
		rdSymptom2 = (RadioButton)findViewById(R.id.rdSymptom2);
		rdSymptom3 = (RadioButton)findViewById(R.id.rdSymptom3);
		rdSymptom4= (RadioButton)findViewById(R.id.rdSymptom4);
		
		rdSymptom5 = (RadioButton)findViewById(R.id.rdSymptom5);
		rdSymptom6 = (RadioButton)findViewById(R.id.rdSymptom6);
		rdSymptom7 = (RadioButton)findViewById(R.id.rdSymptom7);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question_section_one, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_next) {
			
			int checkedConditonId = rdgCondition.getCheckedRadioButtonId();
			int checkedSymptomId = rdgSymptom.getCheckedRadioButtonId();
			
			if(checkedConditonId == -1 || checkedSymptomId == -1){
				Toast.makeText(context, "Please select conditon and symptom", Toast.LENGTH_SHORT).show();
			}
			else{
				
				/**
				 * Process input #1
				 */
				if(checkedConditonId == rdCondition1.getId()){
					AppManager.getInstance().setSelectedCondition(1);
					AppManager.getInstance().setSelectedConditionName(rdCondition1.getText().toString());
				}
				else if(checkedConditonId == rdCondition2.getId()){
					AppManager.getInstance().setSelectedCondition(2);
					AppManager.getInstance().setSelectedConditionName(rdCondition2.getText().toString());
				}
				else{
					AppManager.getInstance().setSelectedCondition(3);
					AppManager.getInstance().setSelectedConditionName(rdCondition3.getText().toString());
				}
				
				/**
				 * Process input #2
				 */
				if(checkedSymptomId == rdSymptom1.getId()){
					AppManager.getInstance().setSelectedSymptom(1);
					AppManager.getInstance().setSelectedSymptomName(rdSymptom1.getText().toString());
				}
				else if(checkedSymptomId == rdSymptom2.getId()){
					AppManager.getInstance().setSelectedSymptom(2);
					AppManager.getInstance().setSelectedSymptomName(rdSymptom2.getText().toString());
				}
				else if(checkedSymptomId == rdSymptom3.getId()){
					AppManager.getInstance().setSelectedSymptom(3);
					AppManager.getInstance().setSelectedSymptomName(rdSymptom3.getText().toString());
				}
				
				else if(checkedSymptomId == rdSymptom4.getId()){
					AppManager.getInstance().setSelectedSymptom(4);
					AppManager.getInstance().setSelectedSymptomName(rdSymptom4.getText().toString());
				}
				
				else if(checkedSymptomId == rdSymptom5.getId()){
					AppManager.getInstance().setSelectedSymptom(5);
					AppManager.getInstance().setSelectedSymptomName(rdSymptom5.getText().toString());
				}
				
				else if(checkedSymptomId == rdSymptom6.getId()){
					AppManager.getInstance().setSelectedSymptom(6);
					AppManager.getInstance().setSelectedSymptomName(rdSymptom6.getText().toString());
				}
				else{
					AppManager.getInstance().setSelectedSymptom(7);
					AppManager.getInstance().setSelectedSymptomName(rdSymptom7.getText().toString());
				}
				
				Intent intent = new Intent(this, QoSInputActivity.class);
				intent.putExtra(AppManager.IS_CONFIGURING, getIntent().getBooleanExtra(AppManager.IS_CONFIGURING, false));
				intent.putExtra(AppManager.SELECTED_TASK_ID, getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1));
				startActivity(intent);
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
