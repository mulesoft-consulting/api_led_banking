package com.payment;

import java.util.ArrayList;
import java.util.HashMap;

import org.mule.api.MuleContext;
import org.mule.api.MuleEventContext;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Callable;
import org.mule.DefaultMuleEvent;
import org.mule.DefaultMuleMessage;
import org.mule.MessageExchangePattern;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.context.MuleContextAware;
import org.mule.api.store.ObjectDoesNotExistException;
import org.mule.api.store.ObjectStoreException;
import org.mule.api.store.ObjectStoreNotAvaliableException;
import org.mule.api.transport.MuleMessageFactory;
import org.mule.construct.Flow;
//import org.mule.modules.ObjectStoreModule;
import org.mule.modules.objectstore.*;
import org.mule.api.lifecycle.Callable;

public class CustomCache implements MuleContextAware,Callable
{

	private static HashMap pNotificationMap;
	private static MuleContext muleContext;
	private static MuleEventContext eventContext;
	private static ObjectStoreConnector objStoreModule;
	private static boolean _loaded=false;
	
	private static CustNotificationCache _notificationCache ;
	
	public CustomCache()
	{
		 init();
	}
	private void init()
	{
		System.out.println("In product Custom Cahce init");
		
		_notificationCache = CustNotificationCache.getInstance();
	/*
		try
		{
			objStoreModule = muleContext.getRegistry().lookupObject("MyObjectStore");		
			
			if(objStoreModule!=null)
			{
				System.out.println("---Found MyObjectStore !--- ");
				_loaded=true;
			}
			else 
				System.out.println("No Object Store - ObjectStore_Connector found");
		
		}
		catch(Exception excp)
		{
			excp.printStackTrace();
		}
		*/
	}
	private String updateCache(MuleEventContext eventContext)
	{
		String _custPayload=null;
		String _retVal=null;
	
		try
		{
				_custPayload = eventContext.getMessage().getPayloadAsString();
				if(_custPayload.contains("Account"))
				{
					 //_retVal  =  (String) objStoreModule.retrieve("NOTIFICATION_RESPONSE",null, null, null, eventContext.getMessage());
					_retVal = (String) _notificationCache.getFromCache("NOTIFICATION_RESPONSE");
					System.out.println("Retrieved NOTIFICATION_RESPONSE from cache !");
					
				}
				if(_custPayload.contains("SourceAcountBalance") || _custPayload.contains("DestinationAcountBalance"))
				{
					 
				 		
				 		//objStoreModule.store("NOTIFICATION_RESPONSE", _custPayload, true);	
					_notificationCache.addToCache("NOTIFICATION_RESPONSE", _custPayload);
				 		_retVal=_custPayload;
				 		System.out.println("Added NOTIFICATION_RESPONSE to cache !");
				}
			
				
			 		
		}
		catch(Exception excp)
		{
			excp.printStackTrace();
		}
		return _retVal;
	}
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		// TODO Auto-generated method stub
		this.eventContext = eventContext;
		if(!_loaded)
			init();
		
		updateCache(eventContext);
		return null;
	}

	@Override
	public void setMuleContext(MuleContext context) {
		// TODO Auto-generated method stub
		this.muleContext = context;
		
	}

}
