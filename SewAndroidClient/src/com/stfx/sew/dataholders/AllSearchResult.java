/**
 * 
 */
package com.stfx.sew.dataholders;

import java.util.ArrayList;

import com.stfx.sew.datamodel.DiscoveredService;

/**
 * @author Mostafijur Rahman
 *
 */
public class AllSearchResult {

	private static ArrayList<DiscoveredService> searchResults;
	public static void removeAll(){
		searchResults.clear();
	}
	
	public static void addSearchResult(DiscoveredService searchResult){
		if(searchResults == null){
			searchResults = new ArrayList<DiscoveredService>();
		}
		searchResults.add(searchResult);
	}
	
	public static void addAllSearchResults(ArrayList<DiscoveredService> allSearchResults){
		removeAll();
		searchResults = allSearchResults;
	}
	
	public static ArrayList<DiscoveredService> getAllSearchResults(){
		if(searchResults == null){
			searchResults = new ArrayList<DiscoveredService>();
		}
		
		return searchResults;
	}
}
