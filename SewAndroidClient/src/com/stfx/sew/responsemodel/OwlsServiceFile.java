package com.stfx.sew.responsemodel;

public class OwlsServiceFile {
	
	private String serviceFileName;
	public String getServiceFileName(){
		return this.serviceFileName;
	}
	public void setServiceFileName(String serviceFileName){
		this.serviceFileName = serviceFileName;
	}
	
	private String webUrl;
	public String getWebUrl(){
		return this.webUrl;
	}
	public void setWebUrl(String webUrl){
		this.webUrl = webUrl;
	}
	
	private String physicalPath;
	public String getPhysicalPath(){
		return this.physicalPath;
	}
	public void setPhysicalPath(String physicalPath){
		this.physicalPath = physicalPath;
	}
	
	private String mimeType;
	public String getMimeType(){
		return this.mimeType;
	}
	public void setMimeType(String mimeType){
		this.mimeType = mimeType;
	}
	
	private int serviceFileType;
	public int getServiceFileType(){
		return this.serviceFileType;
	}
	public void setServiceFileType(int serviceFileType){
		this.serviceFileType = serviceFileType;
	}

}
