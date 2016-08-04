package com.coast;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.codehaus.jackson.map.ObjectMapper;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

import com.coast.loans.CustomerLoans;



public class Custom_Loans_Transformer extends AbstractMessageTransformer implements DiscoverableTransformer {

public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException 
{
		CustomerLoans _retCustLoans = null;
		String _custId;
	
	
		try {
				_custId = message.getInvocationProperty("_cust_id");
				List _curCustLoansList = (List) message.getPayload();
				Iterator _it = _curCustLoansList.iterator();
				while (_it.hasNext())
				{
					CustomerLoans _custLoans = (CustomerLoans) _it.next();
					
					if(_custLoans.getCustId().equals(_custId))
					{
						_retCustLoans=_custLoans;
						break;
					}
				}
				
			
     
 		} 
 		catch (Exception e)
 		{
 				
 				e.printStackTrace();
 		}
	
 	return _retCustLoans;
}

@Override
public int getPriorityWeighting() {
 return 0;
}

@Override
public void setPriorityWeighting(int weighting) {
}
}
