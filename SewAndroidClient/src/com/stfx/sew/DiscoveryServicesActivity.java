package com.stfx.sew;

import java.util.ArrayList;

import org.apache.http.Header;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.stfx.sew.dataholders.AllSearchResult;
import com.stfx.sew.datamodel.DiscoverServiceResponceModel;
import com.stfx.sew.datamodel.DiscoveredService;
import com.stfx.sew.datamodel.ExecuteServiceDM;
import com.stfx.sew.datamodel.ExecutionOutputsDM;
import com.stfx.sew.datamodel.ServiceDiscoveryRequest;
import com.stfx.sew.manager.AppManager;
import com.stfx.sew.util.AllUrls;
import com.stfx.sew.util.NetInfo;

/**
 * 
 * @author Mostafijur Rahman
 * @since 28th April, 2015
 */
public class DiscoveryServicesActivity extends Activity {

	TextView txtEmptyView;
	ListView lstSearchResult;

	SearchResultAdapter searchResultAdapter;

	ArrayList<DiscoveredService> discoverdServices;

	private int selectedPos = -1;

	ServiceDiscoveryRequest serviceInput;

	Gson gsonObject;

	Context context;
	ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_reasult);
		context = this;

		gsonObject = new Gson();

		discoverdServices = new ArrayList<DiscoveredService>();
		// add dummy data to searchResults
		// populateDummyData();

		discoverdServices.clear();
		discoverdServices = AllSearchResult.getAllSearchResults();
		//txtEmptyView = (TextView) findViewById(R.id.txtServiceSearchResultBanenr);
		lstSearchResult = (ListView) findViewById(R.id.lstSearchResult);
		searchResultAdapter = new SearchResultAdapter();
		lstSearchResult.setAdapter(searchResultAdapter);
		lstSearchResult.setEmptyView(txtEmptyView);
		lstSearchResult.setOnItemClickListener(serviceSelectListener);
		
		try{
			constructServiceRequest();
			DiscoverSemanticWebServices();
		}
		catch(Exception ex){
			
		}
	}

	private void constructServiceRequest() {
		
		serviceInput = new ServiceDiscoveryRequest();
		StringBuilder inputStr = new StringBuilder();
		inputStr.append(AppManager.getInstance().getSelectedConditionName());
		
		inputStr.append(":");
		inputStr.append(AppManager.getInstance().getSelectedSymptomName());
		serviceInput.setInput(inputStr.toString());

		inputStr = new StringBuilder();
		String[] qos = AppManager.getInstance().getQosValues();
		
		for (int i = 0; i < qos.length; i++) {
			inputStr.append(qos[i]);
			if (i < qos.length - 1) {
				inputStr.append(":");
			}
		}
		serviceInput.setQos(inputStr.toString());

		inputStr = new StringBuilder();
		String[] outputs = AppManager.getInstance().getOutputsValue();
		for (int i = 0; i < outputs.length; i++) {
			inputStr.append(outputs[i]);
			if (i < outputs.length - 1) {
				inputStr.append(":");
			}
		}
		serviceInput.setOutput(inputStr.toString());

	}

	private void DiscoverSemanticWebServices() {
		
		if (!NetInfo.isOnline(context)) {
			Toast.makeText(context, "Please connect to the Internet and try again", Toast.LENGTH_SHORT).show();
			return;
		}

		pd = ProgressDialog.show(context, "Please wait", "Discovering Semantic Web Services for the Request...", true, false);

		String url = AllUrls.getDrugDiscoveryServiceUrl(serviceInput);

		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		asyncHttpClient.setTimeout(120000);
		asyncHttpClient.get(url, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] response) {
				// TODO Auto-generated method stub
				pd.dismiss();

				String responseString = new String(response);
				DiscoverServiceResponceModel discoveryServiceResponseModel = gsonObject.fromJson(responseString, DiscoverServiceResponceModel.class);
				System.out.println(discoveryServiceResponseModel.getInputModel());
				if(discoveryServiceResponseModel.isOperationSuccessfull() && discoveryServiceResponseModel.isResult()){
					loadData(discoveryServiceResponseModel.getServiceList());
				}
				else{
					Toast.makeText(context, "No Semantic Web Service found...", Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responce, Throwable th) {
				// TODO Auto-generated method stub
				pd.dismiss();
				Toast.makeText(context, "Error occured while discovering semantic web services... " + th, Toast.LENGTH_SHORT).show();
			}
		});

	}
	
	public void Cancel(View v){
		
		try{
			Intent intent = new Intent(this,ChooseOptionActivity.class);
			startActivity(intent);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void loadData(ArrayList<DiscoveredService> services){
		if(services != null && services.size() > 0){
			AllSearchResult.addAllSearchResults(services);
		}
		
		updateUI();
	}
	
	private void updateUI(){
		discoverdServices.clear();
		discoverdServices = AllSearchResult.getAllSearchResults();
		((BaseAdapter)lstSearchResult.getAdapter()).notifyDataSetChanged();
		lstSearchResult.invalidate();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_reasult, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_logout) {
			Intent intent = new Intent(context, LoginActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);

			finish();

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	public void executeService(View v) {
		
		if (selectedPos < 0) {
			Toast.makeText(context, "Please select a service to execute...", Toast.LENGTH_SHORT).show();
		} else {
			/*String name = searchResults.get(selectedPos).getServiceName();
			Toast.makeText(context, "Service Executed Successfully: " + name, Toast.LENGTH_SHORT).show();*/
			
			if(!NetInfo.isOnline(context)){
				Toast.makeText(context, "No Internet Connection..., Please wait", Toast.LENGTH_SHORT).show();
				return;
			}
			
			DiscoveredService service = discoverdServices.get(selectedPos);
			int selectedId = service.getId();
			String url = AllUrls.getExecuteServiceUrl(selectedId + "");
			
			AsyncHttpClient client = new AsyncHttpClient();
			pd = ProgressDialog.show(context, "Please Wait...", "Executing selected Service", true, false);
			client.get(url, new AsyncHttpResponseHandler() {
				
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] response) {
					// TODO Auto-generated method stub
					pd.dismiss();
					String resp = new String(response);
					System.out.println("Execution resp: " + resp);
					Gson g = new Gson();
					ExecuteServiceDM es = g.fromJson(resp, ExecuteServiceDM.class);
					Toast.makeText(context, es.getMessage(), Toast.LENGTH_SHORT).show();
					if(es.isOperationSuccessfull() && es.isResult()){
						StringBuilder sb = new StringBuilder("Execution output: ");
						ExecutionOutputsDM eo = es.getOutputModel();
						if(eo != null){
							if(eo.getAmbrox() != null){
								sb.append("ambrox : ");
								sb.append(eo.getAmbrox());
							}
							
							if(eo.getCef3Serape() != null){
								sb.append("cef3Serape : ");
								sb.append(eo.getCef3Serape());
							}
							
							if(eo.getGmaxTablet() != null){
								sb.append("gmaxTablet : ");
								sb.append(eo.getGmaxTablet());
							}
							
							if(eo.getNapa() != null){
								sb.append("napa : ");
								sb.append(eo.getNapa());
							}
							
							if(eo.getSerape() != null){
								sb.append("serape : ");
								sb.append(eo.getSerape());
							}
						}
						
						Toast.makeText(context, sb.toString(), Toast.LENGTH_SHORT).show();
					}
					
				}
				
				@Override
				public void onFailure(int statusCode, Header[] headers, byte[] resp, Throwable th) {
					// TODO Auto-generated method stub
					pd.dismiss();
					Toast.makeText(context, "Failed to Execute Selected Service...Status Code: " + statusCode + ", Ex: " + th.getMessage() , Toast.LENGTH_SHORT).show();
				}
			});
		}
	}

	private class SearchResultAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return discoverdServices.size();
		}

		@Override
		public Object getItem(int position) {
			return discoverdServices.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(R.layout.row_search_result, parent, false);
			}

			RadioButton rdoBtnServiceName = (RadioButton) convertView.findViewById(R.id.txtVwServiceName);
			TextView txtVwInputsValue = (TextView) convertView.findViewById(R.id.txtVwInputsValue);
			
			//TextView txtVwOutputValue = (TextView) convertView.findViewById(R.id.txtVwOutputValue);
			TextView txtVwInputOutputScore = (TextView) convertView.findViewById(R.id.txtVwInputOutputScore);
			TextView txtVwQoSScore = (TextView) convertView.findViewById(R.id.txtVwQoSScore);
			TextView txtVwTotalScore = (TextView) convertView.findViewById(R.id.txtVwTotalScore);
			
			DiscoveredService discoveredService = discoverdServices.get(position);
			rdoBtnServiceName.setText(discoveredService.getServiceName());
			if (selectedPos == position) {
				rdoBtnServiceName.setChecked(true);
			} else {
				rdoBtnServiceName.setChecked(false);
			}
			//txtVwInputsValue.setText(input.getInput());
			txtVwInputsValue.setText(discoveredService.getServiceProvider());
			
			//txtVwOutputValue.setText(input.getOutput());
			
			txtVwInputOutputScore.setText(discoveredService.getInputOutputScore() + "");
			txtVwQoSScore.setText(discoveredService.getQosScore() + "");
			txtVwTotalScore.setText(discoveredService.getTotalScore() + "");

			rdoBtnServiceName.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					selectedPos = position;
					try {
						searchResultAdapter.notifyDataSetChanged();
						lstSearchResult.invalidate();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});

			return convertView;
		}
	}

	private OnItemClickListener serviceSelectListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			selectedPos = position;
			searchResultAdapter.notifyDataSetChanged();
			lstSearchResult.invalidate();
		}
	};
	
	/*private void populateDummyData() {
	SearchResultDataModel tempSearch;
	for (int i = 1; i < 13; i++) {
		tempSearch = new SearchResultDataModel();
		tempSearch.setServiceName("My Service " + i);
		tempSearch.setId(i);
		tempSearch.setConditionId(AppManager.getInstance().getSelectedCondition());
		tempSearch.setSymptompId(AppManager.getInstance().getSelectedSymptom());
		tempSearch.setInputOutputScore(i * (AppManager.getInstance().getSelectedCondition() + AppManager.getInstance().getSelectedSymptom()));
		tempSearch.setQosScore(i * AppManager.getInstance().getQos()[0] + (i + 1) * AppManager.getInstance().getQos()[1] + (i + 2)
				* AppManager.getInstance().getQos()[2]);
		tempSearch.setTotalScore(tempSearch.getInputOutputScore() + tempSearch.getQosScore());
		tempSearch.setPriorityList(AppManager.getInstance().getQos());
		tempSearch.setOutputList(AppManager.getInstance().getOutputs());
		AllSearchResult.addSearchResult(tempSearch);
	}
	}*/

}
