package info.mitcc.sax;

import info.mitcc.bean.BookStatus;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookStatusXMLHandler extends DefaultHandler {
	String tagName;
	BookStatus bookStatus;
	
	public BookStatusXMLHandler() {
		super();
	}

	public BookStatusXMLHandler(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}

	@Override
	public void startDocument() throws SAXException {
	
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tagName = localName;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(tagName.equals("sub-library"))
			bookStatus.subLibrary = new String(ch, start, length);
		if(tagName.equals("collection"))
			bookStatus.collection = new String(ch, start, length);
		if(tagName.equals("item-status"))
			bookStatus.itemStatus = new String(ch, start, length);
		if(tagName.equals("loan-status"))
			bookStatus.loanStatus = new String(ch, start, length);
		if(tagName.equals("loan-due-date"))
			bookStatus.loanDueDate = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		tagName = "";
	}

	@Override
	public void endDocument() throws SAXException {

	}
	
}
