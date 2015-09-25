/**
 * 
 */
package com.stfx.sew.dataholders;

import java.util.ArrayList;

import com.stfx.sew.datamodel.Outputs;

/**
 * @author Mostafijur Rahman
 *
 */
public class AllOutputs {

	private static ArrayList<Outputs> allOutputs;
	public static String getOutputName(int outputId){
		if(allOutputs == null ){
			allOutputs = new ArrayList<Outputs>();
			Outputs temp = new Outputs();
			temp.setId(1);
			temp.setOutputName("Output #1");
			allOutputs.add(temp);
			temp = new Outputs();
			temp.setId(2);
			temp.setOutputName("Output #2");
			allOutputs.add(temp);
			temp = new Outputs();
			temp.setId(3);
			temp.setOutputName("Output #3");
			allOutputs.add(temp);
			temp = new Outputs();
			temp.setId(4);
			temp.setOutputName("Output #4");
			allOutputs.add(temp);
			temp = new Outputs();
			temp.setId(5);
			temp.setOutputName("Output #5");
			allOutputs.add(temp);
			temp = new Outputs();
			temp.setId(6);
			temp.setOutputName("Output #6");
			allOutputs.add(temp);
			temp = new Outputs();
			temp.setId(7);
			temp.setOutputName("Output #7");
			allOutputs.add(temp);
			temp = new Outputs();
			temp.setId(8);
			temp.setOutputName("Output #8");
			allOutputs.add(temp);
			temp = new Outputs();
			temp.setId(9);
			temp.setOutputName("Output #9");
			allOutputs.add(temp);
			temp = new Outputs();
			temp.setId(10);
			temp.setOutputName("Output #10");
			allOutputs.add(temp);
			temp = new Outputs();
			temp.setId(11);
			temp.setOutputName("Output #11");
			allOutputs.add(temp);
			temp = new Outputs();
			temp.setId(12);
			temp.setOutputName("Output #12");
			allOutputs.add(temp);
		}
		
		for(int i = 0; i<allOutputs.size(); i++){
			if(allOutputs.get(i).getId() == outputId){
				return allOutputs.get(i).getOutputName();
			}
		}
		
		return "";
	}
}
