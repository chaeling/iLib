package info.mitcc.sax;

import info.mitcc.bean.SetNumberBean;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SetNumberXMLHandler extends DefaultHandler {
	String tagName;
	SetNumberBean setNumberBean;
	
	public SetNumberXMLHandler() {
		super();
	}
	
	public SetNumberXMLHandler(SetNumberBean setNumberBean) {
		this.setNumberBean = setNumberBean;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("--set_number parsing begin--");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tagName = localName;
		if(localName.equals("find")) {
			for(int i = 0; i < attributes.getLength(); i++)
				System.out.println(attributes.getLocalName(i) + " = " + attributes.getValue(i));
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(tagName.equals("set_number"))
			setNumberBean.set_number = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		tagName = "";
		if(localName.equals("find"))
			System.out.println("set_number: " + setNumberBean.set_number);
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("--set_number parsing end--");
	}
}
