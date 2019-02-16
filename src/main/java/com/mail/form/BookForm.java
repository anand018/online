package com.mail.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BookForm {

	@NotBlank
	private String title;
	@NotBlank
	private String author;
	@NotBlank
	private String edition;
	@NotBlank
	private String publisher;
	@NotBlank
	@Min(10)
	private String isbn;
	@NotBlank
	private String category;

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
		return "BookForm [title=" + title + ", author=" + author + ", edition=" + edition + ", publisher=" + publisher
				+ ", isbn=" + isbn + ", category=" + category + "]";
	}

}
