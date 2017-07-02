package com.revature.bookshop.testdao;

import java.time.LocalDate;

import com.revature.bookshop.dao.AuthorDAO;
import com.revature.bookshop.model.Book;

public class TestAuthorDAO {
	public static void main(String[] args) {
		Book book = new Book();
		book.setIsbn(97887006);
		book.setTitle("Harry2");
		book.setAuthor("JKrowdy");
		book.setPublishDate(LocalDate.parse("1990-12-01"));
		book.setContent("Harry");
		book.setPrice(1200);
		book.setStatus("published");
		
		AuthorDAO author = new AuthorDAO();
		
		/* Author can create a book */
		try {
			author.insertBook(book);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		/* Author can upload the contents of book */
		try {
			author.updateContent(book);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		/* Author can view the book and contents */
		try {
			author.viewBook(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Author can delete the book */
		try {
			author.deleteBook(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Author can view all his books */
		try {
			author.viewAllBooks(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
