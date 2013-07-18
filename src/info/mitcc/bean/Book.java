package info.mitcc.bean;

public class Book {
	public int doc_number;
	public String bookName;
	public String author;
	public String press;
	
	public Book() {

	}

	public Book(int doc_number, String bookName, String author, String press) {
		this.doc_number = doc_number;
		this.bookName = bookName;
		this.author = author;
		this.press = press;
	}

	public int getDoc_number() {
		return doc_number;
	}

	public void setDoc_number(int doc_number) {
		this.doc_number = doc_number;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}
}
