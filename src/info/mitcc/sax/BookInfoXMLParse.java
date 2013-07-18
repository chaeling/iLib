package info.mitcc.sax;

import info.mitcc.bean.BookBean;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class BookInfoXMLParse {
	public static BookBean parse(String xmlUrl) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		BookBean bookBean = new BookBean();
		try {
			XMLReader xmlReader = spf.newSAXParser().getXMLReader();
			BookInfoXMLHandler handler = new BookInfoXMLHandler(bookBean);
			xmlReader.setContentHandler(handler);

			URL url = new URL(xmlUrl);
			xmlReader.parse(new InputSource(url.openStream()));

//			xmlReader.parse(new InputSource(new StringReader(xmlUrl)));//解析中文会出现乱码
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookBean;
	}
}
