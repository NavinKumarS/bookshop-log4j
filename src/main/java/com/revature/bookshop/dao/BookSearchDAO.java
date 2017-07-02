package com.revature.bookshop.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.bookshop.model.Book;
import com.revature.bookshop.util.ConnectionUtil;


public class BookSearchDAO {
	private static final Logger LOGGER = Logger.getLogger(BookSearchDAO.class);

	/* List all books */
	
	public void ViewAllBooks() throws Exception {
		
		// 1. Get the connection
        JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
 
        // 2. Query
		String sql = "select * from book";
		
		// 3. Set the input and Query execute
		List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
		LOGGER.info(books);
	}
	
	/* Search by title */
	public void searchByTitle(Book book) throws Exception {
		
		// 1. Get the connection
		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
		
        // 2. Query
        String sql = "select * from book where title=?";
		
        // 3. Set the input and Query execute
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), book.getTitle());
		System.out.println(books);
	}
	
	/* Search by Author */
	public void searchByAuthor(Book book) throws Exception {
		
		// 1. Get the connection
				JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
				
		        // 2. Query
		        String sql = "select * from book where author=?";
				
		        // 3. Set the input and Query execute
		        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), book.getAuthor());
				System.out.println(books);
	}
	
	/* Search by price range */
		
	public void searchByPrice(double minPrice, double maxPrice) throws Exception {
		// 1. Get the connection
		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
			
	    // 2. Query
		String sql = "select * from book where price between ? and ?";
				
        // 3. Set the input and Query execute
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), minPrice, maxPrice);
		System.out.println(books);
	}

	/* Search by Isbn */
	public void searchByIsbn(Book book) throws Exception {
		
		// 1. Get the connection
				JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
				
		        // 2. Query
		        String sql = "select * from book where isbn=?";
				
		        // 3. Set the input and Query execute
		        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), book.getIsbn());
				System.out.println(books);
	}
}