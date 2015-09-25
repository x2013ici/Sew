/**
 * 
 */
package com.stfx.sew.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author Mostafijur Rahman
 *
 */
public class NetInfo {

	public static boolean isOnline(Context context){
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo nInfo = cm.getActiveNetworkInfo();
		if(nInfo == null){
			return false;
		}
		return nInfo.isConnected();
	}
}
