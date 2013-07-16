package info.mitcc.sax;

import info.mitcc.bean.DocNumberBean;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DocNumberXMLHandler extends DefaultHandler {
	String tagName;
	DocNumberBean docNumberBean;
	
	public DocNumberXMLHandler() {
		super();
	}

	public DocNumberXMLHandler(DocNumberBean docNumberBean) {
		this.docNumberBean = docNumberBean;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("--doc_nubmer parsing begin--");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tagName = localName;
		if(localName.equals("record")) {
			for(int i = 0; i < attributes.getLength(); i++)
				System.out.println(attributes.getLocalName(i) + " = " + attributes.getValue(i));
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(tagName.equals("doc_number"))
			docNumberBean.doc_number.add(Integer.parseInt(new String(ch, start, length)));
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		tagName = "";
		if(localName.equals("doc_number"))
			System.out.println("doc_number: " + docNumberBean.doc_number);
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("--doc_number parsing end--");
	}
	
}
