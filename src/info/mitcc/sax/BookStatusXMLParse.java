package info.mitcc.sax;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import info.mitcc.bean.BookStatus;

public class BookStatusXMLParse {
	public static BookStatus parse(String xmlUrl) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		BookStatus bookStatus = new BookStatus();
		try {
			XMLReader xmlReader = spf.newSAXParser().getXMLReader();
			BookStatusXMLHandler handler = new BookStatusXMLHandler(bookStatus);
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
		return bookStatus;
	}
}
