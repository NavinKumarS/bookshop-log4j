package com.revature.bookshop.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.bookshop.model.Book;
import com.revature.bookshop.model.BookSales;
import com.revature.bookshop.util.ConnectionUtil;


public class BookOrderDAO {
	private static final Logger LOGGER = Logger.getLogger(BookOrderDAO.class);


	/* User can able to view the available books and place an order */
	
	public void orderBook(BookSales bookSales) throws Exception {
		
		// 1. Get the connection
        JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
 
        // 2. Query
        String sql = "select isbn,title,author,price from book where status = 'published'";
		
        // 3. Set the input and Query Execute
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
		LOGGER.info(books);
		
		//For Placing an order
		// 2. Query
		String orderSql = "insert into bookSales (salesId, userId, isbn, quantity, price ,totalAmount, orderDate, status) values (?, ?, ?, ?, ?, ?, ?)";
		
		// 3. Set the input and Query Execute
		int rows = jdbcTemplate.update(orderSql, bookSales.getSalesID(), bookSales.getUserID(), bookSales.getIsbn(), bookSales.getQuantity(), bookSales.getPrice(), bookSales.getTotalAmount(), bookSales.getOrderDate(), bookSales.getStatus());
		System.out.println("No of rows inserted: " + rows);
		if(rows == 1)
			System.out.println("Order Successful!!");
	}
	
	/* User can select the quantity of books */ 
	
	public void selectQuantity(BookSales bookSales) throws Exception {
		
		// 1. Get the connection
		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
        
        // 2. Query
		String sql = "update bookSales set quantity=? where salesId=? and userId=?";
		
		// 3. Set the input and Query execute
		int rows = jdbcTemplate.update(sql, bookSales.getQuantity(), bookSales.getSalesID(), bookSales.getUserID());
		System.out.println("No of rows inserted: " + rows);
	}
	
	/* User can cancel the book order */
	public void cancelOrder(BookSales bookSales) throws Exception {
		// 1. Get the connection
		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	        
	    // 2. Query
		String sql = "update bookSales set status='CANCELLED' where salesId=? and userId=?";
			
		// 3. Set the input and Query execute
		int rows =jdbcTemplate.update(sql, bookSales.getSalesID(), bookSales.getUserID());
		System.out.println("No of rows Updated: " + rows);
		if(rows == 1)
			System.out.println("Order Cancelled!!");
		}
}