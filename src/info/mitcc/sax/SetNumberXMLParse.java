package info.mitcc.sax;

import info.mitcc.bean.SetNumberBean;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SetNumberXMLParse {
	public static SetNumberBean parse(String xmlUrl) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SetNumberBean setNumberBean = new SetNumberBean();
		try {
			XMLReader xmlReader = spf.newSAXParser().getXMLReader();
			SetNumberXMLHandler handler = new SetNumberXMLHandler(setNumberBean);
			xmlReader.setContentHandler(handler);
			URL url = new URL(xmlUrl);
			xmlReader.parse(new InputSource(url.openStream()));
//			xmlReader.parse(new InputSource(new StringReader(xmlUrl)));//解析中文会出现乱码
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
