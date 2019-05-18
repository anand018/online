package com.mail.dto;

import java.io.Serializable;

public class ShowBooksDto implements Serializable {

	private static final long serialVersionUID = -5603244217712345023L;
	private String covers;
	private String title;
	private String publisher;
	private String edition;

	public String getCovers() {
		return covers;
	}

	public void setCovers(String covers) {
		this.covers = covers;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
