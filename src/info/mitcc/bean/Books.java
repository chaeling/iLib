package info.mitcc.bean;

import java.io.Serializable;
import java.util.*;

public class Books implements Serializable {
	private static final long serialVersionUID = -3254710560082073499L;
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
