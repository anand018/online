package com.mail.dto;

import java.io.Serializable;
import java.util.Arrays;

public class ShowBooksDto implements Serializable {

	private static final long serialVersionUID = -5603244217712345023L;
	private byte[] covers;
	private String title;
	private String publisher;
	private String edition;

	public byte[] getCovers() {
		return covers;
	}

	public void setCovers(byte[] covers) {
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

	@Override
	public String toString() {
		return "ShowBooksDto [covers=" + Arrays.toString(covers) + ", title=" + title + ", publisher=" + publisher
				+ ", edition=" + edition + "]";
	}

}
