package com.stfx.sew;


import com.stfx.sew.sewservices.SewServiceManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * 
 * @author Mostafijur Rahman
 * @since 20th April, 2015
 */
public class LoginActivity extends Activity {

	/*public final static String SAMPLE_XML =
	        "<?xml version=\"1.0\"?>\n"+
	        "\n"+
	        "<poem xmlns=\"http://www.megginson.com/ns/exp/poetry\">\n"+
	        "<title>Roses are Red</title>\n"+
	        "<l>Roses are red,</l>\n"+
	        "<l>Violets are blue;</l>\n"+
	        "<l>Sugar is sweet,</l>\n"+
	        "<l>And I love you.</l>\n"+
	        "</poem>";
	
	public final static String TASKS_XML =
			"<?xml version=\"1.0\"?>"+
			"<Tasks>"+
					"<Task Id=\"1\">"+
						"<Task_Name>Task 1</Task_Name>"+
						"<Task_Price>400</Task_Price>"+
					"</Task>"+
			"</Tasks>";*/
				
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
    }
    
    public void login(View v){
    	
    	//Intent intent = new Intent(this, ChooseOptionActivity.class);
    	//Intent intent = new Intent(this, BlockingQueueActivity.class);
    	//Intent intent = new Intent(this, ParseWorkflowActivity.class);
    	
    	//InputConceptActivity
    	//Intent intent = new Intent(this, InputConceptActivity.class);
    	
    	
    	//TaskExecutionRuleActivity
    	//Intent intent = new Intent(this, TaskExecutionRuleActivity.class);
    	//QoSInputActivity
    	//Intent intent = new Intent(this, QoSInputActivity.class);
    	
    	Intent intent = new Intent(this, WorkflowSelectActivity.class);
    	startActivity(intent);
    }
    
    public void signup(View v){
    	
    	Toast.makeText(this, "Not implemented yet", Toast.LENGTH_SHORT).show();
    	
    	/*try{
    		ParseXML parseXML = new ParseXML();
        	parseXML.fetchXML();
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    	}*/
    }
    
    

}
