package com.mail.dto;

import java.io.Serializable;

public class AddBookDto implements Serializable {

	private static final long serialVersionUID = -666067836016166638L;
	private String title;
	private String author;
	private String edition;
	private String publisher;
	private String isbn;
	private String category;
	private byte[] coverPage;
	private byte[] originalBook;

	public byte[] getCoverPage() {
		return coverPage;
	}

	public void setCoverPage(byte[] coverPage) {
		this.coverPage = coverPage;
	}

	public byte[] getOriginalBook() {
		return originalBook;
	}

	public void setOriginalBook(byte[] originalBook) {
		this.originalBook = originalBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "AddBookDto [title=" + title + ", author=" + author + ", edition=" + edition + ", publisher=" + publisher
				+ ", isbn=" + isbn + ", category=" + category + "]";
	}

}
