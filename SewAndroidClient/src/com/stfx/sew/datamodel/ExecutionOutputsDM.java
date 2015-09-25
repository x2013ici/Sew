/**
 * 
 */
package com.stfx.sew.datamodel;

import com.google.gson.annotations.SerializedName;

/**
 * @author Mostafijur Rahman
 *
 */
public class ExecutionOutputsDM {

	@SerializedName("ambrox")
	private String ambrox;
	@SerializedName("cef3Serape")
	private String cef3Serape;
	@SerializedName("gmaxTablet")
	private String gmaxTablet;
	@SerializedName("napa")
	private String napa;
	@SerializedName("serape")
	private String serape;
	public String getAmbrox() {
		return ambrox;
	}
	public void setAmbrox(String ambrox) {
		this.ambrox = ambrox;
	}
	public String getCef3Serape() {
		return cef3Serape;
	}
	public void setCef3Serape(String cef3Serape) {
		this.cef3Serape = cef3Serape;
	}
	public String getGmaxTablet() {
		return gmaxTablet;
	}
	public void setGmaxTablet(String gmaxTablet) {
		this.gmaxTablet = gmaxTablet;
	}
	public String getNapa() {
		return napa;
	}
	public void setNapa(String napa) {
		this.napa = napa;
	}
	public String getSerape() {
		return serape;
	}
	public void setSerape(String serape) {
		this.serape = serape;
	}
	
}
