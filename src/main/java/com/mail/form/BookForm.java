package com.mail.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BookForm {

	@NotBlank(message = "Title can not be empty")
	private String title;
	@NotBlank(message = "Author can not be empty")
	private String author;
	@NotBlank(message = "Edition can not be empty")
	private String edition;
	@NotBlank(message = "Publisher can not be empty")
	private String publisher;
	@NotBlank
	@Min(value = 10, message = "ISBN must be greater than 10 digits")
	private String isbn;
	@NotBlank(message = "Category can not be empty")
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
