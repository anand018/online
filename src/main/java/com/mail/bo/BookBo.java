package com.mail.bo;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BookBo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title", length = 100, nullable = false)
	private String title;

	@Column(name = "author", length = 100, nullable = false)
	private String author;

	@Column(name = "edition", length = 100, nullable = false)
	private String edition;

	@Column(name = "publisher", length = 100, nullable = false)
	private String publisher;

	@Column(name = "isbn", length = 100, nullable = false)
	private String isbn;

	@Column(name = "category", length = 100, nullable = false)
	private String category;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "coverPage", length = 100, nullable = false)
	private byte[] coverPage;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "originalBook", length = 100, nullable = false)
	private byte[] originalBook;

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

	@Override
	public String toString() {
		return "BookBo [id=" + id + ", title=" + title + ", author=" + author + ", edition=" + edition + ", publisher="
				+ publisher + ", isbn=" + isbn + ", category=" + category + ", coverPage=" + Arrays.toString(coverPage)
				+ ", originalBook=" + Arrays.toString(originalBook) + "]";
	}
	
}
