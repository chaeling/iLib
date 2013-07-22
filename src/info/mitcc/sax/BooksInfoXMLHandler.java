package info.mitcc.sax;

import java.util.*;

import info.mitcc.bean.Book;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BooksInfoXMLHandler extends DefaultHandler {
	String tagName;	
	List<Book> booksList;
	String id;
	String label;
	Book tempBook;
	
	public BooksInfoXMLHandler() {
		
	}

	public BooksInfoXMLHandler(List<Book> booksList) {
		super();
		this.booksList = booksList;
	}

	@Override
	public void startDocument() throws SAXException {
		
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tagName = localName;
		if(tagName.equals("record")) {
			tempBook = new Book();
		}
		if(tagName.equals("varfield")) 
			id = attributes.getValue(0);
		if(tagName.equals("subfield"))
			label = attributes.getValue(0);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(tagName.equals("doc_number")) {
			tempBook.doc_number = Integer.parseInt(new String(ch, start, length));
		}
		else if(tagName.equals("subfield")) {
			if(id.equals("200")) {
				if(label.equals("a")) {
					tempBook.bookName = new String(ch, start, length);
				}
				if(label.equals("f")) {
					tempBook.author = new String(ch, start, length);
				}
			}
			else if(id.equals("210")) {
				if(label.equals("c")) {
					tempBook.press = new String(ch, start, length);
				}
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(localName.equals("record")) {
			booksList.add(tempBook);
		}
		tagName = "";
	}

	@Override
	public void endDocument() throws SAXException {
		
	}
}
