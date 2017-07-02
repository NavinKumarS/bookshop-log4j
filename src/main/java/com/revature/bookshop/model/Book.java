package com.revature.bookshop.model;

import java.time.LocalDate;

import org.apache.log4j.Logger;


public class Book {
	private static final Logger LOGGER = Logger.getLogger(Book.class);

	private  long isbn;
	private String title;
	private String author;
	private LocalDate publishDate;
	private String content;
	private double price;
	private String status;
	
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
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
	
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publishDate=" + publishDate
				+ ", content=" + content + ", price=" + price + ", status=" + status + "]";
	}
}
