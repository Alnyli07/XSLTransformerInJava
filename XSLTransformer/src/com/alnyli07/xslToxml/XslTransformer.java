package com.alnyli07.xslToxml;

import java.io.File;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

public class XslTransformer {

	private static final String TCMB_KUR = "http://www.tcmb.gov.tr/kurlar/today.xml";
	
	public static void main(String[] args) {
		 File stylesheet = new File(XslTransformer.class.getClassLoader().getResource("resources/tcmbCurencyStyle.xsl").getFile());
		 try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new URL(TCMB_KUR).openStream());
            // Use a Transformer for output
            TransformerFactory tFactory = TransformerFactory.newInstance();
            StreamSource stylesource = new StreamSource(stylesheet);
            Transformer transformer = tFactory.newTransformer(stylesource);
            DOMSource sourceDom = new DOMSource(document);
            StringWriter strwriter = new StringWriter();
            StreamResult result = new StreamResult(strwriter);
            transformer.transform(sourceDom, result);
            System.out.println(strwriter.toString());
		   } catch (Exception e){
		        	System.out.println("Exception catched !.");
		   }
	}
	
	public XslTransformer() {
		// TODO Auto-generated constructor stub
	}

}
