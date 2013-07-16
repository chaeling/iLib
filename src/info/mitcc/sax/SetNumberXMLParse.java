package info.mitcc.sax;

import info.mitcc.bean.SetNumberBean;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SetNumberXMLParse {
	public static SetNumberBean parse(String url) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SetNumberBean setNumberBean = new SetNumberBean();
		try {
			XMLReader xmlReader = spf.newSAXParser().getXMLReader();
			SetNumberXMLHandler handler = new SetNumberXMLHandler(setNumberBean);
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(new StringReader(url)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return setNumberBean;
	}
}
