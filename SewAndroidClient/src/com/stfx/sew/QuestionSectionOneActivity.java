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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author Mostafijur Rahman
 * @since 23th April, 2015
 */
public class QuestionSectionOneActivity extends Activity {

	RadioGroup rdgCondition;
	RadioButton rdCondition1;
	RadioButton rdCondition2;
	
	RadioGroup rdgSymptom;
	RadioButton rdSymptom1;
	RadioButton rdSymptom2;
	RadioButton rdSymptom3;
	RadioButton rdSymptom4;
	
	TextView txtBanner;
	
	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_section_one);
		context = this;
		
		txtBanner = (TextView)findViewById(R.id.txtBanner);
		if(getIntent().getBooleanExtra(AppManager.IS_CONFIGURING, false)){
			String str = getResources().getString(R.string.txt_core_input_banner);
			str = str + " ( ";
			str = str + SharedPreferenceHelper.getSelectedWorkflowName(context);
			str = str + " -> ";
			str = str + AllSelectedTasks.getSelectedTaskById(getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1)).getTaskName();
			str = str + " )";
			txtBanner.setText(str);
		}
		
		rdgCondition = (RadioGroup)findViewById(R.id.rdgCondition);
		rdCondition1 = (RadioButton)findViewById(R.id.rdCondition1);
		rdCondition2 = (RadioButton)findViewById(R.id.rdCondition2);
		
		rdgSymptom = (RadioGroup)findViewById(R.id.rdgSymptom);
		rdSymptom1 = (RadioButton)findViewById(R.id.rdSymptom1);
		rdSymptom2 = (RadioButton)findViewById(R.id.rdSymptom2);
		rdSymptom3 = (RadioButton)findViewById(R.id.rdSymptom3);
		rdSymptom4= (RadioButton)findViewById(R.id.rdSymptom4);
		
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
			
			int checkedCoditonId = rdgCondition.getCheckedRadioButtonId();
			int checkedSymptomId = rdgSymptom.getCheckedRadioButtonId();
			if(checkedCoditonId == -1 || checkedSymptomId == -1){
				Toast.makeText(context, "Please select conditon and symptom", Toast.LENGTH_SHORT).show();
			}
			else{
				if(checkedCoditonId == rdCondition1.getId()){
					AppManager.getInstance().setSelectedCondition(1);
					AppManager.getInstance().setSelectedConditionName(rdCondition1.getText().toString());
				}
				else{
					AppManager.getInstance().setSelectedCondition(2);
					AppManager.getInstance().setSelectedConditionName(rdCondition2.getText().toString());
				}
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
				else{
					AppManager.getInstance().setSelectedSymptom(4);
					AppManager.getInstance().setSelectedSymptomName(rdSymptom4.getText().toString());
				}
				Intent intent = new Intent(this, ChooseQoSConceptActivity.class);
				intent.putExtra(AppManager.IS_CONFIGURING, getIntent().getBooleanExtra(AppManager.IS_CONFIGURING, false));
				intent.putExtra(AppManager.SELECTED_TASK_ID, getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1));
				startActivity(intent);
			}
			return true;
			
		}
		return super.onOptionsItemSelected(item);
	}
}
