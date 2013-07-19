package info.mitcc.sax;

import info.mitcc.bean.Book;
import info.mitcc.bean.Books;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BooksInfoXMLHandler extends DefaultHandler {
	String tagName;
	Books booksBean = new Books();
	
	String id;
	String label;
	Book tempBook = new Book();
	
	public BooksInfoXMLHandler() {
		
	}

	public BooksInfoXMLHandler(Books books) {
		this.booksBean = books;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("--start books parsing--");
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
		if(tagName.equals("doc_number")) {
			System.out.println("--start doc_number parsing--");
			tempBook.doc_number = Integer.parseInt(new String(ch, start, length));
			System.out.println("doc_number = " + tempBook.doc_number);
		}
		else if(tagName.equals("subfield")) {
			if(id.equals("200")) {
				if(label.equals("a")) {
					tempBook.bookName = new String(ch, start, length);
					System.out.println("tempBook.bookName = " + tempBook.bookName);
				}
				if(label.equals("f")) {
					tempBook.author = new String(ch, start, length);
					System.out.println("tempBook.author = " + tempBook.author);
				}
			}
			else if(id.equals("210")) {
				if(label.equals("c"))
					tempBook.press = new String(ch, start, length);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(tagName.equals("doc_number")) {
			System.out.println("--doc_number parsing end--");
		}
			
		if(tagName.equals("subfield")) {
			System.out.println("");
			label = "";
		}
		if(tagName.equals("varfield"))
			tagName = "";
		if(tagName.equals("record")) {
			booksBean.books.add(tempBook);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("--books parsing end--");
	}
}