package info.mitcc.bean;

import java.util.*;

public class Books {
	public List<Book> books = new ArrayList<Book>();

	public Books() {
		
	}

	public Books(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
