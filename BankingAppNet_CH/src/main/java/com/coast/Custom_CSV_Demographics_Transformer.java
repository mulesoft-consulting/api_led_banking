package com.coast;

import java.io.StringReader;
import java.util.ArrayList;
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



public class Custom_CSV_Demographics_Transformer extends AbstractMessageTransformer implements DiscoverableTransformer {

public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException 
{
		ArrayList<CustomerDemographicsRecord> lineList = new ArrayList();
		
	
		try {
     
				String _document = message.getPayloadAsString();
				StringTokenizer lineTokenizer = new StringTokenizer(_document, "\r\n");
				//skip the header
				lineTokenizer.nextToken();
				System.out.println("There are:"+lineTokenizer.countTokens()+" lines in the doc !");
				
				
		
				while(lineTokenizer.hasMoreTokens())
				{
					String _line = lineTokenizer.nextToken();
					StringTokenizer fieldTokenizer = new StringTokenizer(_line, ",");
					
					String [] fields = new String [fieldTokenizer.countTokens()];
					
					
					int fieldCntr=0;
					while(fieldTokenizer.hasMoreTokens())
					{
						fields[fieldCntr] = fieldTokenizer.nextToken();
						fieldCntr++;
					}
						
					CustomerDemographicsRecord vo = new CustomerDemographicsRecord();
					vo.setCustId(fields[0]);
					vo.setFirstName(fields[1]);
					vo.setLastName(fields[2]);
					vo.setAddress(fields[3]);
					vo.setCity(fields[4]);
					vo.setProvince(fields[5]);
					vo.setCountry(fields[6]);
					vo.setAge(Integer.parseInt(fields[7]));
					vo.setMarried(fields[8]);
					
					lineList.add(vo);
					
				}
			
     
 		} 
 		catch (Exception e)
 		{
 				
 				e.printStackTrace();
 		}
	
 	return lineList;
}

@Override
public int getPriorityWeighting() {
 return 0;
}

@Override
public void setPriorityWeighting(int weighting) {
}
}
