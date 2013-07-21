package info.mitcc.sax;

import java.util.List;

import info.mitcc.bean.BookStatus;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BooksStatusXMLHandler extends DefaultHandler {
	String tagName;
	List<BookStatus> statusList;
	BookStatus tempBookStatus;
	
	public BooksStatusXMLHandler() {

	}

	public BooksStatusXMLHandler(List<BookStatus> statusList) {
		super();
		this.statusList = statusList;
	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tagName = localName;
		if(tagName.equals("item"))
			tempBookStatus = new BookStatus();
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(tagName.equals("sub-library"))
			tempBookStatus.subLibrary = new String(ch, start, length);
		if(tagName.equals("collection"))
			tempBookStatus.collection = new String(ch, start, length);
		if(tagName.equals("item-status"))
			tempBookStatus.itemStatus = new String(ch, start, length);
		if(tagName.equals("loan-status"))
			tempBookStatus.loanStatus = new String(ch, start, length);
		if(tagName.equals("loan-due-date"))
			tempBookStatus.loanDueDate = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(localName.equals("item"))
			statusList.add(tempBookStatus);
		tagName = "";
	}

	@Override
	public void endDocument() throws SAXException {
		
	}
	
}
