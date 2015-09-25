package com.stfx.sew.responsemodel;

import java.util.ArrayList;

public class OwlsService {
	
	private int id;
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	private String serviceName;
	public String getServiceName(){
		return serviceName;
	}
	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}
	
	private String rootServiceUrl;
	public String getRootServiceUrl(){
		return this.rootServiceUrl;
	}
	public void setRootServiceUrl(String rootServiceUrl){
		this.rootServiceUrl = rootServiceUrl;
	}
	
	private String serviceDescription;
	public String getServiceDescription(){
		return this.serviceDescription;
	}
	public void setServiceDescription(String serviceDescription){
		this.serviceDescription = serviceDescription;
	}
	
	private String serviceProvider;
	public String getServiceProvider(){
		return this.serviceProvider;
	}
	public void setServiceProvider(String serviceProvider){
		this.serviceProvider = serviceProvider;
	}
	
	private String publishedDateTime;
	public String getPublishedDateTime(){
		return this.publishedDateTime;
	}
	public void setPublishedDateTime(String publishedDateTime){
		this.publishedDateTime = publishedDateTime;
	}
	
	private ArrayList<OwlsServiceFile> owlsServiceList;
	public ArrayList<OwlsServiceFile> getOwlsServiceList(){
		return this.owlsServiceList;
	}
	public void setOwlsServiceList(ArrayList<OwlsServiceFile> owlsServiceFileList){
		this.owlsServiceList = owlsServiceFileList;
	}

}
