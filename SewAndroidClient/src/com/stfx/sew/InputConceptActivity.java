package com.stfx.sew;

import java.util.ArrayList;

import com.stfx.sew.manager.AppManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class InputConceptActivity extends Activity {
	
	CheckBox chkInput1;
	CheckBox chkInput2;
	CheckBox chkInput3;
	
	CheckBox chkInput4;
	CheckBox chkInput5;
	CheckBox chkInput6;
	CheckBox chkInput7;
	
	CheckBox chkInput8;
	CheckBox chkInput9;
	CheckBox chkInput10;
	
	//Button btnDiscoverServices;
	ViewGroup llConfigureHolder;
	
	//TextView txtOutputsBanner;
	
	ArrayList<CheckBox> checkBoxs;
	ArrayList<Integer> selectedCheckBoxIds;
	ArrayList<String> selectedCheckBoxTexts;
	
	String[] selectedInputs;
	ArrayList<String> inputNames = new ArrayList<String>();
	
	Context context;
	boolean isConfiguring = false;
	
	String str = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_concept);
		
		context = this;
		selectedCheckBoxTexts = new ArrayList<String>();
		
		chkInput1 = (CheckBox)findViewById(R.id.chkInput1);
		chkInput2 = (CheckBox)findViewById(R.id.chkInput2);
		chkInput3 = (CheckBox)findViewById(R.id.chkInput3);
		
		chkInput4 = (CheckBox)findViewById(R.id.chkInput4);
		chkInput5 = (CheckBox)findViewById(R.id.chkInput5);
		chkInput6 = (CheckBox)findViewById(R.id.chkInput6);
		chkInput7 = (CheckBox)findViewById(R.id.chkInput7);
		
		chkInput8 = (CheckBox)findViewById(R.id.chkInput8);
		chkInput9 = (CheckBox)findViewById(R.id.chkInput9);
		chkInput10 = (CheckBox)findViewById(R.id.chkInput10);
		
		chkInput1.setOnCheckedChangeListener(checkChange);
		chkInput2.setOnCheckedChangeListener(checkChange);
		chkInput3.setOnCheckedChangeListener(checkChange);
		
		chkInput4.setOnCheckedChangeListener(checkChange);
		chkInput5.setOnCheckedChangeListener(checkChange);
		chkInput6.setOnCheckedChangeListener(checkChange);
		chkInput7.setOnCheckedChangeListener(checkChange);
		
		chkInput8.setOnCheckedChangeListener(checkChange);
		chkInput9.setOnCheckedChangeListener(checkChange);
		chkInput10.setOnCheckedChangeListener(checkChange);
		
		checkBoxs = new ArrayList<CheckBox>();
		checkBoxs.add(chkInput1);
		checkBoxs.add(chkInput2);
		checkBoxs.add(chkInput3);
		
		checkBoxs.add(chkInput4);
		checkBoxs.add(chkInput5);
		checkBoxs.add(chkInput6);
		checkBoxs.add(chkInput7);
		
		checkBoxs.add(chkInput8);
		checkBoxs.add(chkInput9);
		checkBoxs.add(chkInput10);
		
		
	}
	
	private OnCheckedChangeListener checkChange = new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			if(isChecked){
				selectedCheckBoxTexts.add(buttonView.getText().toString());
			}
			else{
				selectedCheckBoxTexts.remove(buttonView.getText().toString());
			}
		}
	};

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
			
			saveInputSpecifications();
			
			if(selectedCheckBoxIds.size() <= 0){
				Toast.makeText(context, "Please select at least one input instance", Toast.LENGTH_SHORT).show();
			}
			
			else{
				
				Intent intent = new Intent(this, ChooseOutputConceptActivity.class);
				intent.putExtra(AppManager.IS_CONFIGURING, getIntent().getBooleanExtra(AppManager.IS_CONFIGURING, false));
				intent.putExtra(AppManager.SELECTED_TASK_ID, getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1));
				startActivity(intent);
			}
			
			//Intent intent = new Intent(this, ChooseQoSConceptActivity.class);
			
			//QoSInputActivity
			//Intent intent = new Intent(this, QoSInputActivity.class);
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void saveInputSpecifications(){
		try{
			
			selectedCheckBoxIds = new ArrayList<Integer>();
			
			for(int i = 0; i < checkBoxs.size(); i++){
				if(checkBoxs.get(i).isChecked()){
					selectedCheckBoxIds.add(i+1);
					inputNames.add(checkBoxs.get(i).getText().toString());
				}
			}
			
			if(selectedCheckBoxIds.size() > 0){
				int[] inputIds = new int[selectedCheckBoxIds.size()];
				String[] inputsValues = new String[inputNames.size()];
				for(int i = 0; i < selectedCheckBoxIds.size(); i++){
					inputIds[i] = selectedCheckBoxIds.get(i);
					inputsValues[i] = inputNames.get(i);
				}
				
				AppManager.getInstance().setInputIds(inputIds);
				AppManager.getInstance().setInputValues(inputsValues);
			}
		}
		catch(Exception ex){
			
		}
	}
}
