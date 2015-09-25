package com.stfx.sew;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.stfx.sew.dataholders.AllSelectedTasks;
import com.stfx.sew.manager.AppManager;
import com.stfx.sew.util.SharedPreferenceHelper;

/**
 * 
 * @author Mostafijur Rahman
 * @since 23th April, 2015
 */
public class ChooseQoSConceptActivity extends Activity {

	ArrayList<Integer> selectionOrderIdList;
	ArrayList<String> selectionOrderNameList;
	ArrayList<TextView> qoSPropertyNameList;
	
	CheckBox chkInput1;
	CheckBox chkInput2;
	CheckBox chkInput3;
	
	TextView txtInp1;
	TextView txtInp2;
	TextView txtInp3;
	
	TextView txtQoSBanner;
	
	Context context;
	
	String str =null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qo_sinput);
		context = this;
		
		/*txtQoSBanner = (TextView)findViewById(R.id.txtQoSBanner);
		txtQoSBanner.setTextSize(getResources().getDimension(R.dimen.textsize));
		
		if(getIntent().getBooleanExtra(AppManager.IS_CONFIGURING, false)){
			str = str + "Configuraing ";
			str = str + SharedPreferenceHelper.getSelectedWorkflowName(context);
			str = str + " -> ";
			str = str + AllSelectedTasks.getSelectedTaskById(getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1)).getTaskName();
			str = str + "(";
			str = getResources().getString(R.string.txt_core_input_banner);
			str = str + ")";
			txtQoSBanner.setText(str);
			
			txtQoSBanner.setVisibility(View.VISIBLE);
		}*/
		
		selectionOrderIdList = new ArrayList<Integer>();
		selectionOrderNameList = new ArrayList<String>();
		qoSPropertyNameList = new ArrayList<TextView>();
		
		chkInput1 = (CheckBox)findViewById(R.id.chkInput1);
		chkInput2 = (CheckBox)findViewById(R.id.chkInput2);
		chkInput3 = (CheckBox)findViewById(R.id.chkInput3);
		
		txtInp1 = (TextView)findViewById(R.id.txtInp1);
		txtInp2 = (TextView)findViewById(R.id.txtInp2);
		txtInp3 = (TextView)findViewById(R.id.txtInp3);
		
		qoSPropertyNameList.add(txtInp1);
		qoSPropertyNameList.add(txtInp2);
		qoSPropertyNameList.add(txtInp3);
		
		emptyAllText();
		
		chkInput1.setOnCheckedChangeListener(priorityUpdateListener);
		chkInput2.setOnCheckedChangeListener(priorityUpdateListener);
		chkInput3.setOnCheckedChangeListener(priorityUpdateListener);
		
	}
	
	/**
	 * Set null/empty to each element of 
	 */
	private void emptyAllText(){
		
		for(int i = 0; i< qoSPropertyNameList.size(); i++){
			qoSPropertyNameList.get(i).setText("");
		}
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
			
			if(selectionOrderIdList.size() < 3){
				Toast.makeText(context, "Please select all QoS concepts", Toast.LENGTH_SHORT).show();
			}
			else{
				int[] qos = new int[selectionOrderIdList.size()];
				String[] qosV = new String[selectionOrderNameList.size()];
				for(int i = 0; i<selectionOrderIdList.size(); i++){
					qos[i] = selectionOrderIdList.get(i);
					qosV[i] = selectionOrderNameList.get(i);
				}
				
				AppManager.getInstance().setQos(qos);
				AppManager.getInstance().setQosValues(qosV);
				
				
				
				Intent intent = new Intent(context, ChooseOutputConceptActivity.class);
				intent.putExtra(AppManager.IS_CONFIGURING, getIntent().getBooleanExtra(AppManager.IS_CONFIGURING, false));
				intent.putExtra(AppManager.SELECTED_TASK_ID, getIntent().getIntExtra(AppManager.SELECTED_TASK_ID, -1));
				startActivity(intent);
			}
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private OnCheckedChangeListener priorityUpdateListener = new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			Integer item;
			
			if(buttonView.getId() == chkInput1.getId()){
				item = Integer.valueOf(1);
			}
			else if(buttonView.getId() == chkInput2.getId()){
				item = Integer.valueOf(2);
			}
			else{
				item = Integer.valueOf(3);
			}
			
			if(isChecked){
				selectionOrderIdList.add(item);
				selectionOrderNameList.add(buttonView.getText().toString());
			}
			else{
				selectionOrderIdList.remove(item);
				selectionOrderNameList.remove(buttonView.getText().toString());
			}
			
			emptyAllText();
			
			if(selectionOrderIdList.size() > 0){
				for(int i = 0; i<selectionOrderIdList.size(); i++){
					qoSPropertyNameList.get(i).setText(selectionOrderNameList.get(i));
				}
			}
			
		}
	};
	
}
