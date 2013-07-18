package info.mitcc.bean;

import java.util.*;

public class BookBean {	
	public List<Integer> doc_number = new ArrayList<Integer>();
	public List<String> bookName = new ArrayList<String>();
	public List<String> author = new ArrayList<String>();
	public List<String> press = new ArrayList<String>();
	
	public BookBean() {
		
	}

	public BookBean(List<Integer> doc_number, List<String> bookName,
			List<String> author, List<String> press) {
		this.doc_number = doc_number;
		this.bookName = bookName;
		this.author = author;
		this.press = press;
	}

	public List<Integer> getDoc_number() {
		return doc_number;
	}

	public void setDoc_number(List<Integer> doc_number) {
		this.doc_number = doc_number;
	}

	public List<String> getBookName() {
		return bookName;
	}

	public void setBookName(List<String> bookName) {
		this.bookName = bookName;
	}

	public List<String> getAuthor() {
		return author;
	}

	public void setAuthor(List<String> author) {
		this.author = author;
	}

	public List<String> getPress() {
		return press;
	}

	public void setPress(List<String> press) {
		this.press = press;
	}
}