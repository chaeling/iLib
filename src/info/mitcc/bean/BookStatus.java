package info.mitcc.bean;

import java.io.Serializable;

public class BookStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8633806876367065949L;
	public String subLibrary;
	public String collection;
	public String itemStatus;
	public String loanStatus;
	public String loanDueDate;
	
	public BookStatus() {
		
	}

	public BookStatus(String subLibrary, String collection, String itemStatus,
			String loanStatus, String loanDueDate) {
		this.subLibrary = subLibrary;
		this.collection = collection;
		this.itemStatus = itemStatus;
		this.loanStatus = loanStatus;
		this.loanDueDate = loanDueDate;
	}

	public String getSubLibrary() {
		return subLibrary;
	}

	public void setSubLibrary(String subLibrary) {
		this.subLibrary = subLibrary;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getLoanDueDate() {
		return loanDueDate;
	}

	public void setLoanDueDate(String loanDueDate) {
		this.loanDueDate = loanDueDate;
	}	
}
