package info.mitcc.sax;

import info.mitcc.bean.BookStatus;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class BooksStatusXMLParse {
	public static List<BookStatus> parse(String xmlUrl) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		List<BookStatus> list = new ArrayList<BookStatus>();
		try {
			XMLReader xmlReader = spf.newSAXParser().getXMLReader();
			BooksStatusXMLHandler handler = new BooksStatusXMLHandler(list);
			xmlReader.setContentHandler(handler);
			
			URL url = new URL(xmlUrl);
			xmlReader.parse(new InputSource(url.openStream()));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
