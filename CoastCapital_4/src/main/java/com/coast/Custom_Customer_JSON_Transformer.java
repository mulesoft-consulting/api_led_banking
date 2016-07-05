package com.coast;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
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
import org.glassfish.grizzly.utils.BufferInputStream;



public class Custom_Customer_JSON_Transformer extends AbstractMessageTransformer implements DiscoverableTransformer 
{

public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException 
{
		String outValue =   " {\"CustomerList\": ["; 
		//String outValue =   "["; 
		//String outValue="";
		String indented="";
		ArrayList _custList = new ArrayList();
		
		try {
			
			Collection _collection = (Collection) message.getPayload();
			Iterator it = _collection.iterator();
			int _size = _collection.size();
			
			System.out.println("###There are "+_size+" Customer Records");
			int i=0;
			
			while (it.hasNext())
			{
				String _custJson = (String) it.next();
				_custList.add(_custJson);
				
				outValue+=_custJson;
				if(_size>1)
				{
					if(i+1<_size)
					{
						outValue+=",";
						i++;
					}
					
				}
				
			}
     
			outValue+="]}";
			//ObjectMapper mapper = new ObjectMapper();
			//Object json = mapper.readValue(outValue, Object.class);
			//indented = mapper.defaultPrettyPrintingWriter().writeValueAsString(json);
		
     
 		} 
 		catch (Exception e)
 		{
 				
 				e.printStackTrace();
 		}
	System.out.println("--------"+outValue);
 	//return outValue;
 	//return indented;
 	return _custList;
}

@Override
public int getPriorityWeighting() {
 return 0;
}

@Override
public void setPriorityWeighting(int weighting) {
}
}
