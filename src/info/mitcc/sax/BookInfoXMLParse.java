package info.mitcc.sax;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import info.mitcc.bean.BookBean;

public class BookInfoXMLParse {
	public static BookBean parse(String url) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		BookBean bookBean = new BookBean();
		try {
			XMLReader xmlReader = spf.newSAXParser().getXMLReader();
			BookInfoXMLHandler handler = new BookInfoXMLHandler(bookBean);
			xmlReader.setContentHandler(handler);
			
			InputSource xml = new InputSource(new StringReader(url));
			xml.setEncoding("gb2312");
			xmlReader.parse(xml);

//			xmlReader.parse(new InputSource(new StringReader(url)));
			
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
