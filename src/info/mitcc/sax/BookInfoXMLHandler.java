package info.mitcc.sax;

import info.mitcc.bean.BookBean;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookInfoXMLHandler extends DefaultHandler {
	String tagName;
	BookBean bookBean;
	
	String id;
	String label;
	
	public BookInfoXMLHandler() {
		super();
	}

	public BookInfoXMLHandler(BookBean bookBean) {
		this.bookBean = bookBean;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("--book details parsing begin--");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tagName = localName;
		if(tagName.equals("varfield")) 
			id = attributes.getValue(0);
		if(tagName.equals("subfield"))
			label = attributes.getValue(0);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(tagName.equals("doc_number"))
			bookBean.doc_number.add(Integer.parseInt(new String(ch, start, length)));
		else if(tagName.equals("subfield")) {
			if(id.equals("200")) {
				if(label.equals("a"))
					bookBean.bookName.add(new String(ch, start, length).toString());//.toString();
				if(label.equals("f"))
					bookBean.author.add(new String(ch, start, length).toString());//.toString();
			}
			else if(id.equals("210")) {
				if(label.equals("c"))
					bookBean.press.add(new String(ch, start, length).toString());//.toString();
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(tagName.equals("subfield"))
			label = "";
		if(tagName.equals("varfield"))
			id = "";
		tagName = "";
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("--book details parsing end--");
	}
}
