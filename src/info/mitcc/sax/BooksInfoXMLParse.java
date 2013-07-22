package info.mitcc.sax;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import info.mitcc.bean.Book;

public class BooksInfoXMLParse {
	public static List<Book> parse(String xmlUrl) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		List<Book> list = new ArrayList<Book>();
		try {
			XMLReader xmlReader = spf.newSAXParser().getXMLReader();
			BooksInfoXMLHandler handler = new BooksInfoXMLHandler(list);
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
