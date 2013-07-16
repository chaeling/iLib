package info.mitcc.sax;

import info.mitcc.bean.DocNumberBean;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class DocNumberXMLParse {
	public static DocNumberBean parse(String url) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		DocNumberBean docNumberBean = new DocNumberBean();
		try {
			XMLReader xmlReader = spf.newSAXParser().getXMLReader();
			DocNumberXMLHandler handler = new DocNumberXMLHandler(docNumberBean);
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(new StringReader(url)));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return docNumberBean;
	}
}
