/**
 * 
 */
package com.stfx.sew.dataholders;

import java.util.ArrayList;

import com.stfx.sew.datamodel.Conditions;

/**
 * @author Mostafijur Rahman
 *
 */
public class AllConditions {

	private static ArrayList<Conditions> allConditions;
	public static String getConditionName(int selectedId){
		if(allConditions == null){
			allConditions = new ArrayList<Conditions>();
			Conditions temp = new Conditions();
			temp.setConditionId(1);
			temp.setConditionName("Condition #1");
			allConditions.add(temp);
			temp = new Conditions();
			temp.setConditionId(2);
			temp.setConditionName("Condition #2");
			allConditions.add(temp);
		}
		for(int i = 0; i<allConditions.size(); i++){
			if(allConditions.get(i).getConditionId() == selectedId){
				return allConditions.get(i).getConditionName();
			}
		}
		return "";
	}
}
