package com.stfx.cli.sew.repository;

import java.util.ArrayList;

import com.stfx.cli.sew.datamodels.Service;


public class RepositoryHelper {
	
	public static ArrayList<Service> getServiceList(){
		
		ArrayList<Service> serviceList = new ArrayList<Service>();
		try{
			
			//Insert Napa Service
			Service napaService = new Service();
			napaService.setServiceProvider("St. Francies Xavier University");
			napaService.setServiceName("Napa Service");
			napaService.setInputOutputScore(15);
			napaService.setQosScore(7);
			napaService.setTotalScore(15, 7);
			serviceList.add(napaService);
			
			//Insert Serape Service
			Service serapeService = new Service();
			serapeService.setServiceProvider("Center for Logic and Information");
			serapeService.setServiceName("Serape Service");
			serapeService.setInputOutputScore(16);
			serapeService.setQosScore(8);
			serapeService.setTotalScore(16, 8);
			serviceList.add(serapeService);
		}
		catch(Exception ex){
			return null;
		}
		return serviceList;
	}

}
