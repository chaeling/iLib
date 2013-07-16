package info.mitcc.bean;

import java.util.*;

public class DocNumberBean {
	public List<Integer> doc_number = new ArrayList<Integer>();

	public DocNumberBean() {
		
	}

	public DocNumberBean(List<Integer> doc_number) {
		this.doc_number = doc_number;
	}

	public List<Integer> getDoc_number() {
		return doc_number;
	}

	public void setDoc_number(List<Integer> doc_number) {
		this.doc_number = doc_number;
	}
}
