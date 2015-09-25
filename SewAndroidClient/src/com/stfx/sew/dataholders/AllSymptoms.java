/**
 * 
 */
package com.stfx.sew.dataholders;

import java.util.ArrayList;

import com.stfx.sew.datamodel.Symptoms;

/**
 * @author Mostafijur Rahman
 *
 */
public class AllSymptoms {

	private static ArrayList<Symptoms> allSymptom;
	public static String getSymptomName(int selectedId){
		if(allSymptom == null){
			allSymptom = new ArrayList<Symptoms>();
			Symptoms temp = new Symptoms();
			temp.setId(1);
			temp.setSymptomName("Symptom #1");
			allSymptom.add(temp);
			temp = new Symptoms();
			temp.setId(2);
			temp.setSymptomName("Symptom #2");
			allSymptom.add(temp);
			temp = new Symptoms();
			temp.setId(3);
			temp.setSymptomName("Symptom #3");
			allSymptom.add(temp);
			temp = new Symptoms();
			temp.setId(4);
			temp.setSymptomName("Symptom #4");
			allSymptom.add(temp);
		}
		
		for(int i = 0; i<allSymptom.size(); i++){
			if(allSymptom.get(i).getId() == selectedId){
				return allSymptom.get(i).getSymptomName();
			}
		}
		return "";
	}
}
