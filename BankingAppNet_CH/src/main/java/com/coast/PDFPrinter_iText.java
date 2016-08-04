/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coast;



import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.joda.time.LocalDateTime;
import org.mule.api.MuleContext;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Callable;

/**
 * Examples of various different ways to print PDFs using PDFBox.
 */
public final class PDFPrinter_iText implements MuleContextAware,Callable
{
    private PDFPrinter_iText()
    {
    }   

   

    /**
     * Prints the document at its actual size. This is the recommended way to print.
     */
    private static void print(String pFileName,String pPayload) throws IOException, Exception
    {
    	 Document document = new Document();
         // step 2
         PdfWriter.getInstance(document, new FileOutputStream(pFileName));
         // step 3
         document.open();
         // step 4
         String _dateTime = LocalDateTime.now().toString();
         document.addTitle("List of All Customers & their assets as of: "+_dateTime);
         document.addCreationDate();
         document.addSubject("List of All Customers & their assets as of: "+_dateTime);
         
         
        
         Font _font = new Font();
         _font.setColor(BaseColor.BLUE);
         _font.setStyle(Font.BOLD);
         _font.setSize(15);
         
         Chunk _chunk = new Chunk("List of All Customers & their assets as of: "+_dateTime);
         _chunk.setFont(_font);
         Paragraph _header = new Paragraph();
         _header.add(_chunk);
         document.add(_header);
         document.add(new Paragraph(pPayload));
        
         // step 5
         document.close();
    }

  
   
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		// TODO Auto-generated method stub
		
		MuleMessage _message = eventContext.getMessage();
		String _fileName = _message.getInvocationProperty("file_name");
		String _dirName = _message.getInvocationProperty("dest_directory");
		String _path=_dirName+"/"+_fileName;
		System.out.println("Transformig to PDF file:"+_path);
		
		//byte [] _bytePayload = eventContext.getMessage().getPayloadAsBytes();
	        
	        // choose your printing method:
	        print(_path,eventContext.getMessage().getPayloadAsString()); 
		
		return null;
	}

	@Override
	public void setMuleContext(MuleContext context) {
		// TODO Auto-generated method stub
		
	}
}
