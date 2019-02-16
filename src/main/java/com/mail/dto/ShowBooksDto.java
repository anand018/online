package com.mail.dto;

import java.io.Serializable;

public class ShowBooksDto implements Serializable {

	private static final long serialVersionUID = -5603244217712345023L;
	private String covers;

	public String getCovers() {
		return covers;
	}

	public void setCovers(String covers) {
		this.covers = covers;
	}

	@Override
	public String toString() {
		return "ShowBooksDto [covers=" + covers + "]";
	}

}
