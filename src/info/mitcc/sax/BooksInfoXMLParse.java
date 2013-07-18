package info.mitcc.sax;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import info.mitcc.bean.Books;

public class BooksInfoXMLParse {
	public static Books parse(String xmlUrl) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		Books book = new Books();
		try {
			XMLReader xmlReader = spf.newSAXParser().getXMLReader();
			BooksInfoXMLHandler handler = new BooksInfoXMLHandler(book);
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
		return book;
	}
}
