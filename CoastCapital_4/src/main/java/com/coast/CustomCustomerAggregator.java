package com.coast;


import java.util.ArrayList;

import java.util.List;
import java.util.Iterator;

import org.codehaus.jackson.map.ObjectMapper;
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


public class CustomCustomerAggregator implements MuleContextAware,Callable
{
	private static int cntr =0;
	private static int maxItems=0;
	private static MuleContext muleContext;
	private static MuleEventContext eventContext;
	private static boolean _loaded=false;
	private static ArrayList _productList;
	private static ObjectStoreConnector objStoreModule;
	private static ArrayList _custList=null;
	
	public CustomCustomerAggregator()
	{
		//init();
	}
	private void init()
	{
		System.out.println("In product Agregator init");
		_productList = new ArrayList();
		
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
	}
		
	private static void updateList(MuleEventContext eventContext)
	{
		MuleMessage message = eventContext.getMessage();
		String _custPayload;
		String _custReqId = message.getInvocationProperty("cust_req_id");
		System.out.println("Doing work for CustReqID:"+_custReqId);
		//ArrayList _custList=null;
		
		try
		{
			 _custPayload = message.getPayloadAsString();	
			 
			 if(objStoreModule.contains(_custReqId))
			 {
				 
				//  _custList  =  (ArrayList) objStoreModule.retrieve(_custReqId,null, null, null, eventContext.getMessage());
				
				  if(_custList==null)
					  System.out.println("YELLLLLLL");
				  
				  _custList.add(_custPayload);
				  System.out.println("+++Added CustRecord "+_custList.size());
				
				  
			 }
			 else
			 {
				 System.out.println("Creating Customer List:"+_custReqId);
			 		_custList = new ArrayList();
			 		_custList.add(_custPayload);
			 		objStoreModule.store(_custReqId, _custList, true);	
			 		//System.out.println("+++Added CustRecord 1:");
			 		System.out.println("+++Added CustRecord "+_custList.size());
			 		
			 }
			
		 	
		 		
		}
		catch(ObjectStoreNotAvaliableException excp){
			
			System.out.println("the store is not available or any other implementation-specific error occured.");
			excp.printStackTrace();
		}
		
		catch(ObjectDoesNotExistException excp){
			
			System.out.println("no value for the given key was previously stored.");
			excp.printStackTrace();
			
		}
		catch(ObjectStoreException excp){
			
			System.out.println("Key:"+ _custReqId+" is NULL");
			excp.printStackTrace();
			
		}
		catch(Exception pExcp)
		{
			pExcp.printStackTrace();
		}
		
		
	}
	
	@Override
	public void setMuleContext(MuleContext context) {
		// TODO Auto-generated method stub
		muleContext=context;
	}
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		// TODO Auto-generated method stub
		this.eventContext = eventContext;
		if(!_loaded)
			init();
		
		updateList(eventContext);
		
		return null;
	}
	private static String formatJSON(String pStr)
	{
		String retVal=null;
	
		try
		{
			
			ObjectMapper mapper = new ObjectMapper();
			Object json = mapper.readValue(pStr, Object.class);
			retVal = mapper.defaultPrettyPrintingWriter().writeValueAsString(json);
		}
		catch(Exception pExcp)
		{
			pExcp.printStackTrace();
		}
		
		return retVal;
	}

}