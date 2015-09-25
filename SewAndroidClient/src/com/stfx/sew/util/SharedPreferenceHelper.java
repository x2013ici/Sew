/**
 * 
 */
package com.stfx.sew.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author Mostafijur Rahman
 *
 */
public class SharedPreferenceHelper {

	private static final String PREF_TYPE = "PrefTypeSEW";
	private static final String SELECTED_WORKFLOW = "SelectedWorkflow";
	
	public static void setSelectedWowrkflow(Context context, String workfowName){
		SharedPreferences pref = context.getSharedPreferences(PREF_TYPE, Context.MODE_PRIVATE);
		Editor editor = pref.edit();
		editor.putString(SELECTED_WORKFLOW, workfowName);
		editor.commit();
	}
	
	public static String getSelectedWorkflowName(Context context){
		return context.getSharedPreferences(PREF_TYPE, Context.MODE_PRIVATE).getString(SELECTED_WORKFLOW, "");
	}
}
