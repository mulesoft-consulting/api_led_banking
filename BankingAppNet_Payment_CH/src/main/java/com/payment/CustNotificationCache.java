package com.payment;

import java.util.HashMap;

public class CustNotificationCache 
{
	private static CustNotificationCache  _instance= null;
	private static HashMap _notificationMap;
	
	public CustNotificationCache()
	{
		_notificationMap = new HashMap();
	}
	
	public static CustNotificationCache getInstance()
	{
		if(_instance==null)
			_instance = new CustNotificationCache();
		return _instance;
	}
	
	public static void addToCache(String pKey, String pPayload)
	{
		_notificationMap.put(pKey, pPayload);
		
	}
	public static String getFromCache(String pKey)
	{
		return (String )_notificationMap.get(pKey);
	}

}
